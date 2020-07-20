package com.rezwan.codechallengebyshikho.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rezwan.codechallengebyshikho.model.Photo
import com.rezwan.codechallengebyshikho.model.Post

@Dao
interface PhotoDao {
    @Query("select * from photos ORDER BY id DESC")
    fun getAllPhotos() : LiveData<List<Photo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<Photo>)
}