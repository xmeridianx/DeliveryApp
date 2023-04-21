package com.example.meatdeliveryapp.categories

import android.app.Application

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        // инициализация приложения, если нужно
    }

    companion object {
        var instance: MyApp? = null
            private set
    }

    init {
        instance = this
    }
}