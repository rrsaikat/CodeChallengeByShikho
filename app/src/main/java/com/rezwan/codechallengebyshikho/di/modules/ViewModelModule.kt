package com.beyazidyargici.pokeinfo.di.module

import androidx.lifecycle.ViewModel
import com.rezwan.codechallengebyshikho.di.ViewModelKey
import com.rezwan.codechallengebyshikho.ui.viewmodel.SharedViewModel
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
    @ViewModelKey(SharedViewModel::class)
    protected abstract fun bindPostListViewModel(sharedViewModel: SharedViewModel): ViewModel
}
