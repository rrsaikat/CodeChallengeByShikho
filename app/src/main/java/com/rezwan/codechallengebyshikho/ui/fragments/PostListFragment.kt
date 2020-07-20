package com.rezwan.codechallengebyshikho.ui.fragments

import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.rezwan.codechallengebyshikho.LoadAllPostsQuery
import com.rezwan.codechallengebyshikho.R
import com.rezwan.codechallengebyshikho.data.data_source.Result
import com.rezwan.codechallengebyshikho.databinding.FragmentPostListBinding
import com.rezwan.codechallengebyshikho.di.ViewModelFactory
import com.rezwan.codechallengebyshikho.ext.error
import com.rezwan.codechallengebyshikho.ext.showShortToast
import com.rezwan.codechallengebyshikho.ext.validatelistener
import com.rezwan.codechallengebyshikho.model.Post
import com.rezwan.codechallengebyshikho.ui.base.BaseFragment
import com.rezwan.codechallengebyshikho.ui.viewmodel.SharedViewModel
import com.rezwan.etracker.mizanur.adapters.PostListAdapter
import com.rtchubs.filmadmin.adapters.PhotoListAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject


class PostListFragment : BaseFragment<FragmentPostListBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val viewModel: SharedViewModel by viewModels { viewModelFactory }


    override fun onCreate() {

    }

    override fun getLayoutRes(): Int = R.layout.fragment_post_list

    override fun setUpInitializers() {
        initRecyclerConfig()
    }

    override fun setUpListener() {
        binding.fabAddPost.setOnClickListener { showAddPostDialog() }
    }


    override fun setUpObservers() {
        viewModel.posts.observe(this, Observer { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    binding.progressbar.isVisible = false
                    result.data?.let {
                        val adapter = PostListAdapter(it) {}
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
        })
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
                else viewModel.createPostQuery(title, body)
            }

            setNegativeButton("Cancel") { dialog, whichButton -> }
        }
        alert.show()
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
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PostListFragment()
    }
}