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

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridItemDecoration(gridSpacingPx: Int, gridSize: Int) : RecyclerView.ItemDecoration() {
    private var mSizeGridSpacingPx: Int = gridSpacingPx
    private var mGridSize: Int = gridSize

    private var mNeedLeftSpacing = false

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val frameWidth = ((parent.width - mSizeGridSpacingPx.toFloat() * (mGridSize - 1)) / mGridSize).toInt()
        val padding = parent.width / mGridSize - frameWidth
        val itemPosition = (view.getLayoutParams() as RecyclerView.LayoutParams).viewAdapterPosition
        if (itemPosition < mGridSize) {
            outRect.top = 0
        } else {
            outRect.top = mSizeGridSpacingPx
        }
        if (itemPosition % mGridSize == 0) {
            outRect.left = 0
            outRect.right = padding
            mNeedLeftSpacing = true
        } else if ((itemPosition + 1) % mGridSize == 0) {
            mNeedLeftSpacing = false
            outRect.right = 0
            outRect.left = padding
        } else if (mNeedLeftSpacing) {
            mNeedLeftSpacing = false
            outRect.left = mSizeGridSpacingPx - padding
            if ((itemPosition + 2) % mGridSize == 0) {
                outRect.right = mSizeGridSpacingPx - padding
            } else {
                outRect.right = mSizeGridSpacingPx / 2
            }
        } else if ((itemPosition + 2) % mGridSize == 0) {
            mNeedLeftSpacing = false
            outRect.left = mSizeGridSpacingPx / 2
            outRect.right = mSizeGridSpacingPx - padding
        } else {
            mNeedLeftSpacing = false
            outRect.left = mSizeGridSpacingPx / 2
            outRect.right = mSizeGridSpacingPx / 2
        }
        outRect.bottom = 0
    }
}