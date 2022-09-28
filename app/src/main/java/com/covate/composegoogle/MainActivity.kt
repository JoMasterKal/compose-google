package com.covate.composegoogle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.covate.composegoogle.ui.theme.ComposeGoogleTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeGoogleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AboutCompose()
                }
            }
        }
    }
}

@Composable
fun AboutCompose() {
    val img = painterResource(id = R.drawable.bg_compose_background)
    Column {
        Image(painter = img,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = stringResource(R.string.title_text),
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = stringResource(R.string.paragraph1_text),
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth()

        )

        Text(
            text = stringResource(R.string.paragraph2_text),
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeGoogleTheme {
        AboutCompose()
    }
}