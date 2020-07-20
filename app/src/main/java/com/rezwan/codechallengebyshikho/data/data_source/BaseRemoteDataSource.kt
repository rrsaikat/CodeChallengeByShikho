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

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.toDeferred
import com.rezwan.codechallengebyshikho.GetAlbumQuery
import com.rezwan.codechallengebyshikho.LoadAllPostsQuery
import javax.inject.Inject

/**
 * Works with API to get data.
 */
class BaseRemoteDataSource @Inject constructor(private val apolloClient: ApolloClient) : BaseDataSource() {
    suspend fun fetchPostData() = getResult { apolloClient.query(LoadAllPostsQuery()).toDeferred().await() }

    suspend fun fetchPhotoData() = getResult { apolloClient.query(GetAlbumQuery(id = "1")).toDeferred().await() }
}