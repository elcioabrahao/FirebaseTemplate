package br.com.alfa11.firebasetemplate.ui.ingredient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alfa11.firebasetemplate.R

class IngredientDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient_detail)

        if(savedInstanceState == null) { // initial transaction should be wrapped like this
            supportFragmentManager.beginTransaction()
                .replace(R.id.ingredient_container, IngredientFragment())
                .commitAllowingStateLoss()
        }
    }
}