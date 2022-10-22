package com.covate.heroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.covate.heroapp.model.HeroesRepository
import com.covate.heroapp.ui.theme.HeroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeroTheme {
                HeroApp()
            }
        }
    }
}

@Composable
fun HeroApp() {

    Scaffold(
        topBar = { HeroAppBar() }
    ) {
        LazyColumn(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(it)
        ) {
            items(HeroesRepository.heroes) {
                HeroCard(hero = it)
            }
        }
    }


}


@Composable
fun HeroAppBar(modifier: Modifier = Modifier) {

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .height(56.dp),
    ) {
        Text(
            text = stringResource(id = R.string.hero_title),
            style = MaterialTheme.typography.h1,

            )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HeroTheme {
        HeroApp()
    }
}