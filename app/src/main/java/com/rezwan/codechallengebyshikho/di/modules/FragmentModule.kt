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