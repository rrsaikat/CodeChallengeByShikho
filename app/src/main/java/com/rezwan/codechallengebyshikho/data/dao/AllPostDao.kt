package com.rezwan.codechallengebyshikho.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rezwan.codechallengebyshikho.data.db.entity.ALL_POST_ID
import com.rezwan.codechallengebyshikho.data.db.entity.AllPostEntity

@Dao
interface AllPostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(allPokemonEntity: AllPostEntity)

    @Query("select * from post_list_table where id = $ALL_POST_ID")
    fun getAll() : LiveData<AllPostEntity>
}