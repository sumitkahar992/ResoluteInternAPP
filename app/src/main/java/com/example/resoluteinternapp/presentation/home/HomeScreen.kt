package com.example.resoluteinternapp.presentation.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.resoluteinternapp.R
import com.example.resoluteinternapp.domain.local.getAllTea
import com.example.resoluteinternapp.presentation.navigation.top.TopBarDefault
import kotlinx.coroutines.launch

@Composable
fun HomeScreen() {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val contextForToast = LocalContext.current.applicationContext

    Scaffold(

        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,

        topBar = {
            TopBarDefault(
                title = "Hi, John!",
                icon = Icons.Filled.Menu,
                onClick = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerContent = {

            DrawerContent(
                onClick = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                    }
                }
            )

        },

        content = {

            HomeContent(modifier = Modifier.padding(it))

        }
    )


}

@Composable
fun DrawerContent(onClick: () -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {
        IconButton(
            modifier = Modifier
                .align(Alignment.End),
            onClick = {
                onClick()
            }) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
        }


        Row {
            IconButton(onClick = {
                onClick()
            }) {
                Icon(imageVector = Icons.Filled.Home, contentDescription = "")
            }
            Text(text = "Home")

        }
        Row {
            IconButton(onClick = {
                onClick()
            }) {
                Icon(imageVector = Icons.Filled.Face, contentDescription = "")

            }
            Text(text = "Profile")
        }


    }


}


@Composable
fun HomeContent(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier.padding(7.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        item {
            SearchBar(onSearchClick = { })
        }

        item {
            PagerCard()
        }

        item {

            LazyRow {
                items(getAllTea()) { tea ->
                    TeaCard(tea = tea) {

                    }

                }
            }
        }



        items(getAllTea()) { tea ->
            TeaDetailCard(tea = tea) {

            }
        }


    }
}


@Composable
fun SearchBar(
    onSearchClick: () -> Unit
) {

    Card(
        shape = RoundedCornerShape(32.dp),
        backgroundColor = Color(0x9EFFF5F5)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onSearchClick() }) {
                Icon(
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = null,
                )
            }
            Spacer(modifier = Modifier.width(22.dp))

            Text(text = "Search")


        }

    }


}


@Preview(name = "Light")
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SearchBar() {
    SearchBar(onSearchClick = { })

}