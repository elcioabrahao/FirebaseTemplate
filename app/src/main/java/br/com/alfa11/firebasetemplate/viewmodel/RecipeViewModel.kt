package br.com.alfa11.firebasetemplate.viewmodel


import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import br.com.alfa11.firebasetemplate.data.Recipe
import br.com.alfa11.firebasetemplate.data.RecipeResponse
import br.com.alfa11.firebasetemplate.ui.recipe.RecipeActivity
import com.google.firebase.firestore.FirebaseFirestore


class RecipeViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    private val mSaveSuccess = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> = mSaveSuccess

    private var mRecipeResponse = MutableLiveData<RecipeResponse>()
    val recipeResponse: LiveData<RecipeResponse> = mRecipeResponse


    fun addRecipe(recipe: Recipe) {
        db.collection("recipes")
            .add(recipe)
            .addOnSuccessListener { documentReference ->
                mSaveSuccess.value = true
            }
            .addOnFailureListener { e ->
                Log.w("RecipeViewModel", "Error adding document", e)
                mSaveSuccess.value = false
            }
    }

    fun getAllRecipes(){
        var recipes: List<Recipe>? = null
        val recipeResponse = RecipeResponse()
        db.collection("recipes")
            .get()
            .addOnSuccessListener { result ->
                result?.let {
                    recipes = result.documents.mapNotNull { snapShot ->
                        snapShot.toObject(Recipe::class.java)
                    }
                }
                Log.d("RecipeViewModel","ta: "+recipes!!.size)
                recipeResponse.recipes = recipes
                mRecipeResponse.value = recipeResponse
            }
            .addOnFailureListener { exception ->
                Log.d("RecipeViewModel", "Error getting documents.", exception)
                recipeResponse.erro = "Erro"
                mRecipeResponse.value = recipeResponse
            }

    }


}


