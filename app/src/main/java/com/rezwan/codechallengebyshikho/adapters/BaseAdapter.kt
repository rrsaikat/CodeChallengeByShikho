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

package com.rezwan.etracker.mizanur.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<out T>(val mlist: List<T>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return onCreateViewHolderBase(parent, viewType)
    }

    abstract fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    override fun getItemCount(): Int {
        return mlist.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBindViewHolderBase(holder, position)
    }

    abstract fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int)

    fun getDataList():List<T>{
        return mlist
    }
}