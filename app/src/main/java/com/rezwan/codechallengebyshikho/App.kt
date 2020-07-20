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

package com.rezwan.codechallengebyshikho

import android.app.Activity
import android.app.Application
import android.os.StrictMode
import com.rezwan.codechallengebyshikho.di.components.DaggerAppComponent
import com.rezwan.codechallengebyshikho.di.modules.DatabaseModule
import com.rezwan.codechallengebyshikho.di.modules.NetworkModule
import com.rezwan.codechallengebyshikho.ui.base.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App:Application() , HasActivityInjector{
    private var activityList: MutableList<BaseActivity>? = null

    @Inject // It implements Dagger machinery of finding appropriate injector factory for a type.
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    // This is required by HasActivityInjector interface to setup Dagger for Activity.
    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        // This will help us to overcome cross orogin issue
        activityList = ArrayList<BaseActivity>()
        if (android.os.Build.VERSION.SDK_INT > 21) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }
        // Initialize in order to automatically inject activities and fragments if they implement Injectable interface.
        DaggerAppComponent.builder()
            .application(this)
            .networkModule(NetworkModule())
            .databaseModule(DatabaseModule())
            .build()
            .inject(this)
    }

    fun doForCreate(activity: BaseActivity) {
        activityList?.add(activity)
    }

    fun doForFinish(activity: BaseActivity) {
        activityList?.remove(activity)
    }


    fun clearAllActivity() {
        if (activityList != null && activityList!!.size > 0)

            for (activity in activityList!!) {
                if (activity != null) activity.clear()
            }
        activityList?.clear()
    }

}