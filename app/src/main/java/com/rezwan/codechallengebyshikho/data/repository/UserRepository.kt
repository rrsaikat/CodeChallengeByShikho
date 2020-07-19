package com.rezwan.codechallengebyshikho.data.repository

import com.rezwan.codechallengebyshikho.data.dao.UserPostDao
import com.rezwan.codechallengebyshikho.data.data_source.PostRemoteDataSource
import com.rezwan.codechallengebyshikho.data.data_source.resultLiveData
import com.rezwan.codechallengebyshikho.model.Post
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val postDao: UserPostDao, val postRemoteDataSource: PostRemoteDataSource) {
    val fectchedPosts = resultLiveData(
        databaseQuery = { postDao.getAllPost() },
        networkCall = { postRemoteDataSource.fetchPostData() },
        saveCallResult = {
            val plist:ArrayList<Post> = ArrayList()

            it?.posts?.data?.forEach {
                plist.add(Post(it?.id ?: "" , it?.title ?: ""))
            }
            postDao.insertAll(plist)
        }
    )
}