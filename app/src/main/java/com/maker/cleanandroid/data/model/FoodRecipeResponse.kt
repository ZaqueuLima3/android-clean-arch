package com.maker.cleanandroid.data.model

import com.google.gson.annotations.SerializedName

class FoodRecipeResponse(
    @SerializedName("results")
    val recipes: List<RecipeResponse>
)