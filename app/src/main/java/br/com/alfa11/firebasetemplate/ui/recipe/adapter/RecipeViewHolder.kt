package br.com.alfa11.firebasetemplate.ui.recipe.adapter

import android.app.AlertDialog
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alfa11.firebasetemplate.R
import br.com.alfa11.firebasetemplate.data.Recipe

class RecipeViewHolder(itemView: View, private val listener: RecipeListener) :
    RecyclerView.ViewHolder(itemView) {
  fun bind(recipe: Recipe) {

    val textDescription = itemView.findViewById<TextView>(R.id.description)


        textDescription.text = recipe.description

        // Atribui eventos
        textDescription.setOnClickListener {
            listener.onClick(recipe.id)
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