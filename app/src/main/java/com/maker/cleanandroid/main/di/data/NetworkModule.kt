package com.maker.cleanandroid.main.di.data

import com.maker.cleanandroid.data.model.mappers.ExtendedIngredientResponseMapper
import com.maker.cleanandroid.data.model.mappers.FoodRecipeMapper
import com.maker.cleanandroid.data.model.mappers.ResultResponseMapper
import org.koin.core.module.Module
import org.koin.dsl.module

object NetworkModule {
    val modules = networkModules()

    private fun networkModules(): Module {
        return module {
            single {
                ExtendedIngredientResponseMapper()
            }
            single {
                ResultResponseMapper(
                    extendedIngredientResponseMapper = get()
                )
            }
            single {
                FoodRecipeMapper(
                    resultResponseMapper = get()
                )
            }
        }
    }
}