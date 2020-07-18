package com.rezwan.codechallengebyshikho.data.data_source

import com.apollographql.apollo.ApolloClient
import com.rezwan.codechallengebyshikho.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataSourceModule {
    @Provides
    @Singleton
    internal fun provideDataSource(apolloClient: ApolloClient): PostDataSource {
        return PostDataSourceImp(apolloClient)
    }

}