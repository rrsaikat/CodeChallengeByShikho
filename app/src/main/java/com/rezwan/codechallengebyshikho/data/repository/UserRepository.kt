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

package com.rezwan.codechallengebyshikho.data.repository

import com.rezwan.codechallengebyshikho.App
import com.rezwan.codechallengebyshikho.data.data_source.AppDatabase
import com.rezwan.codechallengebyshikho.data.data_source.BaseRemoteDataSource
import com.rezwan.codechallengebyshikho.data.data_source.resultLiveData
import com.rezwan.codechallengebyshikho.model.Photo
import com.rezwan.codechallengebyshikho.model.Post
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(val app: App, val postRemoteDataSource: BaseRemoteDataSource) {
    val fectchedPosts = resultLiveData(
        databaseQuery = { AppDatabase.getInstance(app).postDao().getAllPost() },
        networkCall = { postRemoteDataSource.fetchPostData() },
        saveCallResult = {
            val plist:ArrayList<Post> = ArrayList()

            it?.posts?.data?.forEach {
                plist.add(Post(it?.id ?: "" , it?.title ?: ""))
            }
            AppDatabase.getInstance(app).postDao().insertAll(plist)
        }
    )


    val fectchedPhotos = resultLiveData(
        databaseQuery = { AppDatabase.getInstance(app).photoDao().getAllPhotos() },
        networkCall = { postRemoteDataSource.fetchPhotoData() },
        saveCallResult = {
            val plist:ArrayList<Photo> = ArrayList()

            it?.photo?.album?.photos?.data?.forEach {
                plist.add(Photo(it?.id ?: "" , it?.title ?: "", it?.thumbnailUrl ?: ""))
            }
            AppDatabase.getInstance(app).photoDao().insertAll(plist)
        }
    )
}