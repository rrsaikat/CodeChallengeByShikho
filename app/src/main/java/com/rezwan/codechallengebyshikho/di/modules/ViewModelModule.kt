package com.rezwan.codechallengebyshikho.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rezwan.codechallengebyshikho.di.ViewModelFactory
import com.rezwan.codechallengebyshikho.di.ViewModelKey
import com.rezwan.codechallengebyshikho.ui.viewmodel.SharedViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Will be responsible for providing ViewModels.
 */
@Module
abstract class ViewModelsModule {

    // We'd like to take this implementation of the ViewModel class and make it available in an injectable map with MainViewModel::class as a key to that map.
    @Binds
    @IntoMap
    @ViewModelKey(SharedViewModel::class) // We use a restriction on multibound map defined with @ViewModelKey annotation, and if don't need any, we should use @ClassKey annotation provided by Dagger.
    abstract fun bindSharedViewModel(mainViewModel: SharedViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}