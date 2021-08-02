package com.maker.cleanandroid.main.di.infra

import android.util.Log
import com.google.gson.GsonBuilder
import com.maker.cleanandroid.data.protocols.RecipesServices
import com.maker.cleanandroid.infra.network.FoodRecipesServices
import com.maker.cleanandroid.shared.Constants.SPOONACULAR_BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    val modules = networkModules()
    private const val OK_HTTP = "okHttp"

    private fun networkModules(): Module {
        return module {
            single {
                val interceptor = HttpLoggingInterceptor {
                    Log.d(OK_HTTP, it)
                }
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()
            }
            single {
                GsonConverterFactory.create(GsonBuilder().create())
            }
            single<RecipesServices> {
                createService<FoodRecipesServices>(
                    baseUrl = SPOONACULAR_BASE_URL,
                    client = get(),
                    factory = get()
                )
            }
        }
    }

    private inline fun <reified T> createService(
        baseUrl: String,
        client: OkHttpClient,
        factory: GsonConverterFactory
    ): T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(factory)
            .build()
            .create(T::class.java)
    }
}
