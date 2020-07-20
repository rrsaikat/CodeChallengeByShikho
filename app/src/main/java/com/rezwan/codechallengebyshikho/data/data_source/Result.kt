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

package com.rezwan.codechallengebyshikho.data.data_source

/**
 * A generic class that holds a value with its loading status.
 *
 * Result is usually created by the Repository classes where they return
 * `LiveData<Result<T>>` to pass back the latest data to the UI with its fetch status.
 */

data class Result<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): Result<T> {
            return Result(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String, data: T? = null): Result<T> {
            return Result(Status.ERROR, data, message)
        }

        fun <T> loading(data: T? = null): Result<T> {
            return Result(Status.LOADING, data, null)
        }
    }
}