package com.maker.cleanandroid.domain.usecases

import com.maker.cleanandroid.domain.model.Recipe
import com.maker.cleanandroid.domain.protocols.RecipesRepository
import kotlinx.coroutines.flow.Flow

class GetRecipesUseCase(
    private val recipesRepository: RecipesRepository
) : UseCase.NoParam<List<Recipe>>() {
    override suspend fun execute(): Flow<List<Recipe>> {
        return recipesRepository.getRecipes()
    }
}
