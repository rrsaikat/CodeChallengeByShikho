package com.rezwan.codechallengebyshikho.di.modules


import com.rezwan.codechallengebyshikho.data.dao.AllPostDao
import com.rezwan.codechallengebyshikho.data.data_source.DataSourceModule
import com.rezwan.codechallengebyshikho.data.data_source.PostDataSource
import com.rezwan.codechallengebyshikho.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [DatabaseModule::class, DataSourceModule::class])
class RepositoryModule {
 /*   @Provides
    @Singleton
    internal fun provideRepository(allPokemonDao: AllPostDao, pokemonDataSource: PostDataSource): PostRepo{
        return PostRepoImp(allPokemonDao,pokemonDataSource)
    }


*/

}