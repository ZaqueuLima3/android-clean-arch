package com.maker.cleanandroid.data.model.mappers

interface ResponseMapper<E, D> {
    fun mapToDomain(entityResponse: E): D
}
