package br.com.alfa11.firebasetemplate.ui.recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.com.alfa11.firebasetemplate.databinding.ActivityRecipeBinding
import androidx.lifecycle.ViewModelProvider
import br.com.alfa11.firebasetemplate.data.Recipe
import br.com.alfa11.firebasetemplate.viewmodel.RecipeViewModel
import java.util.*


class RecipeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipeBinding
    private lateinit var mViewModel: RecipeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        observe()

        binding.saveRecipe.setOnClickListener {
            val description = binding.description.text.toString()
            val recipe = Recipe(UUID.randomUUID().toString(),description)
            Log.d(TAG,"Recipe: "+recipe.toString())
            mViewModel.addRecipe(recipe)
        }

    }

    private fun observe() {
        mViewModel.success.observe(this) {
            if(it){
                Toast.makeText(baseContext, "Recipe created!",
                    Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(baseContext, "Error on recipe creation!",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val TAG = "RecipeActivityLog"
    }
}