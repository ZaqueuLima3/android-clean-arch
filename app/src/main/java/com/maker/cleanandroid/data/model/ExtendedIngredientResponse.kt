package com.maker.cleanandroid.data.model

import com.google.gson.annotations.SerializedName

data class ExtendedIngredientResponse(
    @SerializedName("amount")
    val amount: Double?,
    @SerializedName("consistency")
    val consistency: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("original")
    val original: String?,
    @SerializedName("unit")
    val unit: String?
)
