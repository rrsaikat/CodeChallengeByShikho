package com.rezwan.codechallengebyshikho

import android.app.Activity
import android.app.Application
import android.os.StrictMode
import com.rezwan.codechallengebyshikho.di.components.DaggerAppComponent
import com.rezwan.codechallengebyshikho.di.modules.DatabaseModule
import com.rezwan.codechallengebyshikho.di.modules.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App:Application() , HasActivityInjector{
    @Inject // It implements Dagger machinery of finding appropriate injector factory for a type.
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    // This is required by HasActivityInjector interface to setup Dagger for Activity.
    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        if (android.os.Build.VERSION.SDK_INT > 16) {
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



}