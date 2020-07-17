package com.rezwan.codechallengebyshikho.ui.base

import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity:AppCompatActivity(), CoroutineScope {
    internal val disposable = CompositeDisposable()
    internal val job = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onDestroy() {
        disposable.dispose()
        coroutineContext.cancelChildren()
        super.onDestroy()
    }
}