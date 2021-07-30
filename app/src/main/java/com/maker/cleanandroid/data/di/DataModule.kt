package com.maker.cleanandroid.data.di

import org.koin.core.context.loadKoinModules

object DataModule {
    fun load() {
        loadKoinModules(NetworkModule.modules)
    }
}