package com.maker.cleanandroid.data.repositories

import com.maker.cleanandroid.data.model.mappers.FoodRecipeMapper
import com.maker.cleanandroid.data.protocols.CacheServices
import com.maker.cleanandroid.data.protocols.RecipesServices
import com.maker.cleanandroid.domain.model.Recipe
import com.maker.cleanandroid.domain.protocols.RecipesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class SpoonacularRecipesRepository(
    private val networkServices: RecipesServices,
    private val cacheServices: CacheServices,
    private val foodRecipeMapper: FoodRecipeMapper
) : RecipesRepository {
    override fun getRecipes(): Flow<List<Recipe>> {
        return cacheServices.getRecipes()
    }

    override suspend fun requestRecipes(queries: Map<String, String>) = flow {
        try {
            val response = networkServices.getRecipes(queries)
            emit(foodRecipeMapper.mapToDomain(response))
        } catch (exception: HttpException) {
            throw Exception()
        }
    }

    override suspend fun storeRecipes(recipes: List<Recipe>) {
        cacheServices.storeRecipes(recipes)
    }
}
