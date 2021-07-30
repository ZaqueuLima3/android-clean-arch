package com.maker.cleanandroid.main

import android.app.Application
import com.maker.cleanandroid.data.di.DataModule
import com.maker.cleanandroid.domain.di.DomainModule
import com.maker.cleanandroid.infra.di.InfraModule
import com.maker.cleanandroid.presentation.di.PresentationModule
import com.maker.cleanandroid.utils.di.UtilModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
        }
        DataModule.load()
        DomainModule.load()
        InfraModule.load()
        UtilModule.load()
        PresentationModule.load()
    }
}
