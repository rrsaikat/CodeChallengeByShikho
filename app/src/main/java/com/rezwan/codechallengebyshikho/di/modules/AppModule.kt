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