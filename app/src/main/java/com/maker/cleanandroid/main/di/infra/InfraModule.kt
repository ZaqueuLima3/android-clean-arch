package com.maker.cleanandroid.main.di.infra

import org.koin.core.context.loadKoinModules

object InfraModule {
    fun load() {
        loadKoinModules(NetworkModule.modules + CacheModule.modules)
    }
}
