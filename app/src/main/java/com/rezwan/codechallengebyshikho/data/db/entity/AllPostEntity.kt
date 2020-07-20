package com.rezwan.codechallengebyshikho.data.db.entity

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.rezwan.codechallengebyshikho.LoadAllPostsQuery
import com.rezwan.codechallengebyshikho.utils.Converter
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

const val ALL_POST_ID = 0

@Entity(tableName = "post_list_table")
data class AllPostEntity(
	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@TypeConverters(Converter::class)
	@field:SerializedName("results")
	public var results: List<LoadAllPostsQuery.Data1> = listOf()
){
	@PrimaryKey(autoGenerate = false)
	var pid: Int = ALL_POST_ID

	val zonedDatedTime : ZonedDateTime
		@RequiresApi(Build.VERSION_CODES.O)
		get() {
			return ZonedDateTime.ofInstant(Instant.EPOCH, ZoneId.systemDefault())
		}

}