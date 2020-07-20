package com.rezwan.codechallengebyshikho.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


abstract class BaseFragment<DB : ViewDataBinding> : ScopedFragment() {

    open lateinit var binding: DB


    private fun init(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        binding.lifecycleOwner = this
    }

    abstract fun onCreateView()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        onCreateView()
        init(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpInitializers()
        setUpListener()
        setUpObservers()
    }

    @LayoutRes
    abstract fun getLayoutRes(): Int

    abstract fun setUpInitializers()

    abstract fun setUpListener()

    abstract fun setUpObservers()
}