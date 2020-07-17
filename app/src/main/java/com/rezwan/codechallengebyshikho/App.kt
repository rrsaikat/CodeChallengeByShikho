package com.rezwan.codechallengebyshikho

import android.app.Application
import android.os.StrictMode

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        if (android.os.Build.VERSION.SDK_INT > 16) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }
    }
}