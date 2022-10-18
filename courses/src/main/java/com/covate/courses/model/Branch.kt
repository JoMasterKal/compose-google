package com.covate.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Branch (
    @DrawableRes
    val image : Int,
    @StringRes
    val title : Int? = null
        )
