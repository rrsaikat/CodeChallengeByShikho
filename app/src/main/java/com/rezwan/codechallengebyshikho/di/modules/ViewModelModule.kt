package com.beyazidyargici.pokeinfo.di.module

import androidx.lifecycle.ViewModel
import com.rezwan.codechallengebyshikho.di.ViewModelKey
import com.rezwan.codechallengebyshikho.ui.fragments.postfragment.PostListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal abstract class ViewModelModule {

    /*
     * This method basically says
     * inject this object into a Map using the @IntoMap annotation,
     * with the  SharedViewModel.class as key,
     * and a Provider that will build a SharedViewModel
     * object.
     *
     * */
    @Binds
    @IntoMap
    @ViewModelKey(PostListViewModel::class)
    protected abstract fun bindPostListViewModel(postListViewModel: PostListViewModel): ViewModel
}
