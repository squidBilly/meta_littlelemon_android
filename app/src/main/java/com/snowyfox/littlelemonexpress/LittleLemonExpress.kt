package com.snowyfox.littlelemonexpress

import android.app.Application
import com.snowyfox.littlelemonexpress.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class LittleLemonExpress: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@LittleLemonExpress)
            modules(viewModelModule)
        }
    }
}