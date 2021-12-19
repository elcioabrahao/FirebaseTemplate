package br.com.alfa11.firebasetemplate.ui.recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alfa11.firebasetemplate.R

class RecipeListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        if(savedInstanceState == null) { // initial transaction should be wrapped like this
            supportFragmentManager.beginTransaction()
                .replace(R.id.recipe_container, RecipeListFragment())
                .commitAllowingStateLoss()
        }
    }
}