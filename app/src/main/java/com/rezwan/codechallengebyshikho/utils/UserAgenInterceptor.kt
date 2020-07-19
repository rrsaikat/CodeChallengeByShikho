package com.rezwan.codechallengebyshikho.utils

import android.content.Context
import android.webkit.WebSettings
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class UserAgentInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val requestWithUserAgent: Request = originalRequest.newBuilder()
            .header("User-Agent", WebSettings.getDefaultUserAgent(context))
            .build()

        return chain.proceed(requestWithUserAgent)
    }
}