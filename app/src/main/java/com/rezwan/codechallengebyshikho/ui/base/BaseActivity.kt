package com.rezwan.codechallengebyshikho.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpLayoutBinding()
        setUpInitializers()
    }

    abstract fun setUpLayoutBinding()

    abstract fun setUpInitializers()

    override fun onDestroy() {
        super.onDestroy()
    }
}