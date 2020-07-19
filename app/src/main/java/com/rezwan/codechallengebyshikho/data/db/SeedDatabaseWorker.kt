package com.rezwan.codechallengebyshikho.data.db

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
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
                applicationContext.assets.open(DATA_FILENAME).bufferedReader().use {
                    val type = object : TypeToken<List<Post>>() {}.type
                    val list: List<Post> = Gson().fromJson(it.readText(), type)

                    AppDatabase.getInstance(applicationContext).postDao().insertAll(list)

                    Result.success()
                }
            } catch (e: Exception) {
                //Timber.e(e, "Error seeding database")
                Result.failure()
            }
        }
    }
}