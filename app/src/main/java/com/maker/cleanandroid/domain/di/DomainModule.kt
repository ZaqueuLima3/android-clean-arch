package com.maker.cleanandroid.domain.di

import com.maker.cleanandroid.domain.usecases.GetRecipesUseCase
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
                    repository = get()
                )
            }
        }
    }
}
