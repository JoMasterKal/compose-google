package com.covate.praiseandworship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.covate.praiseandworship.model.WorshipRepository
import com.covate.praiseandworship.ui.theme.PraiseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PraiseTheme {
                ListWorship()
            }
        }
    }
}

@Composable
fun ListWorship(modifier: Modifier = Modifier) {

    Scaffold(
        topBar = { TopAppBar()}
        ) {
        LazyColumn(
            modifier
                .padding(it)
        ) {
            items(WorshipRepository.praises){
                PraiseCard(praise = it)
            }
        }
    }

}



@Composable
fun TopAppBar() {
    Row(Modifier.padding(start = 16.dp)
        .height(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Adoration",
            style = MaterialTheme.typography.h1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PraiseTheme {
        ListWorship()
    }
}