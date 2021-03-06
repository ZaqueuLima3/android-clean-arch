package com.maker.cleanandroid.main.di.utils

import com.maker.cleanandroid.presentation.protocols.ImageLoader
import com.maker.cleanandroid.utils.GlideImageLoaderAdapter
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object UtilModule {
    fun load() {
        loadKoinModules(adaptersModules())
    }

    private fun adaptersModules(): Module {
        return module {
            factory<ImageLoader> {
                GlideImageLoaderAdapter(
                    context = androidContext()
                )
            }
//            factory<ImageLoader> {
//                PicassoImageLoaderAdapter()
//            }
        }
    }
}
