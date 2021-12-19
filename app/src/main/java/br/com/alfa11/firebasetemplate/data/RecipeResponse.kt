package br.com.alfa11.firebasetemplate.data

data class RecipeResponse(
    var recipes: List<Recipe>? = null,
    var erro: String? =  null
)
