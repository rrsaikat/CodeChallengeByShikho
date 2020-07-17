package com.rezwan.codechallengebyshikho

import android.app.Activity
import android.app.Application
import android.os.StrictMode
import com.rezwan.codechallengebyshikho.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App:Application() , HasActivityInjector{
    @Inject // It implements Dagger machinery of finding appropriate injector factory for a type.
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        // Initialize in order to automatically inject activities and fragments if they implement Injectable interface.
        AppInjector.init(this)
    }


    // This is required by HasActivityInjector interface to setup Dagger for Activity.
    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector
}