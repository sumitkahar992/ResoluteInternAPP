package com.example.resoluteinternapp.presentation.navigation.bottom

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.resoluteinternapp.R
import com.example.resoluteinternapp.presentation.screen.Screen

@Composable
fun BottomBar(
    navController: NavController
) {


    BottomNavigation(
        backgroundColor = Color.White,
        modifier = Modifier.height(72.dp)
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        NavBarItems.BarItems.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {

                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }


                },
                label = { Text(text = item.title) },
                icon = {

                    if (currentRoute == item.route) {

                        when (item.route) {
                            Screen.Home.route -> {
                                BottomIcon(icon = R.drawable.white_home)
                            }
                            Screen.Cart.route -> {
                                BottomIcon(icon = R.drawable.shopping_cart)
                            }
                            Screen.Store.route -> {
                                BottomIcon(icon = R.drawable.ic_search)
                            }


                        }

                    } else {
                        Icon(
                            imageVector = item.image,
                            contentDescription = null
                        )
                    }


                },

                unselectedContentColor = Color.Gray,
                alwaysShowLabel = false


            )
        }


    }


}


@Composable
fun BottomIcon(icon: Int) {

    Card(
        modifier = Modifier
            .width(40.dp)
            .height(40.dp)
            .clickable {

            },
        backgroundColor = Color(0xFAA7CC52),
        shape = CircleShape,
        contentColor = Color.White
    ) {

        Box(
            modifier = Modifier
                .padding(4.dp)
                .wrapContentSize()
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = ""
            )
        }


    }


}



















