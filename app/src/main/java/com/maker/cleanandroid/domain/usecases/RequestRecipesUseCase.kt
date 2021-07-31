package com.maker.cleanandroid.domain.usecases

import com.maker.cleanandroid.domain.protocols.RecipesRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect

class RequestRecipesUseCase(
    private val recipesRepository: RecipesRepository
) {
    suspend operator fun invoke(param: Map<String, String>) {
        recipesRepository.requestRecipes(param)
            .catch {  }
            .collect { (recipes) ->
                recipesRepository.storeRecipes(recipes)
            }
    }
}
