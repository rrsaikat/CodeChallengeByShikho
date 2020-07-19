package com.rezwan.codechallengebyshikho.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext

open class BaseViewModel:ViewModel(), CoroutineScope {
    private val job = Job()
    internal val disposable = CompositeDisposable()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main // this job will be running on the main dispatcher(main thread)


    override fun onCleared() {
        super.onCleared()
        job.cancel()
        disposable.dispose()
        coroutineContext.cancelChildren()
    }
}