package br.com.alfa11.firebasetemplate.ui.ingredient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import br.com.alfa11.firebasetemplate.data.Ingredient
import br.com.alfa11.firebasetemplate.databinding.ActivityIngredientBinding
import br.com.alfa11.firebasetemplate.viewmodel.IngredientViewModel
import java.util.*

class IngredientActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIngredientBinding
    private lateinit var mViewModel: IngredientViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIngredientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mViewModel = ViewModelProvider(this).get(IngredientViewModel::class.java)

        observe()

        binding.saveIngredient.setOnClickListener {
            val description = binding.description.text.toString()
            val imageUrl = binding.image.text.toString()
            val ingredient = Ingredient(UUID.randomUUID().toString(),description,imageUrl)
            Log.d(TAG,"Ingredient: "+ingredient.toString())
            mViewModel.addIngredient(ingredient)
        }

    }

    private fun observe() {
        mViewModel.success.observe(this) {
            if(it){
                Toast.makeText(baseContext, "Ingredient created!",
                    Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(baseContext, "Error on ingredient creation!",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val TAG = "IngredientActivityLog"
    }
}