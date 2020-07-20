package com.rezwan.codechallengebyshikho.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rezwan.codechallengebyshikho.model.Post

@Dao
interface PostDao {
    @Query("select * from posts ORDER BY id DESC")
    fun getAllPost() : LiveData<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<Post>)
}