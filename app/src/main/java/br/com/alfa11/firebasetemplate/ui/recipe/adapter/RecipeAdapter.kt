package com.devedu.CadrastoDeNomes.Views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alfa11.firebasetemplate.R
import br.com.alfa11.firebasetemplate.data.Recipe
import br.com.alfa11.firebasetemplate.ui.recipe.adapter.RecipeListener
import br.com.alfa11.firebasetemplate.ui.recipe.adapter.RecipeViewHolder

class RecipeAdapter : RecyclerView.Adapter<RecipeViewHolder>() {

    // Lista de convidados
    private var mRecipeList: List<Recipe> = arrayListOf()
    private lateinit var mListener: RecipeListener
    /**
     * Faz a criação do layout da linha
     * Faz a criação de várias linhas que vão mostrar cada um dos convidados
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(item, mListener)
    }

    /**
     * Qual o tamanho da RecyclerView
     */
    override fun getItemCount(): Int {
        return mRecipeList.count()
    }

    /**
     * Para cada linha, este método é chamado
     * É responsável por atribuir os valores de cada item para uma linha específica
     */
    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(mRecipeList[position])
    }

    /**
     * Atualização da lista de convidados
     */
    fun updateRecipes(list: List<Recipe>) {
        mRecipeList = list
        notifyDataSetChanged()
    }

    /**
     * Eventos na listagem
     */
    fun attachListener(listener: RecipeListener) {
        mListener = listener
    }

}