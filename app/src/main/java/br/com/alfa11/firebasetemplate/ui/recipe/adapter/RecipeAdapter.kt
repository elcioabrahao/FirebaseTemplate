package com.devedu.CadrastoDeNomes.Views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alfa11.firebasetemplate.R
import br.com.alfa11.firebasetemplate.data.Recipe
import br.com.alfa11.firebasetemplate.ui.recipe.adapter.RecipeListener
import br.com.alfa11.firebasetemplate.ui.recipe.adapter.RecipeViewHolder

class RecipeAdapter : RecyclerView.Adapter<RecipeViewHolder>() {

    private var mRecipeList: List<Recipe> = arrayListOf()
    private lateinit var mListener: RecipeListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(item, mListener)
    }

    override fun getItemCount(): Int {
        return mRecipeList.count()
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(mRecipeList[position])
    }

    fun updateRecipes(list: List<Recipe>) {
        mRecipeList = list
        notifyDataSetChanged()
    }

    fun attachListener(listener: RecipeListener) {
        mListener = listener
    }

}