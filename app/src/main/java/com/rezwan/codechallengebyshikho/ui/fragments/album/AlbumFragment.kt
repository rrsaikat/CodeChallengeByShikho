package com.rezwan.codechallengebyshikho.ui.fragments.album


import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.rezwan.codechallengebyshikho.App
import com.rezwan.codechallengebyshikho.R
import com.rezwan.codechallengebyshikho.databinding.FragmentAlbumBinding
import com.rezwan.codechallengebyshikho.ui.base.BaseFragment
import com.rezwan.codechallengebyshikho.utils.GridItemDecoration
import com.rtchubs.filmadmin.adapters.PhotoListAdapter
import javax.inject.Inject


class AlbumFragment : BaseFragment<FragmentAlbumBinding>(), SwipeRefreshLayout.OnRefreshListener {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: AlbumViewModel

    override fun getLayoutRes(): Int = R.layout.fragment_album


    override fun onCreateView() {

    }

    override fun setUpInitializers() {
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(AlbumViewModel::class.java)

        binding.viewModel = viewModel
        binding.recyclerUser.adapter = PhotoListAdapter(ArrayList()) {}
    }

    override fun setUpListener() {
        initRecyclerConfig()
        binding.swipeRefreshAlbumLayout.setOnRefreshListener(this)
    }

    override fun setUpObservers() {

    }

    private fun initRecyclerConfig(){
        with( binding.recyclerUser){
            setHasFixedSize(true)
//            layoutManager = GridLayoutManager(context, 2)
            addItemDecoration(GridItemDecoration(10, 2))
        }
    }

    override fun onRefresh() {

    }
}