package com.maker.cleanandroid.infra.di

import org.koin.core.context.loadKoinModules

object InfraModule {
    fun load() {
        loadKoinModules(NetworkModule.modules + CacheModule.modules)
    }
}
