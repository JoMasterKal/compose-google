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
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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

            StatusButton()
        }
    }

}

@Composable
fun Ilustration(@DrawableRes image: Int, modifier: Modifier = Modifier) {
    Image(modifier = modifier
        .padding(bottom = 8.dp)
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


        Card(elevation = 4.dp,
            backgroundColor = MaterialTheme.colors.secondary
        ) {
            Text(
                text = stringResource(id = ref),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.surface,
                modifier = Modifier
                    .padding(8.dp)
                    .background(color = Color.Transparent)
            )
        }

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

@Composable
fun StatusButton() {
    var liked by remember { mutableStateOf(false) }
    var likeCount by remember{ mutableStateOf(0)}
    Row(modifier = Modifier.padding(top = 8.dp)) {
        LikeButton(modifier = Modifier.weight(1f), liked = liked,likeCount){
            if(liked){
                liked = false
                likeCount--
            }else {
                liked = true
                likeCount++
            }
        }
        ShareButton (modifier = Modifier.weight(1f)){
            liked = !liked
        }
    }
}

@Composable
fun LikeButton(
    modifier: Modifier = Modifier,
    liked: Boolean,
    likedCount: Int,
    onClick: () -> Unit
){
    IconButton(onClick =  onClick) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(

                imageVector = if (liked) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                tint = if(liked) Color.Red  else MaterialTheme.colors.secondary,
                contentDescription = stringResource(R.string.expand_button_content_description)
            )

            Text(text = likedCount.toString(),
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Composable
fun ShareButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    IconButton(onClick = onClick) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector =  Icons.Rounded.Share,
                tint = MaterialTheme.colors.secondary,
                contentDescription = stringResource(R.string.expand_button_content_description)
            )

            Text(text = stringResource(R.string.share_text),
                style = MaterialTheme.typography.body2
            )
        }
    }
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