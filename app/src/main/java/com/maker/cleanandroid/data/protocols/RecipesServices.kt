package com.maker.cleanandroid.data.protocols

import com.maker.cleanandroid.data.model.FoodRecipeResponse

interface RecipesServices {
    suspend fun getRecipes(queries: Map<String, String>): FoodRecipeResponse
}
