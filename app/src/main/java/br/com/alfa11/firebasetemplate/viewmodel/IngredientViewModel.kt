package br.com.alfa11.firebasetemplate.viewmodel


import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import br.com.alfa11.firebasetemplate.data.Ingredient
import br.com.alfa11.firebasetemplate.data.IngredientResponse
import com.google.firebase.firestore.FirebaseFirestore


class IngredientViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    private val mSaveSuccess = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> = mSaveSuccess

    private var mIngredientResponse = MutableLiveData<IngredientResponse>()
    val ingredientResponse: LiveData<IngredientResponse> = mIngredientResponse


    fun addIngredient(recipe: Ingredient) {
        db.collection("ingredients")
            .add(recipe)
            .addOnSuccessListener { documentReference ->
                mSaveSuccess.value = true
            }
            .addOnFailureListener { e ->
                Log.w("IngredientViewModel", "Error adding document", e)
                mSaveSuccess.value = false
            }
    }

    fun getAllIngredients(){
        var ingredients: List<Ingredient>? = null
        val ingredientResponse = IngredientResponse()
        db.collection("ingredients")
            .get()
            .addOnSuccessListener { result ->
                result?.let {
                    ingredients = result.documents.mapNotNull { snapShot ->
                        snapShot.toObject(Ingredient::class.java)
                    }
                }
                Log.d("IngredientViewModel","ta: "+ingredients!!.size)
                Log.d("IngredientViewModel","Description: "+ingredients!!.get(0).description)
                ingredientResponse.ingredients = ingredients
                mIngredientResponse.value = ingredientResponse
            }
            .addOnFailureListener { exception ->
                Log.d("IngredientViewModel", "Error getting documents.", exception)
                ingredientResponse.erro = "Erro"
                mIngredientResponse.value = ingredientResponse
            }

    }


}


