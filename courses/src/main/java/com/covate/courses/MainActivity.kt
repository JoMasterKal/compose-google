package com.covate.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.covate.courses.data.DataSource
import com.covate.courses.model.Branch
import com.covate.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesApp()
        }
    }
}

@Composable
fun CoursesApp() {
    CoursesTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            //color = MaterialTheme.colors.background
        ) {
            TopicList(data = DataSource.topics)
        }
    }
}

@Composable
fun CourseCard(modifier: Modifier = Modifier, branch: Branch) {
    Card(elevation = 4.dp) {
        Row() {

            Box() {
                Image(
                    painter = painterResource(branch.image),
                    contentDescription = stringResource(id = branch.title ?: "".toInt()),
                    modifier = modifier
                        .size(width = 68.dp, height = 68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop

                )
            }

            Column(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        bottom = 8.dp,
                        end = 16.dp,
                        top = 16.dp
                    )

            ) {
                Text(
                    text = stringResource(id = branch.title ?: "".toInt()),
                    modifier = modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.body2

                )
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        Modifier.size(16.dp)
                    )
                    Spacer(modifier = modifier.width(8.dp))
                    Text(
                        text = branch.qty.toString(),
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }

    }
}

//@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopicList(data: List<Branch>) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        items(data) { item ->
            CourseCard(branch = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TopicList(data = DataSource.topics)
}