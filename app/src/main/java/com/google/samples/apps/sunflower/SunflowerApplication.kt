package com.google.samples.apps.sunflower

import android.app.Application
import com.google.samples.apps.sunflower.di.sunflowerModule
import org.koin.android.ext.android.startKoin

class SunflowerApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(sunflowerModule))
    }
}