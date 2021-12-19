package br.com.alfa11.firebasetemplate.ui.ingredient.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alfa11.firebasetemplate.R
import br.com.alfa11.firebasetemplate.data.Ingredient

class IngredientAdapter : RecyclerView.Adapter<IngredientViewHolder>() {

    private var mIngredientList: List<Ingredient> = arrayListOf()
    private lateinit var mListener: IngredientListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_ingredient, parent, false)
        return IngredientViewHolder(item, mListener)
    }

    override fun getItemCount(): Int {
        return mIngredientList.count()
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.bind(mIngredientList[position])
    }

    fun updateIngredients(list: List<Ingredient>) {
        mIngredientList = list
        notifyDataSetChanged()
    }

    fun attachListener(listener: IngredientListener) {
        mListener = listener
    }

}