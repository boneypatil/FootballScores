package com.module.footballscores.dagger.component

import com.module.footballscores.dagger.module.NetworkModule
import com.module.footballscores.dagger.module.viewModule.ViewModelModule
import com.module.footballscores.ui.ActivityMatchResult
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(activityMatchResult: ActivityMatchResult)
}