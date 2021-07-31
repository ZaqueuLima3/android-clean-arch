package com.maker.cleanandroid.infra.cache.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.maker.cleanandroid.domain.model.ExtendedIngredient
import com.maker.cleanandroid.domain.model.Recipe

@Entity(
    tableName = "recipes"
)
data class CachedRecipes(
    @PrimaryKey
    val recipeId: Int,
    val aggregateLikes: Int,
    val cheap: Boolean,
    val dairyFree: Boolean,
    val glutenFree: Boolean,
    val image: String,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceName: String,
    val sourceUrl: String,
    val summary: String,
    val title: String,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean,
) {
    companion object {
        fun fromDomain(domain: Recipe) : CachedRecipes {
            return CachedRecipes(
                recipeId = domain.id,
                aggregateLikes = domain.aggregateLikes,
                cheap = domain.cheap,
                dairyFree = domain.dairyFree,
                glutenFree = domain.glutenFree,
                image = domain.image,
                readyInMinutes = domain.readyInMinutes,
                servings = domain.servings,
                sourceName = domain.sourceName,
                sourceUrl = domain.sourceUrl,
                summary = domain.summary,
                title = domain.title,
                vegan = domain.vegan,
                vegetarian = domain.vegetarian,
                veryHealthy = domain.veryHealthy
            )
        }
    }

    fun toDomain(
        extendedIngredients: List<CachedExtendedIngredients>
    ): Recipe {
        return Recipe(
            id = recipeId,
            aggregateLikes = aggregateLikes,
            cheap = cheap,
            dairyFree = dairyFree,
            glutenFree = glutenFree,
            image = image,
            readyInMinutes = readyInMinutes,
            servings = servings,
            sourceName = sourceName,
            sourceUrl = sourceUrl,
            summary = summary,
            title = title,
            vegan = vegan,
            vegetarian = vegetarian,
            veryHealthy = veryHealthy,
            extendedIngredients = extendedIngredients.map { it.toDomain() }
        )
    }
}
