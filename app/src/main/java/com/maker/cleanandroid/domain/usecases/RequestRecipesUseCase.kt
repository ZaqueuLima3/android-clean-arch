package com.maker.cleanandroid.domain.usecases

import com.maker.cleanandroid.domain.protocols.RecipesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RequestRecipesUseCase(
    private val recipesRepository: RecipesRepository
) : UseCase.NoSource<Map<String, String>>() {
    override suspend fun execute(param: Map<String, String>): Flow<Unit> {
        val (recipes) = recipesRepository.requestRecipes(param)
        recipesRepository.storeRecipes(recipes)
        return flow {  }
    }
}
