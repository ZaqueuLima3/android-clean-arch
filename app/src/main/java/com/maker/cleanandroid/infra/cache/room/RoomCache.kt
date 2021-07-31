package com.maker.cleanandroid.infra.cache.room

import com.maker.cleanandroid.data.protocols.CacheServices
import com.maker.cleanandroid.domain.model.Recipe
import com.maker.cleanandroid.infra.cache.room.daos.RecipesDao
import com.maker.cleanandroid.infra.cache.room.models.CachedFoodRecipesAggregate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

class RoomCache(
    private val recipesDao: RecipesDao
) : CacheServices {
    override fun getRecipes(): Flow<List<Recipe>> {
        return recipesDao.getAllRecipes()
            .distinctUntilChanged()
            .map { recipesList ->
                recipesList.map { it.recipe.toDomain(it.extendedIngredients) }
            }
    }

    override suspend fun storeRecipes(recipes: List<Recipe>) {
        val recipesToCache = recipes.map { recipe ->
            CachedFoodRecipesAggregate.fromDomain(recipe)
        }
        recipesDao.insertRecipes(recipesToCache)
    }
}
