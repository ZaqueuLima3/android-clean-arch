package com.maker.cleanandroid.data.model.mappers

import com.maker.cleanandroid.data.model.ExtendedIngredientResponse
import com.maker.cleanandroid.domain.model.ExtendedIngredient

class ExtendedIngredientResponseMapper : ResponseMapper<ExtendedIngredientResponse, ExtendedIngredient> {
    override fun mapToDomain(entityResponse: ExtendedIngredientResponse): ExtendedIngredient {
        return ExtendedIngredient(
            amount = entityResponse.amount?.toLong() ?: 0L,
            consistency = entityResponse.consistency.orEmpty(),
            image = entityResponse.image.orEmpty(),
            name = entityResponse.name,
            original = entityResponse.original.orEmpty(),
            unit = entityResponse.unit.orEmpty()
        )
    }
}
