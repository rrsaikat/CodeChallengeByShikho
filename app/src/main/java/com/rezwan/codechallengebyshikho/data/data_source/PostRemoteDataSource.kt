package com.rezwan.codechallengebyshikho.data.data_source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.toDeferred
import com.rezwan.codechallengebyshikho.LoadAllPostsQuery
import com.rezwan.codechallengebyshikho.data.data_source.PostDataSource
import com.rezwan.codechallengebyshikho.ext.showShortToast
import javax.inject.Inject

/**
 * Works with API to get data.
 */
class PostRemoteDataSource @Inject constructor(private val apolloClient: ApolloClient) : PostDataSource() {
    suspend fun fetchPostData() = getResult { apolloClient.query(LoadAllPostsQuery()).toDeferred().await() }
}