package com.covate.praiseandworship

import android.service.quicksettings.Tile
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.covate.praiseandworship.model.Worship
import com.covate.praiseandworship.ui.theme.PraiseTheme
import com.covate.praiseandworship.ui.theme.Shapes
import com.covate.praiseandworship.ui.theme.primaryColor

@Composable
fun PraiseCard(praise:Worship, modifier: Modifier = Modifier) {

    var expanded by remember { mutableStateOf(false) }

    Card(elevation = 4.dp) {
        Column(modifier = modifier.padding(16.dp)) {

            Row(modifier = modifier.padding(bottom = 8.dp)) {
                RefAndTitle(title = praise.title, ref = praise.reference)
                Spacer(modifier = modifier.weight(1f))
                ExpandItemButton(expanded = expanded, onClick = { expanded = !expanded})

            }
            Ilustration(image = praise.ilustration)
            
            if (expanded){
                DescriptionText(descript = praise.description)
            }
        }
    }

}

@Composable
fun Ilustration(@DrawableRes image: Int, modifier: Modifier = Modifier) {
    Image(modifier = modifier.padding(bottom = 8.dp)
        .fillMaxWidth()
        .height(160.dp)
        .clip(shape = Shapes.large),
        contentScale = ContentScale.Crop,
        painter = painterResource(id = image),
        contentDescription = null)
}

@Composable
fun RefAndTitle(@StringRes title: Int, @StringRes ref: Int,modifier: Modifier = Modifier) {
    Column {
        Text(text = stringResource(id = title),
            style = MaterialTheme.typography.h3
        )


        Text(
            text = stringResource(id = ref),
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.secondary
        )
    }
}

@Composable
private fun ExpandItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = MaterialTheme.colors.secondary,
            contentDescription = stringResource(R.string.expand_button_content_description)
        )
    }
}

@Composable
fun DescriptionText(@StringRes descript : Int, modifier: Modifier = Modifier) {
    Text(text = stringResource(id = descript),
        style = MaterialTheme.typography.body1,
        textAlign = TextAlign.Justify,
        color = MaterialTheme.colors.secondary
    )
}

@Preview
@Composable
fun cardPreview() {
    val test = Worship(
        R.string.ref15,
        R.string.title15,
        R.string.desc15,
        R.drawable.hear_me
    )
    PraiseTheme() {
        PraiseCard(praise = test)
    }
}