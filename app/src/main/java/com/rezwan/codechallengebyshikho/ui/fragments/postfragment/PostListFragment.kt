package com.rezwan.codechallengebyshikho.ui.fragments.postfragment

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.rezwan.codechallengebyshikho.LoadAllPostsQuery
import com.rezwan.codechallengebyshikho.R
import com.rezwan.codechallengebyshikho.databinding.FragmentPostListBinding
import com.rezwan.codechallengebyshikho.di.ViewModelFactory
import com.rezwan.codechallengebyshikho.ui.base.BaseFragment
import com.rezwan.etracker.mizanur.adapters.PostListAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject


class PostListFragment : BaseFragment<FragmentPostListBinding>(),
    SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val viewModel: PostListViewModel by viewModels { viewModelFactory }

    var plistAdapter = PostListAdapter(ArrayList()) {}


    override fun onCreate() {

    }

    override fun getLayoutRes(): Int = R.layout.fragment_post_list

    override fun setUpInitializers() {
        initRecyclerConfig()
    }

    override fun setUpListener() {
        binding.swipeRefreshLayout.setOnRefreshListener(this)
    }

    override fun setUpObservers() {
        bindUI()
        viewModel.getPosts()
    }

    // Global.launch is not good option because fragment has a lifecycle.
    // We create ScopedFragment and this fragment extended from ScopedFragment for this reason.
    private fun bindUI() = launch {
        viewModel.postLivedata.observe(this@PostListFragment, Observer { postList ->
            postList.data?.let {
                plistAdapter.updatedata(it as List<LoadAllPostsQuery.Data1>)
            }

        })


        viewModel.isLoading.observe(this@PostListFragment, Observer { loadervalue ->
            binding.progressbar.isVisible = loadervalue
        })
    }

    private fun initRecyclerConfig() {
        binding.recyclerPostlist.setHasFixedSize(true)
        plistAdapter = PostListAdapter(
            listOf(
                LoadAllPostsQuery.Data1("", "", ""),
                LoadAllPostsQuery.Data1("", "", ""),
                LoadAllPostsQuery.Data1("", "", ""),
                LoadAllPostsQuery.Data1("", "", ""),
                LoadAllPostsQuery.Data1("", "", ""),
                LoadAllPostsQuery.Data1("", "", ""),
                LoadAllPostsQuery.Data1("", "", "")
            )
        ) {

        }

        binding.recyclerPostlist.adapter = plistAdapter
        plistAdapter.notifyDataSetChanged()

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PostListFragment()
    }

    override fun onRefresh() {
        viewModel.getPosts()
    }


}