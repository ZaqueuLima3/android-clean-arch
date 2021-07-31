package com.maker.cleanandroid.data.di

import com.maker.cleanandroid.data.repositories.SpoonacularRecipesRepository
import com.maker.cleanandroid.domain.protocols.RecipesRepository
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DataModule {
    fun load() {
        loadKoinModules(NetworkModule.modules + repositoryModules())
    }

    private fun repositoryModules(): Module {
        return module {
            single<RecipesRepository> {
                SpoonacularRecipesRepository(
                    networkServices = get(),
                    cacheServices = get(),
                    foodRecipeMapper = get()
                )
            }
        }
    }
}
