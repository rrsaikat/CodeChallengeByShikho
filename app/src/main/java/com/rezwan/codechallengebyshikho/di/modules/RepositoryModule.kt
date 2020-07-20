package com.rezwan.codechallengebyshikho.di.modules


import com.rezwan.codechallengebyshikho.data.dao.PostDao
import com.rezwan.codechallengebyshikho.data.data_source.DataSourceModule
import com.rezwan.codechallengebyshikho.data.data_source.BaseRemoteDataSource
import com.rezwan.codechallengebyshikho.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [DatabaseModule::class, DataSourceModule::class])
class RepositoryModule {
//    @Provides
//    @Singleton
//    internal fun provideRepository(postDao: PostDao, postRemoteDataSource: BaseRemoteDataSource): UserRepository{
//        return UserRepository(postDao, postRemoteDataSource)
//    }
}