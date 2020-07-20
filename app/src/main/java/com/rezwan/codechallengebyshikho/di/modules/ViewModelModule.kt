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
