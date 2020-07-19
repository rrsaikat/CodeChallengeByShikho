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
import com.rezwan.etracker.mizanur.adapters.BaseAdapter
import javax.inject.Inject


class PhotoListAdapter(
    var list: List<GetAlbumQuery.Data1>,
    val photoClickListener: (GetAlbumQuery.Data1) -> Unit = {}
) : BaseAdapter<GetAlbumQuery.Data1>(list) {
    @Inject
    lateinit var app: App

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

//            val url = GlideUrl(
//                it.thumbnailUrl, LazyHeaders.Builder()
//                    .addHeader("User-Agent", WebSettings.getDefaultUserAgent(binding!!.ivAlbum.context))
//                    .build()
//            )

            binding?.ivAlbum?.let {
                Glide.with(it.context)
                    .load(data.thumbnailUrl)
                    .centerCrop()
                    .placeholder(R.drawable.ic_shikho)
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