package com.rezwan.codechallengebyshikho.ui.info


import com.rezwan.codechallengebyshikho.databinding.ActivityInfoBinding
import com.rezwan.codechallengebyshikho.ext.openWebPage
import com.rezwan.codechallengebyshikho.ui.base.BaseActivity

class InfoActivity : BaseActivity() {
    private lateinit var binding: ActivityInfoBinding

    override fun setUpLayoutBinding() {
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun setUpInitializers() {
        binding.button.setOnClickListener { openWebPage("https://www.linkedin.com/in/rrsaikat/") }
        binding.button2.setOnClickListener { openWebPage("https://github.com/rrsaikat") }
        binding.button3.setOnClickListener { openWebPage("https://www.youtube.com/channel/UC-rpxiM_dXeW33iJsGx6UOQ") }

    }

    override fun toolbarTitle(): CharSequence?  = "Dev info"
}