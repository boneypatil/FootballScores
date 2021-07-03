package com.module.footballscores.dagger.module.viewModule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.dagger.module.viewModule.ViewModelFactory
import com.module.footballscores.viewmodel.MatchResultViewModel
import com.module.footballscores.utils.ViewModelKey


import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MatchResultViewModel::class)
    internal abstract fun bindNewsViewModel(viewModel: MatchResultViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}