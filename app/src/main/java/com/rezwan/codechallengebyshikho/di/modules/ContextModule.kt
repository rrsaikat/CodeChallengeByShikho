package com.rezwan.codechallengebyshikho.di.modules

import android.content.Context
import com.rezwan.codechallengebyshikho.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ContextModule {

    @Provides
    @Singleton
    fun providesContext(): Context {
        return App()
    }

}