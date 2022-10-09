package com.covate.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.covate.artspace.ui.theme.ComposeGoogleTheme

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
                    SpaceApp()
                }
            }
        }
    }
}

@Composable
fun SpaceApp() {

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) { 
        Surface(modifier = Modifier
            .border(4.dp, color = Color.Gray, shape = RectangleShape),
            elevation = 4.dp
        ) {

            Image(
                painter = painterResource(id = R.drawable.mammy),
                contentDescription = "this is my best picture",
                modifier = Modifier.padding(24.dp)
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Surface(elevation = 4.dp) {
            
            Column(verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(16.dp)) {
                Text(text = "La merveilleuse des femmes",
                    fontSize = 36.sp
                )
                Text(text = "Carolina",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                
            }
            
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)) {

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f).padding(end = 16.dp)
            ) {
                Text(text = "Preview")

            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Next")
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeGoogleTheme {
        SpaceApp()
    }
}