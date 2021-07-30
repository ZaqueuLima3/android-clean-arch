package com.maker.cleanandroid.infra.network

import com.maker.cleanandroid.data.model.FoodRecipeResponse
import com.maker.cleanandroid.data.protocols.RecipesServices
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface FoodRecipesServices : RecipesServices {
    @GET("/recipes/complexSearch")
    override suspend fun getRecipes(
        @QueryMap queries: Map<String, String>
    ): FoodRecipeResponse
}
