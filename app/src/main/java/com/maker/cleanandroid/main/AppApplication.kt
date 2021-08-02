package com.maker.cleanandroid.main

import android.app.Application
import com.maker.cleanandroid.main.di.data.DataModule
import com.maker.cleanandroid.main.di.domain.DomainModule
import com.maker.cleanandroid.main.di.infra.InfraModule
import com.maker.cleanandroid.main.di.presentation.PresentationModule
import com.maker.cleanandroid.main.di.utils.UtilModule
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
