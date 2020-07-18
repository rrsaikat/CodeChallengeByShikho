package com.rezwan.codechallengebyshikho.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.rezwan.codechallengebyshikho.R
import com.rezwan.codechallengebyshikho.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(Runnable {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, 2000)
    }
}