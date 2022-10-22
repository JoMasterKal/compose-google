package com.covate.praiseandworship.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.covate.praiseandworship.R

data class Worship(
    @StringRes val reference: Int,
    @StringRes val title : Int,
    @StringRes val description : Int,
    @DrawableRes val ilustration : Int
)

object WorshipRepository{
    val praises = listOf<Worship>(
        Worship(
            R.string.ref1,
            R.string.title1,
            R.string.desc1,
            R.drawable.nature
        ),
        Worship(
            R.string.ref2,
            R.string.title2,
            R.string.desc2,
            R.drawable.joy
        ),
        Worship(
            R.string.ref3,
            R.string.title3,
            R.string.desc3,
            R.drawable.alone
        ),
        Worship(
            R.string.ref4,
            R.string.title4,
            R.string.desc4,
            R.drawable.fin_neige
        ),
        Worship(
            R.string.ref5,
            R.string.title5,
            R.string.desc5,
            R.drawable.herbe
        ),
        Worship(
            R.string.ref6,
            R.string.title6,
            R.string.desc6,
            R.drawable.walk
        ),
        Worship(
            R.string.ref7,
            R.string.title7,
            R.string.desc7,
            R.drawable.security
        ),
        Worship(
            R.string.ref8,
            R.string.title8,
            R.string.desc8,
            R.drawable.regard
        ),
        Worship(
            R.string.ref9,
            R.string.title9,
            R.string.desc9,
            R.drawable.night_city
        ),
        Worship(
            R.string.ref10,
            R.string.title10,
            R.string.desc10,
            R.drawable.creature
        ),
        Worship(
            R.string.ref11,
            R.string.title11,
            R.string.desc11,
            R.drawable.in_sing
        ),
        Worship(
            R.string.ref12,
            R.string.title12,
            R.string.desc12,
            R.drawable.city
        ),
        Worship(
            R.string.ref13,
            R.string.title13,
            R.string.desc13,
            R.drawable.brige
        ),
        Worship(
            R.string.ref14,
            R.string.title14,
            R.string.desc14,
            R.drawable.talk
        ),
        Worship(
            R.string.ref15,
            R.string.title15,
            R.string.desc15,
            R.drawable.hear_me
        ),
        Worship(
            R.string.ref16,
            R.string.title16,
            R.string.desc16,
            R.drawable.great_city
        ),
        Worship(
            R.string.ref17,
            R.string.title17,
            R.string.desc17,
            R.drawable.think
        ),
        Worship(
            R.string.ref18,
            R.string.title18,
            R.string.desc18,
            R.drawable.meditation
        ),Worship(
            R.string.ref19,
            R.string.title19,
            R.string.desc19,
            R.drawable.sing
        ),
        Worship(
            R.string.ref20,
            R.string.title20,
            R.string.desc20,
            R.drawable.desert
        ),
        Worship(
            R.string.ref21,
            R.string.title21,
            R.string.desc21,
            R.drawable.frend
        )

    )
}