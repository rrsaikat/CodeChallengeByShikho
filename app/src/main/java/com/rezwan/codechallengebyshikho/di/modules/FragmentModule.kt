package com.rezwan.codechallengebyshikho.di.modules

import com.rezwan.codechallengebyshikho.ui.fragments.PostListFragment
import com.rezwan.codechallengebyshikho.ui.fragments.AlbumFragment
import com.rezwan.codechallengebyshikho.ui.fragments.QLFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * All fragments related to HomeActivity intended to use Dagger @Inject should be listed here.
 */
@Module
abstract class FragmentModule {

    @ContributesAndroidInjector() // Attaches fragment to Dagger graph.
    abstract fun contributeUserFragment(): AlbumFragment

    @ContributesAndroidInjector() // Attaches fragment to Dagger graph.
    abstract fun contributePostListFragment(): PostListFragment

    @ContributesAndroidInjector() // Attaches fragment to Dagger graph.
    abstract fun contributeQLFragment(): QLFragment

}