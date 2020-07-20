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

package com.rtchubs.filmadmin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.rezwan.codechallengebyshikho.App
import com.rezwan.codechallengebyshikho.GetAlbumQuery
import com.rezwan.codechallengebyshikho.R
import com.rezwan.codechallengebyshikho.databinding.ItemAlbumBinding
import com.rezwan.codechallengebyshikho.model.Photo
import com.rezwan.etracker.mizanur.adapters.BaseAdapter
import javax.inject.Inject


class PhotoListAdapter(
    var list: List<Photo>,
    val photoClickListener: (Photo) -> Unit = {}
) : BaseAdapter<Photo>(list) {

    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PhotoViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_album, parent, false)
        )
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as PhotoListAdapter.PhotoViewHolder).binding
        list[position].let { data->
            binding?.tvAlbumtitle?.text = "Id: ${data.id}"
            binding?.tvAlbumDetails?.text = data.title ?: ""

            val url = GlideUrl(
                data.imageUrl, LazyHeaders.Builder()
                    .addHeader("User-Agent", WebSettings.getDefaultUserAgent(binding!!.ivAlbum.context))
                    .build()
            )

            binding?.ivAlbum?.let {
                Glide.with(it.context)
                    .load(url)
                    .centerCrop()
                    .placeholder(R.drawable.post_item_bg)
                    .into(binding.ivAlbum)
            }
        }
    }

    inner class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ItemAlbumBinding? = DataBindingUtil.bind(view)

        init {
            itemView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    photoClickListener(list[adapterPosition])
                }
            })
        }
    }
}