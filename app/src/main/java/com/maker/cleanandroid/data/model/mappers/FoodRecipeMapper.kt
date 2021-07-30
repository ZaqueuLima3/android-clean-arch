package com.maker.cleanandroid.data.model.mappers

import com.maker.cleanandroid.data.model.FoodRecipeResponse
import com.maker.cleanandroid.domain.model.FoodRecipe

class FoodRecipeMapper(
    private val resultResponseMapper: ResultResponseMapper
) : ResponseMapper<FoodRecipeResponse, FoodRecipe> {
    override fun mapToDomain(entityResponse: FoodRecipeResponse): FoodRecipe {
        return FoodRecipe(
            recipes = entityResponse.recipes.map { resultResponseMapper.mapToDomain(it) }
        )
    }
}
