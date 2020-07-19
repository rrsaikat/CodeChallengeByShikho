package com.rezwan.codechallengebyshikho.ext

import android.content.Context
import android.widget.Toast


fun Context.showShortToast (text: CharSequence) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Context.showLongToast(text: CharSequence, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, text, duration).show()
}