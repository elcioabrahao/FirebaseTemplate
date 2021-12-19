package br.com.alfa11.firebasetemplate.ui.recipe

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.alfa11.firebasetemplate.R
import br.com.alfa11.firebasetemplate.data.Recipe
import br.com.alfa11.firebasetemplate.ui.recipe.adapter.RecipeListener
import br.com.alfa11.firebasetemplate.viewmodel.RecipeViewModel
import com.devedu.CadrastoDeNomes.Views.RecipeAdapter
import com.google.firebase.firestore.FirebaseFirestore

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
        val recycler = root.findViewById<RecyclerView>(R.id.recycler_list)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter


        mListener = object : RecipeListener {
            override fun onClick(id: String?) {
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
//        mViewModel.recipeResponse.observe(viewLifecycleOwner, Observer {
//            it.recipes?.let { list ->
//                Log.d("RecipeViewModel","tamanho:"+list.size)
//                mAdapter.updateRecipes(list)
//            }
//        })

        mViewModel.recipeResponse.observe(viewLifecycleOwner) {

                Log.d("RecipeViewModel","tamanho:"+it.recipes!!.size)
                mAdapter.updateRecipes(it.recipes!!)

        }
    }

}