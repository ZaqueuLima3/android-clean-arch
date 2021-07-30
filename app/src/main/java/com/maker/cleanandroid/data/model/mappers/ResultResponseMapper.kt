package com.maker.cleanandroid.data.model.mappers

import com.maker.cleanandroid.data.model.RecipeResponse
import com.maker.cleanandroid.domain.model.Recipe

class ResultResponseMapper(
    private val extendedIngredientResponseMapper: ExtendedIngredientResponseMapper
) : ResponseMapper<RecipeResponse, Recipe> {
    override fun mapToDomain(entityResponse: RecipeResponse): Recipe {
        return Recipe(
            id = entityResponse.id,
            aggregateLikes = entityResponse.aggregateLikes,
            cheap = entityResponse.cheap,
            dairyFree = entityResponse.dairyFree,
            extendedIngredients = entityResponse.extendedIngredients?.map {
                extendedIngredientResponseMapper.mapToDomain(
                    it
                )
            }.orEmpty(),
            glutenFree = entityResponse.glutenFree,
            image = entityResponse.image,
            readyInMinutes = entityResponse.readyInMinutes,
            servings = entityResponse.servings,
            sourceName = entityResponse.sourceName.orEmpty(),
            sourceUrl = entityResponse.sourceUrl.orEmpty(),
            summary = entityResponse.summary,
            title = entityResponse.title,
            vegan = entityResponse.vegan,
            vegetarian = entityResponse.vegetarian,
            veryHealthy = entityResponse.veryHealthy
        )
    }
}