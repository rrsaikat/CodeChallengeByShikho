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

package com.rezwan.codechallengebyshikho.ext

import android.text.Editable
import android.widget.EditText
import androidx.core.widget.addTextChangedListener

fun EditText.validatelistener(field1:EditText){
    this.addTextChangedListener { text ->
        if (field1.text.isEmpty()) {
            field1.setError("This field is required")
        }else if(this.text.isEmpty()){
            this.setError("This field is required")
        }
    }
}