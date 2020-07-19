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