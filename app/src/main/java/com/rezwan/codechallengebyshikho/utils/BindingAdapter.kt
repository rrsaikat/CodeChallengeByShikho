package com.rezwan.codechallengebyshikho.utils

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter


@BindingAdapter("android:visibility")
fun setVisibility(view: View, visible: Boolean) {
    view.visibility = if (visible) View.INVISIBLE else View.VISIBLE
}
