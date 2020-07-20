package com.rezwan.codechallengebyshikho.binding

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rezwan.codechallengebyshikho.GetAlbumQuery
import com.rtchubs.filmadmin.adapters.PhotoListAdapter


@BindingAdapter("android:visibility")
fun setVisibility(view: View, visible: Boolean) {
    view.visibility = if (visible) View.INVISIBLE else View.VISIBLE
}

@BindingAdapter("photoList")
fun bindPhotoRecyclerView(recyclerView: RecyclerView, data: List<GetAlbumQuery.Data1>?) {
    data?.let {
        val adapter = recyclerView.adapter as PhotoListAdapter
        adapter.updateData(data)
    }
}
