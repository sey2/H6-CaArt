package org.softeer_2nd.caArt

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CaArtApplication : Application() {

    init {
        instance = this
    }

    companion object {
        lateinit var instance: CaArtApplication
        fun getApplicationContext(): Context {
            return instance.applicationContext
        }
    }
}