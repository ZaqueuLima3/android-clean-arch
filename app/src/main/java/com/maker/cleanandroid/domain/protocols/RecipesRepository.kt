package com.maker.cleanandroid.domain.protocols

import com.maker.cleanandroid.domain.model.FoodRecipe
import com.maker.cleanandroid.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipesRepository {
    fun getRecipes(): Flow<List<Recipe>>
    suspend fun requestRecipes(queries: Map<String, String>): Flow<FoodRecipe>
    suspend fun storeRecipes(recipes: List<Recipe>)
}
