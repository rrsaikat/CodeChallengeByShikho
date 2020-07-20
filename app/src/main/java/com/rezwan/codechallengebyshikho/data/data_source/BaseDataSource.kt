package com.rezwan.codechallengebyshikho.data.data_source

import com.apollographql.apollo.api.Response


abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T?> {
        try {
            val response = call()
            if (!response.hasErrors()) {
                return Result.success(response.data)
            }
            return error(" ${response.errors?.get(0)} ${response.errors?.get(1)}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Result<T> {
//        Timber.e(message)
        return Result.error("Network call has failed for a following reason: $message")
    }

}