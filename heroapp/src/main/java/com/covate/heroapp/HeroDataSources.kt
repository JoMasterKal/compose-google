package com.covate.heroapp

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.covate.heroapp.model.Hero
import com.covate.heroapp.ui.theme.HeroTheme
import com.covate.heroapp.ui.theme.Shapes

@Composable
fun HeroCard(hero: Hero,modifier: Modifier = Modifier) {

    Card(elevation = 4.dp,modifier = modifier
        .padding(
            start = 16.dp,
            end = 16.dp,
            top = 8.dp,
        )
    ) {
        Row(modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
        ) {

            HeroInformation(heroName = hero.nameRes,
                heroDescription = hero.descriptionRes,modifier = modifier.weight(2f))
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                modifier = modifier
                    .size(74.dp)
                    .padding(start = 16.dp)
                    .clip(shape = Shapes.small).weight(1f)
                ,
                contentScale = ContentScale.Crop,
                painter = painterResource(id = hero.imageRes),
                contentDescription = stringResource(id = hero.descriptionRes),
            )

        }
    }


}


@Composable
fun HeroInformation(
    @StringRes heroName: Int,
    @StringRes heroDescription : Int,
    modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        Text(
            text = stringResource(id = heroName),
            style = MaterialTheme.typography.h3,
        )
        Text(
            text = stringResource(id = heroDescription),
            style = MaterialTheme.typography.body1,
        )
    }

}

@Preview
@Composable
fun CardPreview(){
    val hero = Hero(
        nameRes = R.string.hero4,
        descriptionRes = R.string.description4,
        imageRes = R.drawable.android_superhero4
    )
    HeroTheme{
        HeroCard(hero = hero)
    }
}