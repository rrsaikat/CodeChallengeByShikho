package com.rezwan.codechallengebyshikho.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rezwan.codechallengebyshikho.LoadAllPostsQuery
import com.rezwan.codechallengebyshikho.data.db.entity.ALL_POST_ID
import com.rezwan.codechallengebyshikho.data.db.entity.AllPostEntity
import com.rezwan.codechallengebyshikho.model.Post

@Dao
interface UserPostDao {
    @Query("select * from post_table ORDER BY id DESC")
    fun getAllPost() : LiveData<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<Post>)
}