package com.rezwan.codechallengebyshikho.ui.fragments.post

import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.rezwan.codechallengebyshikho.R
import com.rezwan.codechallengebyshikho.databinding.FragmentPostListBinding
import com.rezwan.codechallengebyshikho.ext.showShortToast
import com.rezwan.codechallengebyshikho.ext.validatelistener
import com.rezwan.codechallengebyshikho.model.Post
import com.rezwan.codechallengebyshikho.ui.base.BaseFragment
import com.rezwan.etracker.mizanur.adapters.PostListAdapter
import kotlinx.coroutines.launch


class PostListFragment : BaseFragment<FragmentPostListBinding>(),
    SwipeRefreshLayout.OnRefreshListener {

    var plistAdapter = PostListAdapter(ArrayList()) {}


    override fun onCreateView() {

    }

    override fun getLayoutRes(): Int = R.layout.fragment_post_list

    override fun setUpInitializers() {
        initRecyclerConfig()
    }

    override fun setUpListener() {
        binding.swipeRefreshLayout.setOnRefreshListener(this)
        binding.fabAddPost.setOnClickListener { showAddPostDialog() }
    }


    override fun setUpObservers() {
        //bindUI()
        //viewModel.getPosts()
        /*viewModel.posts.observe(this, Observer { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    binding.progressbar.isVisible = true
                    result.data?.let {
                        val adapter = PostListAdapter(it) { onPostActionClicked(it)}
                        binding.recyclerPostlist.adapter = adapter
                        adapter.notifyDataSetChanged()
                    }
                }
                Result.Status.LOADING -> binding.progressbar.isVisible = true
                Result.Status.ERROR -> {
                    binding.progressbar.isVisible = false
                    Snackbar.make(binding.root, result.message!!, Snackbar.LENGTH_LONG).show()
                }
            }
        })*/
    }

    private fun showAddPostDialog() {
        val factory = LayoutInflater.from(requireContext())
        val textEntryView: View = factory.inflate(R.layout.add_post_entry, null)
        val titleField = textEntryView.findViewById<View>(R.id.edt_title) as EditText
        val bodyField = textEntryView.findViewById<View>(R.id.edt_body) as EditText

        titleField.validatelistener(bodyField)
        bodyField.validatelistener(titleField)

        val alert: AlertDialog.Builder = AlertDialog.Builder(requireContext()).apply {
            setTitle("Hi")
            setMessage("To add a new post we need some information")
            setCancelable(false)
            setView(textEntryView)
            setPositiveButton("Submit") { dialog, whichButton ->
                val title: String = titleField.text.toString()
                val body: String = bodyField.text.toString()
                if (title.isEmpty() || body.isEmpty()) context.showShortToast("Field cann't be empty")
//                else
//                    viewModel.createPostQuery(title, body)
            }

            setNegativeButton("Cancel") { dialog, whichButton -> }
        }
        alert.show()
    }

    // Global.launch is not good option because fragment has a lifecycle.
    // We create ScopedFragment and this fragment extended from ScopedFragment for this reason.
    private fun bindUI() = launch {
//        viewModel.postLivedata.observe(this@PostListFragment, Observer { postList ->
//            postList.data?.let {
//               /* val adapter = PostListAdapter(it as List<LoadAllPostsQuery.Data1>) { onPostActionClicked(it)}
//                binding.recyclerPostlist.adapter = adapter
//                adapter.notifyDataSetChanged()*/
//                error(this, "Done")
//            }
//        })
//
//
//        viewModel.isLoading.observe(this@PostListFragment, Observer { loadervalue ->
//            binding.progressbar.isVisible = loadervalue
//            binding.swipeRefreshLayout.isRefreshing = false
//        })
    }

    private fun onPostActionClicked(post: Post) {
//        if (post.postAction == PostAction.EDIT){
//            context?.showShortToast("Edit")
//        }else if (post.postAction == PostAction.DELETE){
//            context?.showShortToast("DELETE")
//        }
    }

    private fun initRecyclerConfig() {
        binding.recyclerPostlist.setHasFixedSize(true)
        binding.recyclerPostlist.adapter = plistAdapter
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PostListFragment()
    }

    override fun onRefresh() {
//        viewModel.getPosts()
    }
}