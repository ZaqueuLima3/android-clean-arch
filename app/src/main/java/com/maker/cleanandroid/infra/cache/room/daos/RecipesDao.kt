package com.maker.cleanandroid.infra.cache.room.daos

import androidx.room.*
import com.maker.cleanandroid.infra.cache.room.models.CachedExtendedIngredients
import com.maker.cleanandroid.infra.cache.room.models.CachedFoodRecipesAggregate
import com.maker.cleanandroid.infra.cache.room.models.CachedRecipes
import kotlinx.coroutines.flow.Flow

@Dao
abstract class RecipesDao {
    @Transaction
    @Query("SELECT * FROM recipes ORDER BY recipeId DESC")
    abstract fun getAllRecipes(): Flow<List<CachedFoodRecipesAggregate>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertFoodRecipesAggregate(
        recipe: CachedRecipes,
        extendedIngredients: List<CachedExtendedIngredients>,
    )

    suspend fun insertRecipes(foodRecipesAggregates: List<CachedFoodRecipesAggregate>) {
        for (foodRecipesAggregate in foodRecipesAggregates) {
            insertFoodRecipesAggregate(
                foodRecipesAggregate.recipe,
                foodRecipesAggregate.extendedIngredients
            )
        }
    }
}
