package com.maker.cleanandroid.infra.cache.room.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.maker.cleanandroid.domain.model.ExtendedIngredient

@Entity(
    tableName = "extended_ingredients",
    foreignKeys = [
        ForeignKey(
            entity = CachedRecipes::class,
            parentColumns = ["recipeId"],
            childColumns = ["recipeId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("recipeId")]
)
data class CachedExtendedIngredients(
    @PrimaryKey(autoGenerate = true)
    val extendedIngredientId: Long = 0,
    val recipeId: Int,
    val amount: Long,
    val consistency: String,
    val image: String,
    val name: String,
    val original: String,
    val unit: String
) {
    companion object {
        fun fromDomain(
            recipeId: Int,
            domain: ExtendedIngredient
        ): CachedExtendedIngredients {
            return CachedExtendedIngredients(
                recipeId = recipeId,
                amount = domain.amount,
                consistency = domain.consistency,
                image = domain.image,
                name = domain.name,
                original = domain.original,
                unit = domain.unit
            )
        }
    }

    fun toDomain(): ExtendedIngredient = ExtendedIngredient(
        amount = amount,
        consistency = consistency,
        image = image,
        name = name,
        original = original,
        unit = unit
    )
}
