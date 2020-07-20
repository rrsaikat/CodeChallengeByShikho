/*
 * Copyright 2020 RRsaikat. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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