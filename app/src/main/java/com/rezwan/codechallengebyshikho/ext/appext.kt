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

package com.rezwan.codechallengebyshikho.ext

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun AppCompatActivity.hideKeyboard() {
    val view = this.currentFocus
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
}

fun Fragment.hideKeyboard() {
    val activity = this.activity
    if (activity is AppCompatActivity) {
        activity.hideKeyboard()
    }
}

fun Context.hideKeyboard() {
    val activity = this as AppCompatActivity
    activity.hideKeyboard()

}

fun AppCompatActivity.openWebPage(url: String?) {
    try {
        val webpage: Uri = Uri.parse(url)
        val myIntent = Intent(Intent.ACTION_VIEW, webpage)
        this.startActivity(myIntent)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(
            this,
            "No application can handle this request. Please install a web browser or check your URL.",
            Toast.LENGTH_LONG
        ).show()
        e.printStackTrace()
    }
}