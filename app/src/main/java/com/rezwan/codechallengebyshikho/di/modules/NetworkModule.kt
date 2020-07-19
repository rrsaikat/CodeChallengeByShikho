package com.rezwan.codechallengebyshikho.di.modules

import android.content.Context
import android.webkit.WebSettings
import com.apollographql.apollo.ApolloClient
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rezwan.codechallengebyshikho.const.appconst.BASE_URL
import com.rezwan.codechallengebyshikho.data.data_source.DataSourceModule
import com.rezwan.codechallengebyshikho.data.repository.UserRepository
import com.rezwan.codechallengebyshikho.utils.UserAgentInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [ContextModule::class])
class NetworkModule {

    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder()
            .setLenient()
            .create()

    @Provides
    @Singleton
    fun providesOkHttpUserAgentInterceptor(context: Context): UserAgentInterceptor {
        return UserAgentInterceptor(context)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(userAgentInterceptor: UserAgentInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(userAgentInterceptor)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()


    @Provides
    @Singleton
    fun provideApolloClient(gson: Gson, okHttpClient: OkHttpClient): ApolloClient =
        ApolloClient.builder()
            .serverUrl(BASE_URL)
            .okHttpClient(okHttpClient)
            .build()


}