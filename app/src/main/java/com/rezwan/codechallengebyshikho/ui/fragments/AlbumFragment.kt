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

package com.rezwan.codechallengebyshikho.ui.fragments


import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar
import com.rezwan.codechallengebyshikho.R
import com.rezwan.codechallengebyshikho.data.data_source.Result
import com.rezwan.codechallengebyshikho.databinding.FragmentAlbumBinding
import com.rezwan.codechallengebyshikho.di.ViewModelFactory
import com.rezwan.codechallengebyshikho.ui.base.BaseFragment
import com.rezwan.codechallengebyshikho.ui.viewmodel.SharedViewModel
import com.rezwan.codechallengebyshikho.utils.GridItemDecoration
import com.rtchubs.filmadmin.adapters.PhotoListAdapter
import javax.inject.Inject


class AlbumFragment : BaseFragment<FragmentAlbumBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val viewModel: SharedViewModel by viewModels { viewModelFactory }


    override fun getLayoutRes(): Int = R.layout.fragment_album

    override fun setUpInitializers() {

    }

    override fun setUpListener() {
        initRecyclerConfig()
    }

    override fun setUpObservers() {
        viewModel.photos.observe(this, Observer { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    binding.progressBarAlbum.isVisible = false
                    result.data?.let {
                        val adapter = PhotoListAdapter(it) {}
                        binding.recyclerUser.adapter = adapter
                        adapter.notifyDataSetChanged()
                    }
                }
                Result.Status.LOADING -> binding.progressBarAlbum.isVisible = true
                Result.Status.ERROR -> {
                    binding.progressBarAlbum.isVisible = false
                    Snackbar.make(binding.root, result.message!!, Snackbar.LENGTH_LONG).show()
                }
            }
        })
    }

    override fun onCreate() {

    }

    private fun initRecyclerConfig(){
        with( binding.recyclerUser){
            setHasFixedSize(true)
//            layoutManager = GridLayoutManager(context, 2)
            addItemDecoration(GridItemDecoration(10, 2))
        }
    }
}