package br.com.alfa11.firebasetemplate.ui.ingredient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.com.alfa11.firebasetemplate.R
import br.com.alfa11.firebasetemplate.data.Ingredient
import br.com.alfa11.firebasetemplate.data.Recipe
import br.com.alfa11.firebasetemplate.databinding.ActivityIngredientBinding
import br.com.alfa11.firebasetemplate.databinding.ActivityRecipeBinding
import br.com.alfa11.firebasetemplate.ui.recipe.RecipeActivity
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class IngredientActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore
    private lateinit var binding: ActivityIngredientBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIngredientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = FirebaseFirestore.getInstance()

        binding.saveIngredient.setOnClickListener {
            val description = binding.description.text.toString()
            val imageUrl = binding.image.text.toString()
            val ingredient = Ingredient(UUID.randomUUID().toString(),
                description,
                imageUrl)
            Log.d(TAG,"Ingredient: "+ingredient.toString())
            addIngredient(ingredient)
        }
    }

    fun addIngredient(ingredient: Ingredient){
        db.collection("ingredients")
            .add(ingredient)
            .addOnSuccessListener { documentReference ->
                Log.d(
                    TAG,
                    "DocumentSnapshot added with ID: " + documentReference.id
                )
                Toast.makeText(baseContext, "Ingredient created!",
                    Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e -> Log.w(TAG, "Error adding document", e) }
    }


    companion object {
        private const val TAG = "IngredientActivityLog"
    }
}