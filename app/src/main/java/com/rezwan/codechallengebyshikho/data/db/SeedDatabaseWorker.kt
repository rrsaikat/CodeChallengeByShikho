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

package com.rezwan.codechallengebyshikho.data.db

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.rezwan.codechallengebyshikho.const.appconst.DATA_FILENAME
import com.rezwan.codechallengebyshikho.data.data_source.AppDatabase
import com.rezwan.codechallengebyshikho.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext


class SeedDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result = coroutineScope {
        withContext(Dispatchers.IO) {
            try {
                applicationContext.assets.open(DATA_FILENAME).use { inputStream ->
                    JsonReader(inputStream.reader()).use { jsonReader ->
                        val type = object : TypeToken<List<Post>>() {}.type
                        val list: List<Post> = Gson().fromJson(jsonReader, type)

                        AppDatabase.getInstance(applicationContext).postDao().insertAll(list)

                        Result.success()
                    }
                }
            } catch (e: Exception) {
                //Timber.e(e, "Error seeding database")
                Result.failure()
            }
        }
    }
}