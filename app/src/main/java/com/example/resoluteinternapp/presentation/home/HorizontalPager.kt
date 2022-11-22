package com.example.resoluteinternapp.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.*
import kotlinx.coroutines.CoroutineScope


@Preview(showBackground = true)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPager() {

    Row() {

        val items = PagerItems()
        val pagerState = rememberPagerState()
        val coroutineScope = rememberCoroutineScope()

        HorizontalTabs(
            items = items,
            pagerState = pagerState,
            scope = coroutineScope,
            onClick = {}
        )

        HorizontalPager(
            count = items.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { currentPage ->
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = items[currentPage],
                    style = MaterialTheme.typography.h2
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = items[currentPage],
                    style = MaterialTheme.typography.h4
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = items[currentPage],
                    style = MaterialTheme.typography.body1
                )
            }
        }


        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .padding(16.dp),
        )


    }


}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalTabs(
    items: List<String>,
    pagerState: PagerState,
    scope: CoroutineScope,
    onClick: () -> Unit
) {

    items.forEach { item ->
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            modifier = Modifier.clickable {
                onClick()
            },
            text = item,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
    }


}


private fun PagerItems() = listOf<String>(
    "Recommendation",
    "Black Tea",
    "Purple Tea",
    "Cold Tea",
    "Green Tea",
    "Brown Tea",
    "White Tea"
)