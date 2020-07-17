package com.rezwan.codechallengebyshikho.di.modules

import com.rezwan.codechallengebyshikho.ui.fragments.FirstFragment
import com.rezwan.codechallengebyshikho.ui.fragments.SecondFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * All fragments related to MainActivity intended to use Dagger @Inject should be listed here.
 */
@Module
abstract class HomeFragmentListBuilderModule {

    @ContributesAndroidInjector() // Attaches fragment to Dagger graph.
    abstract fun contributeFirstFragment(): FirstFragment

    @ContributesAndroidInjector() // Attaches fragment to Dagger graph.
    abstract fun contributeSecondFragment(): SecondFragment

}