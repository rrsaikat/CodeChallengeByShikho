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