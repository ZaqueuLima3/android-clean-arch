package com.maker.cleanandroid.domain.usecases

import com.maker.cleanandroid.domain.model.FoodRecipe
import com.maker.cleanandroid.domain.protocols.RecipesRepository
import kotlinx.coroutines.flow.Flow

class GetRecipesUseCase(
    private val repository: RecipesRepository
) : UseCase<Map<String, String>, FoodRecipe>() {
    override suspend fun execute(param: Map<String, String>): Flow<FoodRecipe> {
        return repository.getRecipes(param)
    }
}
