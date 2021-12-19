package br.com.alfa11.firebasetemplate.ui.ingredient.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alfa11.firebasetemplate.R
import br.com.alfa11.firebasetemplate.data.Ingredient
import br.com.alfa11.firebasetemplate.data.Recipe

class IngredientViewHolder(itemView: View, private val listener: IngredientListener) :
    RecyclerView.ViewHolder(itemView) {
  fun bind(ingredient: Ingredient) {

    val textDescription = itemView.findViewById<TextView>(R.id.ingredient_description)
    val textImageUrl = itemView.findViewById<TextView>(R.id.ingredient_image)

        textDescription.text = ingredient.description
      textImageUrl.text = ingredient.image

        textDescription.setOnClickListener {
            listener.onClick(ingredient.id)
        }

        // Atribui eventos
//        textDescription.setOnLongClickListener {
//            AlertDialog.Builder(itemView.context)
//                .setTitle(R.string.remocao_convidado)
//                .setMessage(R.string.deseja_remover)
//                .setPositiveButton(R.string.remover) { dialog, which ->
//                    listener.onDelete(recipe.id)
//                }
//                .setNeutralButton(R.string.cancelar, null)
//                .show()
//
//            true
//        }

    }
}