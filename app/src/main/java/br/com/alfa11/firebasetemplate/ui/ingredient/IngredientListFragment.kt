package br.com.alfa11.firebasetemplate.ui.ingredient

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import br.com.alfa11.firebasetemplate.R
import br.com.alfa11.firebasetemplate.ui.ingredient.adapter.IngredientAdapter
import br.com.alfa11.firebasetemplate.ui.ingredient.adapter.IngredientListener
import br.com.alfa11.firebasetemplate.viewmodel.IngredientViewModel

class IngredientListFragment : Fragment() {

    private val mAdapter: IngredientAdapter = IngredientAdapter()
    private lateinit var mListener: IngredientListener
    private lateinit var mViewModel: IngredientViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mViewModel = ViewModelProvider(this).get(IngredientViewModel::class.java)

        observe()

        val root = inflater.inflate(R.layout.fragment_ingredient_list, container, false)
        val recycler = root.findViewById<RecyclerView>(R.id.ingredient_recycler_list)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter


        mListener = object : IngredientListener {
            override fun onClick(id: String?) {
                Log.d("IngredientViewModel","Ingredient ID:"+ id)
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
        mViewModel.getAllIngredients()
    }

    private fun observe() {

        mViewModel.ingredientResponse.observe(viewLifecycleOwner) {

            Log.d("RecipeViewModel","tamanho:"+it.ingredients!!.size)
            mAdapter.updateIngredients(it.ingredients!!)

        }
    }

}