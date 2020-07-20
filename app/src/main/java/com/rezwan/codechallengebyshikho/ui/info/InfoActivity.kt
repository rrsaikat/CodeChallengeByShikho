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