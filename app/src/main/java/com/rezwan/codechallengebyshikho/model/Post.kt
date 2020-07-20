package com.rezwan.codechallengebyshikho.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "posts")
data class Post(
    @PrimaryKey
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("title")
    val title: String

) {

    override fun toString() = title
}

//enum class PostAction { DELETE, EDIT }
