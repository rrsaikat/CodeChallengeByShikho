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
    var list: List<Post>,
    val btnClick: (Post) -> Unit = {}
) : BaseAdapter<Post>(list) {

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

    fun updatedata(list: List<Post>){
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