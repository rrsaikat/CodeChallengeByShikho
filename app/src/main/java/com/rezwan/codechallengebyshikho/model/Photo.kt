package com.rezwan.codechallengebyshikho.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "photos")
data class Photo(
    @PrimaryKey
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("imageUrl")
    val imageUrl: String
) {

    override fun toString() = title
}