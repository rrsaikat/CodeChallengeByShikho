package com.rezwan.etracker.mizanur.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rezwan.codechallengebyshikho.LoadAllPostsQuery
import com.rezwan.codechallengebyshikho.R
import com.rezwan.codechallengebyshikho.databinding.ItemPostBinding
import com.rezwan.codechallengebyshikho.model.Post

class PostListAdapter(
    var list: List<LoadAllPostsQuery.Data1>,
    val btnClick: (Post) -> Unit = {}
) : BaseAdapter<LoadAllPostsQuery.Data1>(list) {

    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ListPostViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_post, parent, false)
        )
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ListPostViewHolder).binding
        list[position].let {
            binding?.tvId?.text = it.id ?: ""
            binding?.tvPosttitle?.text = "Post : " + it.id ?: ""
            binding?.tvPostDetails?.text = it.title ?: ""
        }
    }

    fun updatedata(list: List<LoadAllPostsQuery.Data1>){
        this.list = list
        notifyDataSetChanged()
    }

    inner class ListPostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ItemPostBinding? = DataBindingUtil.bind(view)

        init {
//            binding?.btnDelete?.setOnClickListener {
//                btnClick(Post(PostAction.DELETE, list[adapterPosition]))
//            }
//
//            binding?.btnEdit?.setOnClickListener {
//                btnClick(Post(PostAction.EDIT, list[adapterPosition]))
//            }
        }
    }
}