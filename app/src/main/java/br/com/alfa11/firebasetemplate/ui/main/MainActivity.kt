package br.com.alfa11.firebasetemplate.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alfa11.firebasetemplate.databinding.ActivityMainBinding
import br.com.alfa11.firebasetemplate.ui.ingredient.IngredientActivity
import br.com.alfa11.firebasetemplate.ui.ingredient.IngredientListActivity
import br.com.alfa11.firebasetemplate.ui.recipe.RecipeActivity
import br.com.alfa11.firebasetemplate.ui.recipe.RecipeListActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addRecipe.setOnClickListener {
            val intent = Intent(this, RecipeActivity::class.java)
            startActivity(intent)
        }

        binding.addIngredient.setOnClickListener {
            val intent = Intent(this, IngredientActivity::class.java)
            startActivity(intent)
        }

        binding.listRecipes.setOnClickListener {
            val intent = Intent(this, RecipeListActivity::class.java)
            startActivity(intent)
        }

        binding.listIngredients.setOnClickListener {
            val intent = Intent(this, IngredientListActivity::class.java)
            startActivity(intent)
        }
    }
}