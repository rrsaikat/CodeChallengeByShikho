package com.rezwan.codechallengebyshikho.di.modules

import com.rezwan.codechallengebyshikho.ui.home.HomeActivity
import com.rezwan.codechallengebyshikho.ui.info.InfoActivity
import com.rezwan.codechallengebyshikho.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * All activities intended to use Dagger @Inject should be listed here.
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentModule::class]) // Where to apply the injection.
    abstract fun contributeHomeActivity(): HomeActivity


    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun contributeInfoActivity(): InfoActivity
}