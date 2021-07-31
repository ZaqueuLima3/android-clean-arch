package com.maker.cleanandroid.data.protocols

import com.maker.cleanandroid.domain.model.Recipe
import com.maker.cleanandroid.infra.cache.room.models.CachedFoodRecipesAggregate
import kotlinx.coroutines.flow.Flow

interface CacheServices {
    fun getRecipes(): Flow<List<Recipe>>

    suspend fun storeRecipes(recipes: List<Recipe>)
}
