package com.missclick.GameMachine

import android.app.Application
import com.missclick.GameMachine.coin.appModule
import com.missclick.GameMachine.coin.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(appModule, dataModule)
        }
    }
}