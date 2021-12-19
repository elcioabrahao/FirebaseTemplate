package br.com.alfa11.firebasetemplate.ui.recipe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.alfa11.firebasetemplate.R
import br.com.alfa11.firebasetemplate.ui.recipe.adapter.RecipeListener
import br.com.alfa11.firebasetemplate.viewmodel.RecipeViewModel
import com.devedu.CadrastoDeNomes.Views.RecipeAdapter


class RecipeListFragment : Fragment() {

    private val mAdapter: RecipeAdapter = RecipeAdapter()
    private lateinit var mListener: RecipeListener
    private lateinit var mViewModel: RecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        observe()

        val root = inflater.inflate(R.layout.fragment_recipe_list, container, false)
        val recycler = root.findViewById<RecyclerView>(R.id.recipe_recycler_list)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter


        mListener = object : RecipeListener {
            override fun onClick(id: String?) {
                Log.d("RecipeViewModel","Recipe ID:"+ id)
//                val intent = Intent(context, NomesFormActivity::class.java)
//                val bundle = Bundle()
//                bundle.putInt(NomesConstants.GUESTID, id)
//                intent.putExtras(bundle)
//                startActivity(intent)
            }
        }
        return root
    }

    override fun onResume() {
        super.onResume()
        mAdapter.attachListener(mListener)
        mViewModel.getAllRecipes()
    }

    private fun observe() {

        mViewModel.recipeResponse.observe(viewLifecycleOwner) {

                Log.d("RecipeViewModel","tamanho:"+it.recipes!!.size)
                mAdapter.updateRecipes(it.recipes!!)

        }
    }

}