package com.rezwan.codechallengebyshikho.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rezwan.codechallengebyshikho.LoadAllPostsQuery
import java.util.*

/**
 *  Created by beyazid on 12.01.2019.
 */
class Converter {
    private val gson = Gson()
    @TypeConverter
    fun stringToList(data: String?): List<LoadAllPostsQuery.Data1> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<LoadAllPostsQuery.Data1>>() {

        }.type

        return gson.fromJson<List<LoadAllPostsQuery.Data1>>(data, listType)
    }

    @TypeConverter
    fun listToString(someObjects: List<LoadAllPostsQuery.Data1>): String {
        return gson.toJson(someObjects)
    }

}