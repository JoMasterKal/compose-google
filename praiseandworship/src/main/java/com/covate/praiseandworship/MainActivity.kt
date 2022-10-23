package com.covate.praiseandworship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

            }
        }
    }
}

@Composable
fun ListWorship(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier.padding(8.dp)
    ) {
        items(WorshipRepository.praises){
            PraiseCard(praise = it)
        }
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PraiseTheme {
        ListWorship()
    }
}