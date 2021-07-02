package com.module.footballscores.dagger.component

import com.module.footballscores.dagger.module.NetworkModule
import com.module.footballscores.dagger.module.viewModule.ViewModelModule
import com.module.footballscores.ui.ActivityMatchResult
import com.module.footballscores.ui.FragmentMatchResult
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(activityMatchResult: ActivityMatchResult)
    fun inject(fragmentMatchResult: FragmentMatchResult)


}