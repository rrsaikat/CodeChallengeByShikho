package com.rezwan.codechallengebyshikho.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "post_table")
data class Post(
    @PrimaryKey(autoGenerate = false)
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("title")
    val title: String

//    @field:SerializedName("postAction")
//    val postAction: PostAction
) {

    override fun toString() = title
}

//enum class PostAction { DELETE, EDIT }
