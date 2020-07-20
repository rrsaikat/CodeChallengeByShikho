package com.rezwan.codechallengebyshikho.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rezwan.codechallengebyshikho.ui.fragments.album.AlbumViewModel
import com.rezwan.codechallengebyshikho.ui.fragments.post.PostListViewModel
import com.rezwan.codechallengebyshikho.ui.fragments.query.QueryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AlbumViewModel::class)
    abstract fun bindAlbumViewModell(viewModel: AlbumViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostListViewModel::class)
    abstract fun bindPostListViewModel(viewModel: PostListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(QueryViewModel::class)
    abstract fun bindQueryViewModel(viewModel: QueryViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}
