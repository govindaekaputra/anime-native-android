package com.example.animeapp

import android.app.Application
import com.example.animeapp.core.di.databaseModule
import com.example.animeapp.core.di.networkModule
import com.example.animeapp.core.di.repositoryModule
import com.example.animeapp.home.di.useCaseModule
import com.example.animeapp.home.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}