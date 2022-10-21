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
import androidx.compose.runtime.*
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

    var imageId by remember{ mutableStateOf(1)}
    var textseting by remember { mutableStateOf("")}

    val imgToChange =  when(imageId) {
        1 -> R.drawable.mammy
        2 -> R.drawable.jokalmammy
        3 -> R.drawable.kalongas
        4 -> R.drawable.eat
        else -> R.drawable.mammy
    }

    val textToChange =  when(imageId) {
        1 -> "Le repos de mon coeur!"
        2 -> "Avec ma belle mere!"
        3 -> "les kalonga, la joie d'etre en famille!"
        4 -> "En fin de journee, bon appetit!"
        else -> "le repos de mon coeur!"
    }

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top=32.dp, end = 16.dp, start = 16.dp, bottom = 16.dp)
            .fillMaxSize()
    ) { 

        Surface(
            modifier = Modifier
                .weight(2f)
                .border(4.dp, color = Color.Gray,shape = RectangleShape),
            elevation = 4.dp
        ) {

            Image(
                painter = painterResource(imgToChange),
                contentDescription = "this is my best picture",
                modifier = Modifier.padding(24.dp)
            )
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        


        Spacer(modifier = Modifier.height(16.dp))

        Surface(elevation = 4.dp, modifier = Modifier.weight(1f)) {

            Column(verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(16.dp).wrapContentSize(Alignment.TopCenter)) {
                Text(text = textToChange,
                    fontSize = 24.sp
                )
                Text(text = "Carolina",
                    fontWeight = FontWeight.Bold
                )

            }

        }

        Row(verticalAlignment = Alignment.Bottom,
            modifier = Modifier.padding(16.dp).weight(1f)) {

            Button(
                onClick = { if(imageId > 1) imageId-- },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp)
            ) {
                Text(text = "Preview")

            }

            Button(
                onClick = { if(imageId < 4) imageId++ },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Next")
            }
        }

    }

}

@Composable
fun ButtonActon(onClicked : ()->Unit) {


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeGoogleTheme {
        SpaceApp()
    }
}