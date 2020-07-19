package com.rezwan.codechallengebyshikho.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.toDeferred
import com.rezwan.codechallengebyshikho.LoadAllPostsQuery
import javax.inject.Inject

class UserRepository @Inject constructor(val apolloClient: ApolloClient) : Repository {
    // its used for pass fetched data to fetchedAllPost
    val mFetchedAllPost = MutableLiveData<LoadAllPostsQuery.Data>()


    override val fetchedPostData: LiveData<LoadAllPostsQuery.Data>
        get() = mFetchedAllPost

    override suspend fun fetchCurrentAllPost() {
        try {
            val fetchedData = apolloClient.query(LoadAllPostsQuery()).toDeferred().await()
            mFetchedAllPost.postValue(fetchedData.data)
            Log.e("connectivity", "Yes internet connection")
        } catch (e: Exception) {
            Log.e("connectivity", "No internet connection" + e.toString())
        }
    }
}