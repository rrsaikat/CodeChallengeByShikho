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
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity:AppCompatActivity(), HasSupportFragmentInjector{

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var app:App

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        app.doForCreate(this)
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
        app.doForFinish(this)
    }

    fun clear() {
        super.finish()
    }
}