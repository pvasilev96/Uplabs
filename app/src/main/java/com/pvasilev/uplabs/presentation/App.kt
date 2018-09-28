package com.pvasilev.uplabs.presentation

import android.app.Application
import com.pvasilev.uplabs.BuildConfig
import com.pvasilev.uplabs.di.DI
import timber.log.Timber
import toothpick.Toothpick
import toothpick.configuration.Configuration

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupToothpick()
        setupTimber()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun setupToothpick() {
        if (BuildConfig.DEBUG) {
            Toothpick.setConfiguration(Configuration.forDevelopment().preventMultipleRootScopes())
        } else {
            Toothpick.setConfiguration(Configuration.forProduction().disableReflection())
        }
        Toothpick.openScope(DI.APP_SCOPE)
    }
}