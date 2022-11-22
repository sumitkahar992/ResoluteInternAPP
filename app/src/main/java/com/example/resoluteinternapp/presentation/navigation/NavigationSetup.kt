package com.example.resoluteinternapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.resoluteinternapp.presentation.cart.CartScreen
import com.example.resoluteinternapp.presentation.detail.DetailScreen
import com.example.resoluteinternapp.presentation.home.HomeScreen
import com.example.resoluteinternapp.presentation.screen.Screen


@Composable
fun NavigationSetup(navController: NavHostController) {


    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {
            HomeScreen()
        }

        composable(Screen.Cart.route) {
            CartScreen(navController)
        }

        composable(Screen.Store.route) {
            DetailScreen()
        }

        composable(Screen.Detail.route) {
            DetailScreen()
        }


    }


}