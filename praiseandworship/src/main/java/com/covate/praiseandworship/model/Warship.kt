package com.covate.praiseandworship.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Worship(
    @StringRes val reference: Int,
    @StringRes val title : Int,
    @StringRes val description : Int,
    @DrawableRes val ilustration : Int
)

object WorshipRepository{
    val praises = listOf<Worship>(
       // Worship()
    )
}