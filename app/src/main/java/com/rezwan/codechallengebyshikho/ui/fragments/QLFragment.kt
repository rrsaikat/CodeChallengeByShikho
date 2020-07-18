package com.rezwan.codechallengebyshikho.ui.fragments


import com.rezwan.codechallengebyshikho.R
import com.rezwan.codechallengebyshikho.databinding.FragmentQueryBinding
import com.rezwan.codechallengebyshikho.ui.base.BaseFragment
import dagger.android.support.AndroidSupportInjection

class QLFragment : BaseFragment<FragmentQueryBinding>(){
    override fun getLayoutRes(): Int = R.layout.fragment_query

    override fun setUpInitializers() {

    }

    override fun setUpListener() {

    }

    override fun setUpObservers() {

    }

    override fun onCreate() {
        //AndroidSupportInjection.inject(this)
    }


}