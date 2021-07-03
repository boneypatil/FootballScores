package com.module.footballscores.dagger

import android.app.Application
import com.module.footballscores.dagger.component.AppComponent
import com.module.footballscores.dagger.component.DaggerAppComponent
import com.module.footballscores.dagger.module.NetworkModule


class App : Application(){

    companion object{ lateinit var appComponent: AppComponent }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().networkModule(NetworkModule(this))
            .build()
    }
}