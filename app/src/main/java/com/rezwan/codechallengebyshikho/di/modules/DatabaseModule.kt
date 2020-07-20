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
import com.rezwan.codechallengebyshikho.data.data_source.AppDatabase
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton


@Module(includes = [AppModule::class])
class DatabaseModule {
//    @Singleton
//    @Provides
//    fun provideDb(app: Application) = AppDatabase.getInstance(app)
//
//    @Singleton
//    @Provides
//    fun providePostDao(db: AppDatabase) = db.postDao()


//    @Singleton
//    @Provides
//    fun provideLegoThemeDao(db: AppDatabase) = db.legoThemeDao()

}