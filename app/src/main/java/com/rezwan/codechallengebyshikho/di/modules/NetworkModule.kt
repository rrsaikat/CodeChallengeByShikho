/*
 * Copyright 2020 RRsaikat. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rezwan.codechallengebyshikho.di.modules

import android.content.Context
import com.apollographql.apollo.ApolloClient
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rezwan.codechallengebyshikho.BuildConfig.BASE_URL
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