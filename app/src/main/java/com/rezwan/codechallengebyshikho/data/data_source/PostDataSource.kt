package com.rezwan.codechallengebyshikho.data.data_source

import androidx.lifecycle.LiveData
import com.rezwan.codechallengebyshikho.LoadAllPostsQuery



interface PostDataSource {
    val fetchedAllPost: LiveData<LoadAllPostsQuery.Data>

    suspend fun fetchCurrentAllPost()

}