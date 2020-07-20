package com.rezwan.codechallengebyshikho.data.data_source

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataSourceModule {
    @Provides
    @Singleton
    internal fun provideDataSource(apolloClient: ApolloClient): PostDataSource {
        return PostRemoteDataSource(apolloClient)
    }

}