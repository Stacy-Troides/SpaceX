package com.example.spacexlist

import android.app.Application
import com.example.spacexlist.di.AppComponent
import com.example.spacexlist.di.DaggerAppComponent

class App : Application() {

    private var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

    fun getComponent(): AppComponent? =
        appComponent

}