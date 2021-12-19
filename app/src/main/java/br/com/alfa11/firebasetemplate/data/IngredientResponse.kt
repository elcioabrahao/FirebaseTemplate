package br.com.alfa11.firebasetemplate.data

data class IngredientResponse(
    var ingredients: List<Ingredient>? = null,
    var erro: String? =  null
)