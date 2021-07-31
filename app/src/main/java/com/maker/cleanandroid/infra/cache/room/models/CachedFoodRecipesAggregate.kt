package com.maker.cleanandroid.infra.cache.room.models

import androidx.room.Embedded
import androidx.room.Relation
import com.maker.cleanandroid.domain.model.Recipe

data class CachedFoodRecipesAggregate(
    @Embedded
    val recipe: CachedRecipes,
    @Relation(
        parentColumn = "recipeId",
        entityColumn = "recipeId"
    )
    val extendedIngredients: List<CachedExtendedIngredients>
) {
    companion object {
        fun fromDomain(domain: Recipe): CachedFoodRecipesAggregate {
            return CachedFoodRecipesAggregate(
                recipe = CachedRecipes.fromDomain(domain),
                extendedIngredients = domain.extendedIngredients.map {
                    CachedExtendedIngredients.fromDomain(domain.id, it)
                }
            )
        }
    }
}
