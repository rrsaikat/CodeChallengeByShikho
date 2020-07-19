package com.rezwan.codechallengebyshikho.di.modules


import com.rezwan.codechallengebyshikho.data.dao.UserPostDao
import com.rezwan.codechallengebyshikho.data.data_source.DataSourceModule
import com.rezwan.codechallengebyshikho.data.data_source.PostRemoteDataSource
import com.rezwan.codechallengebyshikho.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [DatabaseModule::class, DataSourceModule::class])
class RepositoryModule {
    @Provides
    @Singleton
    internal fun provideRepository(postDao: UserPostDao, postRemoteDataSource: PostRemoteDataSource): UserRepository{
        return UserRepository(postDao, postRemoteDataSource)
    }
}