package com.example.resoluteinternapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.resoluteinternapp.R
import com.example.resoluteinternapp.domain.model.Tea

@Composable
fun TeaCard(tea: Tea, onClick: () -> Unit) {


    Card(
        modifier = Modifier
            .width(160.dp)
            .height(240.dp)
            .padding(start = 4.dp, end = 4.dp)
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(18.dp),
        backgroundColor = Color(0xFAA7CC52)

    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = tea.picture),
                contentDescription = "",
                modifier = Modifier,
                contentScale = ContentScale.Inside
            )

            Text(
                text = tea.title,
                color = Color(0xB90E5806),
                fontWeight = FontWeight.Bold
            )


        }

    }


}


@Composable
fun TeaIcon(tea: Tea) {

    Card(
        modifier = Modifier
            .width(100.dp)
            .height(80.dp)
            .border(width = 6.dp, color = Color(0xFAA7CC52), shape = RoundedCornerShape(22.dp))
            .clickable {

            },
    ) {

        Box(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(tea.picture),
                contentDescription = "",
                contentScale = ContentScale.Inside
            )
        }


    }

}

@Composable
fun TeaDetailCard(tea: Tea, onClick: () -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        TeaIcon(tea = tea)

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = tea.title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xB90E5806)
            )

            Text(
                text = "Good day time",
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = Color(0xB90E5806),
            )
        }

        Text(
            text = "$  ${tea.cost}",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xB90E5806)
        )


    }


}


@Preview
@Composable
fun Preview12() {

    val getAllTea = Tea(
        1,
        12,
        "Green Tea",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        56.99,
        R.drawable.green_tea
    )

    TeaDetailCard(tea = getAllTea) {}
}

@Preview
@Composable
fun Preview1243() {

    val getAllTea = Tea(
        1,
        22,
        "Green Tea",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        12.99,
        R.drawable.green_tea
    )

    TeaCard(tea = getAllTea) {}
}


@Preview(showBackground = true)
@Composable
fun PagerCard() {

    val items = listOf(
        "Recommendation",
        "Black Tea",
        "Green Tea",
        "Purple Tea",
        "Cold Tea",
        "Lemon Tea",
        "Herbal Tea",
        "Yellow Tea"
    )



    LazyRow {
        items(items) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)) {
                Text(
                    text = it,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xB90E5806)
                )


            }
        }

    }


}





















