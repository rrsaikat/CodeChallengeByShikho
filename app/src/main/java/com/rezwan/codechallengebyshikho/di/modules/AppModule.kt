package com.rezwan.codechallengebyshikho.di.modules

import android.app.Application
import android.content.Context
import com.rezwan.codechallengebyshikho.App
import com.rezwan.codechallengebyshikho.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * AppModule will provide app-wide dependencies for a part of the application.
 * It should initialize objects used across our application, such as Room database, Retrofit, Shared Preference, etc.
 */

@Module
class AppModule {
    var mApplication =  App()

    fun AppModule(application: App){
        mApplication = application
    }

    @Provides
    @Singleton
    fun providesApplication(): Application {
        return mApplication
    }


}