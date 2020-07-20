package com.rezwan.codechallengebyshikho.ui.base

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.rezwan.codechallengebyshikho.App
import com.rezwan.codechallengebyshikho.R
import com.rezwan.codechallengebyshikho.ui.info.InfoActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity: DaggerAppCompatActivity() {
//    @Inject
//    lateinit var app:App

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        AndroidInjection.inject(this)
        //app.doForCreate(this)
        initToollbarNav()
        setUpLayoutBinding()
        setUpInitializers()
    }

    abstract fun setUpLayoutBinding()

    abstract fun setUpInitializers()

    private fun initToollbarNav() {
        supportActionBar?.apply {
            title = toolbarTitle()
            setDisplayHomeAsUpEnabled(!isTaskRoot)
            setHomeButtonEnabled(!isTaskRoot)
            setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24)
        }
    }

    abstract fun toolbarTitle(): CharSequence?

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                super.onBackPressed()
            }

            R.id.action_info -> {
                startActivity(Intent(this, InfoActivity::class.java))
            }
        }

        return false
    }

    override fun onDestroy() {
        super.onDestroy()
        //app.doForFinish(this)
    }

    fun clear() {
        super.finish()
    }
}