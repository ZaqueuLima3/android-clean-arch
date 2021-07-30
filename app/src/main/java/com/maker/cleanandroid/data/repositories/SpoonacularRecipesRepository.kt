package com.maker.cleanandroid.data.repositories

import com.maker.cleanandroid.data.model.mappers.FoodRecipeMapper
import com.maker.cleanandroid.data.protocols.RecipesServices
import com.maker.cleanandroid.domain.protocols.RecipesRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class SpoonacularRecipesRepository(
    private val services: RecipesServices,
    private val foodRecipeMapper: FoodRecipeMapper
) : RecipesRepository {
    override suspend fun getRecipes(queries: Map<String, String>) = flow {
        try {
            val response = services.getRecipes(queries)
            emit(foodRecipeMapper.mapToDomain(response))
        } catch (exception: HttpException) {
            throw Exception()
        }
    }
}
