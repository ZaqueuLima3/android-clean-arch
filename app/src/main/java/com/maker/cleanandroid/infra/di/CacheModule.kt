package com.maker.cleanandroid.infra.di

import com.maker.cleanandroid.data.protocols.CacheServices
import com.maker.cleanandroid.infra.cache.room.RoomCache
import com.maker.cleanandroid.infra.cache.room.SpoonacularDatabase
import com.maker.cleanandroid.infra.cache.room.daos.RecipesDao
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

object CacheModule {
    val modules = cacheModules() + daoModules() + serviceModules()

    private fun cacheModules(): Module {
        return module {
            single<SpoonacularDatabase> {
                SpoonacularDatabase.getDatabase(androidContext())
            }
        }
    }

    private fun daoModules(): Module {
        return module {
            single<RecipesDao> {
                get<SpoonacularDatabase>().recipesDao()
            }
        }
    }

    private fun serviceModules(): Module {
        return module {
            single<CacheServices> {
                RoomCache(
                    recipesDao = get()
                )
            }
        }
    }
}
