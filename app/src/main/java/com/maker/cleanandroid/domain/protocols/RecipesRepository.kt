package com.maker.cleanandroid.domain.protocols

import com.maker.cleanandroid.domain.model.FoodRecipe
import kotlinx.coroutines.flow.Flow

interface RecipesRepository {
    suspend fun getRecipes(queries: Map<String, String>): Flow<FoodRecipe>
}
