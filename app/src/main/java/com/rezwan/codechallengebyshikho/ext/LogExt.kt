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

import android.util.Log
import com.rezwan.codechallengebyshikho.BuildConfig

fun Any.debug(message: Any?) = apply {
    if (BuildConfig.DEBUG) {
        Log.d(tag, message.toString())
    }
}

fun Any.error(message: Any?) = apply {
    if (BuildConfig.DEBUG) {
        Log.e(tag, message.toString())
    }
}

fun Any.wtf(message: Any?) = apply {
    if (BuildConfig.DEBUG) {
        Log.wtf(tag, message.toString())
    }
}

fun Any.warning(message: Any?) = apply {
    if (BuildConfig.DEBUG) {
        Log.w(tag, message.toString())
    }
}

fun Any.info(message: Any?) = apply {
    if (BuildConfig.DEBUG) {
        Log.i(tag, message.toString())
    }
}

fun Any.verbose(message: Any?) = apply {
    if (BuildConfig.DEBUG) {
        Log.v(tag, message.toString())
    }
}


fun Any.debug(tag: String, message: Any?) = apply {
    if (BuildConfig.DEBUG) {
        Log.d(tag, message.toString())
    }
}

fun Any.error(tag: String, message: Any?) = apply {
    if (BuildConfig.DEBUG) {
        Log.e(tag, message.toString())
    }
}


fun Any.wtf(tag: String, message: Any?) = apply {
    if (BuildConfig.DEBUG) {
        Log.wtf(tag, message.toString())
    }
}

fun Any.warning(tag: String, message: Any?) = apply {
    if (BuildConfig.DEBUG) {
        Log.w(tag, message.toString())
    }
}

fun Any.info(tag: String, message: Any?) = apply {
    if (BuildConfig.DEBUG) {
        Log.i(tag, message.toString())
    }
}

fun Any.verbose(tag: String, message: Any?) = apply {
    if (BuildConfig.DEBUG) {
        Log.v(tag, message.toString())
    }
}


fun Any.debug(context: Any, message: Any?) = apply {
    if (BuildConfig.DEBUG) {
        if (message != null) {
            Log.d(context.tag, message.toString())
        }
    }
}

fun Any.error(context: Any, message: Any?) = apply {
    if (BuildConfig.DEBUG) {
        if (message != null) {
            Log.e(context.tag, message.toString())
        }
    }

}

fun Any.wtf(context: Any, message: Any?) = apply {
    if (BuildConfig.DEBUG) {
        Log.wtf(context.tag, message.toString())
    }
}

fun Any.warning(context: Any, message: Any?) = apply {
    if (BuildConfig.DEBUG) {
        Log.w(context.tag, message.toString())
    }
}

fun Any.info(context: Any, message: Any?) = apply {
    if (BuildConfig.DEBUG) {
        if (message != null) {
            Log.i(context.tag, message.toString())
        }
    }
}

fun Any.verbose(context: Any, message: Any?) = apply {
    if (BuildConfig.DEBUG) {
        Log.v(context.tag, message.toString())
    }
}


private val Any.tag get() = javaClass.simpleName

inline fun Any.debug(message: () -> Any?) = debug(message())

inline fun Any.error(message: () -> Any?) = error(message())

inline fun Any.wtf(message: () -> Any?) = wtf(message())

inline fun Any.warning(message: () -> Any?) = warning(message())

inline fun Any.info(message: () -> Any?) = info(message())

inline fun Any.verbose(message: () -> Any?) = verbose(message())

inline fun Any.debug(tag: String, message: () -> Any?) = debug(tag, message())

inline fun Any.error(tag: String, message: () -> Any?) = error(tag, message())

inline fun Any.wtf(tag: String, message: () -> Any?) = wtf(tag, message())

inline fun Any.warning(tag: String, message: () -> Any?) = warning(tag, message())

inline fun Any.info(tag: String, message: () -> Any?) = info(tag, message())

inline fun Any.verbose(tag: String, message: () -> Any?) = verbose(tag, message())


fun Any.debug(context: Any, message: () -> Any?) = debug(context.tag, message())

fun Any.error(context: Any, message: () -> Any?) = error(context.tag, message())

fun Any.wtf(context: Any, message: () -> Any?) = wtf(context.tag, message())

fun Any.warning(context: Any, message: () -> Any?) = warning(context.tag, message())

fun Any.info(context: Any, message: () -> Any?) = info(context.tag, message())

fun Any.verbose(context: Any, message: () -> Any?) = verbose(context.tag, message())


inline fun <reified T> T.log(message: String) = Log.d(T::class.java.simpleName, message)

inline fun <reified T> T.log(exc: Throwable) {
    exc.printStackTrace()
    Log.e(T::class.java.simpleName, exc.message ?: "no-message")
}