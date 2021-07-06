package com.module.footballscores.dagger

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import com.module.footballscores.dagger.component.AppComponent
import com.module.footballscores.dagger.component.DaggerAppComponent
import com.module.footballscores.dagger.module.NetworkModule
import com.module.footballscores.utils.DetectConnection


class App : Application(){

    companion object{ lateinit var appComponent: AppComponent }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().networkModule(NetworkModule(this))
            .build()

        DetectConnection.initialize(this)
    }
}