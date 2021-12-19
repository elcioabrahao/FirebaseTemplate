package br.com.alfa11.firebasetemplate.ui.ingredient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alfa11.firebasetemplate.R

class IngredientListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient_detail)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.ingredient_container, IngredientListFragment())
                .commitAllowingStateLoss()
        }
    }
}