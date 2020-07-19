package com.rezwan.codechallengebyshikho.ui.fragments


import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.rezwan.codechallengebyshikho.GetAlbumQuery
import com.rezwan.codechallengebyshikho.R
import com.rezwan.codechallengebyshikho.databinding.FragmentUserBinding
import com.rezwan.codechallengebyshikho.di.ViewModelFactory
import com.rezwan.codechallengebyshikho.ext.error
import com.rezwan.codechallengebyshikho.ui.base.BaseFragment
import com.rezwan.codechallengebyshikho.ui.viewmodel.SharedViewModel
import com.rezwan.codechallengebyshikho.utils.GridItemDecoration
import com.rtchubs.filmadmin.adapters.PhotoListAdapter
import javax.inject.Inject


class UserFragment : BaseFragment<FragmentUserBinding>(){

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val viewModel: SharedViewModel by viewModels { viewModelFactory }


    override fun getLayoutRes(): Int = R.layout.fragment_user

    override fun setUpInitializers() {
        viewModel.getAlbum("1")
    }

    override fun setUpListener() {
        initRecyclerConfig()
    }

    override fun setUpObservers() {
        viewModel.photoAlbumLivedata.observe(this, Observer { photoList ->
            photoList?.let {
                val adapter = PhotoListAdapter(it.data as List<GetAlbumQuery.Data1>) {}
                binding.recyclerUser.adapter = adapter
                adapter.notifyDataSetChanged()
                error(this, "Done")
            }
        })


        viewModel.isLoading.observe(this, Observer { loadervalue ->
            binding.progressBarAlbum.isVisible = loadervalue
            binding.swipeRefreshAlbumLayout.isRefreshing = false
        })
    }

    override fun onCreate() {

    }

    private fun initRecyclerConfig(){
        with( binding.recyclerUser){
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            addItemDecoration(GridItemDecoration(10, 2))
        }
    }
}