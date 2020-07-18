package com.beyazidyargici.pokeinfo.di.module

import androidx.lifecycle.ViewModelProvider
import com.rezwan.codechallengebyshikho.di.ViewModelFactory
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
