package com.maker.cleanandroid.main.di.presentation

import com.maker.cleanandroid.presentation.recipes.RecipesAdapter
import com.maker.cleanandroid.presentation.recipes.RecipesFragment
import com.maker.cleanandroid.presentation.recipes.RecipesViewModel
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object PresentationModule {
    fun load() {
        loadKoinModules(viewModelsModule() + fragmentModule() + adaptersModule())
    }

    private fun viewModelsModule(): Module {
        return module {
            viewModel {
                RecipesViewModel(
                    getRecipesUseCase = get(),
                    requestRecipesUseCase = get()
                )
            }
        }
    }

    private fun fragmentModule(): Module {
        return module {
            fragment {
                RecipesFragment(
                    viewModel = get(),
                    recipesAdapter = get()
                )
            }
        }
    }

    private fun adaptersModule(): Module {
        return module {
            single {
                RecipesAdapter(
                    imageLoader = get()
                )
            }
        }
    }
}