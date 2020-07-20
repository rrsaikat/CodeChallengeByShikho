package com.rezwan.codechallengebyshikho.di

import android.app.Application
import android.content.Context
import com.apollographql.apollo.ApolloClient
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rezwan.codechallengebyshikho.App
import com.rezwan.codechallengebyshikho.BuildConfig
import com.rezwan.codechallengebyshikho.di.modules.ContextModule
import com.rezwan.codechallengebyshikho.utils.UserAgentInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
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