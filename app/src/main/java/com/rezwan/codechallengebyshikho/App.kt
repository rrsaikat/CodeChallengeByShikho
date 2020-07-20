package com.rezwan.codechallengebyshikho

import android.app.Activity
import android.app.Application
import android.os.StrictMode
import com.rezwan.codechallengebyshikho.di.AppComponent
import com.rezwan.codechallengebyshikho.ui.base.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class App:Application(), HasActivityInjector {
    private var activityList: MutableList<BaseActivity>? = null


    override fun onCreate() {
        super.onCreate()
        // This will help us to overcome cross orogin issue
        activityList = ArrayList<BaseActivity>()
        if (android.os.Build.VERSION.SDK_INT > 21) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

        DaggerAppComponent.builder()
            .application(this)
//            .databaseModule(DatabaseModule())
//            .networkModule(NetworkModule())
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

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector


}