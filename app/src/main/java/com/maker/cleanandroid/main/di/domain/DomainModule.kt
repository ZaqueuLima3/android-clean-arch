package com.maker.cleanandroid.main.di.domain

import com.maker.cleanandroid.domain.usecases.GetRecipesUseCase
import com.maker.cleanandroid.domain.usecases.RequestRecipesUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {
    fun load() {
        loadKoinModules(useCasesModule())
    }

    private fun useCasesModule(): Module {
        return module {
            factory {
                GetRecipesUseCase(
                    recipesRepository = get()
                )
            }
            factory {
                RequestRecipesUseCase(
                    recipesRepository = get()
                )
            }
        }
    }
}
