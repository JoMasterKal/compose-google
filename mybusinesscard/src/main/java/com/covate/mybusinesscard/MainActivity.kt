package com.covate.mybusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.covate.mybusinesscard.ui.theme.ComposeGoogleTheme

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
                    BusnessCard()
                }
            }
        }
    }
}

@Composable
fun BusnessCard() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
        ) {
            Image(
                painter = painterResource(R.drawable.avatar_jokal), 
                contentDescription = null
            )
            Text(
                text = "Jonathan KALONGA",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
            )
            Text(text = "Android Developer",
                color = Color(0xFF50DB9C),
                fontSize = 24.sp,
                textAlign = TextAlign.Justify
            )
            
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(color = Color(0xFF4E737D)))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)) {
            
            DetailsRow(image = R.drawable.ic_phone,"phone", content = "+243 82 62 62 757")
            DetailsRow(image = R.drawable.ic_share,"linkedin",
                content = "https://www.linkedin.com/in/jonathan-kalonga-45661b189/")
            DetailsRow(image = R.drawable.ic_email,"Email", content = "mwambajokal@gail.com")

        }
    }
}

@Composable
fun DetailsRow(image : Int,imagDescript: String, content: String) {
    Row(
        modifier = Modifier
            .padding(top = 8.dp, start = 16.dp, bottom = 8.dp)
            .fillMaxWidth()
    ) {
        Image(painter = painterResource(id = image),
            contentDescription = imagDescript,
            modifier = Modifier.size(28.dp)
        )
        Text(text = content,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(2.dp)
        .background(color = Color(0xFF4E737D)))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeGoogleTheme {
        BusnessCard()

    }
}