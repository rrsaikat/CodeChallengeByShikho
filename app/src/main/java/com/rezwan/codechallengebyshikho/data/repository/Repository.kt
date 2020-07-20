package com.rezwan.codechallengebyshikho.data.repository

import androidx.lifecycle.LiveData
import com.apollographql.apollo.api.Response
import com.rezwan.codechallengebyshikho.LoadAllPostsQuery
import io.reactivex.Flowable
import kotlinx.coroutines.Deferred

interface Repository {

    /*Get a Post,
    Get a User, Get User's Posts, Get All Posts, Create a Post,
    Update a Post, Delete a Post*/

    val fetchedPostData: LiveData<LoadAllPostsQuery.Data>

    suspend fun fetchCurrentAllPost()

//    fun getTotalUserPosts(): Flowable<Int>
//
//    fun createPost()
//
//    fun updatePost()
//
//    fun deletePost()
//
//    fun getAlbumList(): LiveData<List<Currency>>
//
//    fun getPost(currencies: String): LiveData<AvailableExchange>
//
//    fun getUser(currencies: String): LiveData<AvailableExchange>
}