/*
 * Copyright 2020 RRsaikat. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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