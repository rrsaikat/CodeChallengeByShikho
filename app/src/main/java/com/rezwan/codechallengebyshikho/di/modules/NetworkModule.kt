package com.rezwan.codechallengebyshikho.di.modules

import com.apollographql.apollo.ApolloClient
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rezwan.codechallengebyshikho.const.appconst.BASE_URL
import com.rezwan.codechallengebyshikho.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder()
            .setLenient()
            .create()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
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