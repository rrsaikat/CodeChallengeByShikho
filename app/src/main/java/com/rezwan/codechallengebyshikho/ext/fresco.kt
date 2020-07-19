package com.rezwan.codechallengebyshikho.ext

import android.net.Uri
import com.facebook.drawee.generic.RoundingParams
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.request.ImageRequestBuilder
import com.facebook.drawee.view.SimpleDraweeView
import android.graphics.drawable.Animatable
import android.view.ViewGroup
import com.facebook.drawee.controller.BaseControllerListener
import com.facebook.imagepipeline.image.ImageInfo


fun SimpleDraweeView.loadCircleImage(url: String) {
    val request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
        .setProgressiveRenderingEnabled(false)
        .build()
    val controller = Fresco.newDraweeControllerBuilder()
        .setImageRequest(request)
        .setAutoPlayAnimations(false)
        .build()

    val roundingParams = RoundingParams()
    roundingParams.setCornersRadii(18f, 18f, 18f, 18f)
    this.hierarchy.roundingParams = roundingParams

    this.controller = controller
}

fun loadImageDrawable(resID: Int, targetView: SimpleDraweeView) {
    val imageRequest = ImageRequestBuilder.newBuilderWithResourceId(resID).build()

    val controller = Fresco.newDraweeControllerBuilder()
        .setImageRequest(imageRequest)
        .setAutoPlayAnimations(false)
        .build()

    val roundingParams = RoundingParams()
    roundingParams.setCornersRadii(18f, 18f, 18f, 18f)
    targetView.hierarchy.roundingParams = roundingParams

    targetView.controller = controller
}

fun SimpleDraweeView.loadImageUrl(url: String) {
    val request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
        .setProgressiveRenderingEnabled(false)
        .build()


    val listener = object : BaseControllerListener<ImageInfo>() {
        override fun onFinalImageSet(id: String?, imageInfo: ImageInfo?, animatable: Animatable?) {
            super.onFinalImageSet(id, imageInfo, animatable)
            this@loadImageUrl.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            this@loadImageUrl.aspectRatio = (imageInfo?.width?.toFloat() ?: 0.toFloat()) / (imageInfo?.height?.toFloat() ?: 0.toFloat())
        }
    }

    val controller = Fresco.newDraweeControllerBuilder()
        .setImageRequest(request)
        .setControllerListener(listener)
        .setAutoPlayAnimations(false)
        .build()

    val roundingParams = RoundingParams()
    this.hierarchy.roundingParams = roundingParams
    this.controller = controller
}