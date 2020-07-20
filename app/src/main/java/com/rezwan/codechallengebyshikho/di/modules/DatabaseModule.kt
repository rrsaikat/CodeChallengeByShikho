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