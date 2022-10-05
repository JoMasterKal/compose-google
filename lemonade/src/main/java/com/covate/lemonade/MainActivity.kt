package com.covate.lemonade

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.covate.lemonade.ui.theme.ComposeGoogleTheme

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

                    LemonadeApp()                }
            }
        }
    }
}

@Composable
fun LemonadeApp() {

    ButtonCard(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

@Composable
fun ButtonCard(modifier: Modifier) {

    var statut by remember { mutableStateOf(1) }


    var drink = when(statut) {
        1 -> R.drawable.lemon_tree
        2-> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else-> R.drawable.lemon_tree
    }
    var descript = when(statut) {
        1 -> R.string.lemon_tree
        2-> R.string.lemon
        3 -> R.string.glass_of_lemonade
        4 -> R.string.empty_glass
        else-> R.string.lemon_tree
    }



        Column (
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(stringResource(descript), fontSize = 18.sp)

            Spacer(modifier = Modifier.height(16.dp))

            IconButton(onClick = { ++statut
                if(statut == 5) statut = 1},
                modifier = Modifier.border(4.dp, Color(105,205,216))) {
                Image(painter = painterResource(drink),
                    contentDescription = stringResource(descript)
                )
            }

        }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeGoogleTheme {
        LemonadeApp()
    }
}