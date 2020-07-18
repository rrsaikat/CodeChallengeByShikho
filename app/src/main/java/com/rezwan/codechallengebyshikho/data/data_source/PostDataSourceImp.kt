package com.rezwan.codechallengebyshikho.data.data_source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.toDeferred
import com.rezwan.codechallengebyshikho.LoadAllPostsQuery
import com.rezwan.codechallengebyshikho.data.data_source.PostDataSource
import javax.inject.Inject


class PostDataSourceImp @Inject constructor(private val apolloClient: ApolloClient) :
    PostDataSource {

    // its used for pass fetched data to fetchedAllPost
    private val mFetchedAllPost = MutableLiveData<LoadAllPostsQuery.Data>()

    override suspend fun fetchCurrentAllPost() {
        try {
            val fetchedData = apolloClient.query(LoadAllPostsQuery()).toDeferred().await()
            mFetchedAllPost.postValue(fetchedData.data)
        } catch (e: Exception) {
            Log.e("connectivity", "No internet connection" + e.toString())
        }
    }

    override val fetchedAllPost: LiveData<LoadAllPostsQuery.Data>
        get() = mFetchedAllPost
}