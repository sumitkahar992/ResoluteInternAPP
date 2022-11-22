package com.example.resoluteinternapp.presentation.screen

sealed class Screen(val route: String) {

    object Home : Screen("home_screen")
    object Cart : Screen("cart_screen")
    object Store : Screen("store_screen")
    object Detail : Screen("detail_screen")


}
