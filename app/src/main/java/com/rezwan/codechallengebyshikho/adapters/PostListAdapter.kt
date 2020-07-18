package com.rezwan.etracker.mizanur.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rezwan.codechallengebyshikho.LoadAllPostsQuery
import com.rezwan.codechallengebyshikho.R
import com.rezwan.codechallengebyshikho.databinding.ItemPostBinding

class PostListAdapter(
    var list: List<LoadAllPostsQuery.Data1>,
    val btnClick: (LoadAllPostsQuery.Data1) -> Unit = {}
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
            binding?.tvTitle?.text = it.title ?: ""
            binding?.tvId?.text = it.title?.take(0)?: ""
        }
    }

    fun updatedata(list: List<LoadAllPostsQuery.Data1>){
        this.list = list
        notifyDataSetChanged()
    }

    inner class ListPostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ItemPostBinding? = DataBindingUtil.bind(view)

        init {
            view.setOnClickListener {
                btnClick(list[adapterPosition])
            }
        }
    }
}