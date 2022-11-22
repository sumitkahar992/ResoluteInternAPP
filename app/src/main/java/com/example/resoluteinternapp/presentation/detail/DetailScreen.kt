package com.example.resoluteinternapp.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import com.example.resoluteinternapp.presentation.navigation.top.TopBarDefault

@Composable
fun DetailScreen() {

    Scaffold(

        topBar = {
            TopBarDefault(
                title = "Cart Details",
                icon = Icons.Filled.ArrowBack,
                onClick = {}
            )
        },

        content = {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CardDetails()
            }


        }
    )


}


@Preview(showBackground = true)
@Composable
fun CardDetails() {

    val task = Tea(
        1,
        1,
        "Lemon Tea",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        56.99,
        R.drawable.coffee_tea
    )
    Surface(
        color = Color(0xB994DA46),
        modifier = Modifier.fillMaxSize()
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 90.dp)
        ) {


            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = task.title,
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xB9379920)
            )
            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = "Good day time",
                fontSize = 26.sp,
                color = Color(0xB9838383)
            )
            Spacer(modifier = Modifier.height(21.dp))

            Text(
                modifier = Modifier.padding(start = 30.dp),
                text = "$ ${task.cost.toString()}",
                fontSize = 50.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xB9124106)
            )

            Surface(
                color = Color.White,
                shape = RoundedCornerShape(42.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {

                Column {

                    Text(
                        modifier = Modifier.padding(start = 20.dp, top = 22.dp),
                        text = "Particulars",
                        fontSize = 34.sp,
                        color = Color(0xB9000000)
                    )
                    Text(
                        modifier = Modifier.padding(start = 20.dp, top = 22.dp),
                        text = task.description,
                        maxLines = 6,
                        fontSize = 18.sp,
                        color = Color(0xB9000000)
                    )

                    StarCard()

                    Spacer(modifier = Modifier.height(10.dp))

                    BoxCard()

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        modifier = Modifier.padding(start = 20.dp, top = 22.dp),
                        text = "Services",
                        maxLines = 6,
                        fontSize = 38.sp,
                        color = Color(0xB9000000)
                    )
                    Text(
                        modifier = Modifier.padding(start = 20.dp, top = 22.dp),
                        text = task.description,
                        maxLines = 6,
                        fontSize = 18.sp,
                        color = Color(0xB9000000)
                    )

                }


            }


        }

        Image(
            modifier = Modifier.padding(top = 160.dp),
            painter = painterResource(id = task.picture),
            contentDescription = "",
            contentScale = ContentScale.Inside,
            alignment = Alignment.TopEnd
        )


    }


}

@Preview(showBackground = true)
@Composable
fun StarCard() {

    Box(
        modifier = Modifier
            .height(30.dp)
            .fillMaxWidth()
            .padding(start = 19.dp, top = 8.dp)
    ) {

        Row {
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = "",
                contentScale = ContentScale.Inside
            )
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = "",
                contentScale = ContentScale.Inside
            )
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = "",
                contentScale = ContentScale.Inside
            )
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = "",
                contentScale = ContentScale.Inside
            )
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = "",
                contentScale = ContentScale.Inside
            )

        }

    }

}

@Preview(showBackground = true)
@Composable
fun BoxCard() {

    Row(modifier = Modifier.padding(start = 26.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {

        Surface(color = Color.LightGray, shape = RoundedCornerShape(12.dp)) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .fillMaxWidth()
                    .padding(top = 28.dp, start = 4.dp)


            ) {

                Text(text = "500 ml", color = Color(0x7E0F2408))
            }
        }
        Surface(color = Color.LightGray, shape = RoundedCornerShape(12.dp)) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .fillMaxWidth()
                    .padding(top = 28.dp, start = 4.dp)


            ) {

                Text(text = "Less Ice", color = Color(0x7E0F2408))
            }
        }
        Surface(color = Color.LightGray, shape = RoundedCornerShape(12.dp)) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .fillMaxWidth()
                    .padding(top = 28.dp, start = 4.dp)


            ) {

                Text(text = "Sugar", color = Color(0x7E0F2408))
            }
        }

    }


}






























