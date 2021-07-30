package com.maker.cleanandroid.data.di

import android.util.Log
import com.google.gson.GsonBuilder
import com.maker.cleanandroid.data.model.mappers.ExtendedIngredientResponseMapper
import com.maker.cleanandroid.data.model.mappers.FoodRecipeMapper
import com.maker.cleanandroid.data.model.mappers.ResultResponseMapper
import com.maker.cleanandroid.data.repositories.SpoonacularRecipesRepository
import com.maker.cleanandroid.domain.protocols.RecipesRepository
import com.maker.cleanandroid.infra.di.InfraModule
import com.maker.cleanandroid.infra.network.FoodRecipesServices
import com.maker.cleanandroid.shared.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    val modules = networkModules() + repositoryModules()

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

    private fun repositoryModules(): Module {
        return module {
            single<RecipesRepository> {
                SpoonacularRecipesRepository(
                    services = get(),
                    foodRecipeMapper = get()
                )
            }
        }
    }
}