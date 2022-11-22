package com.example.resoluteinternapp.presentation.navigation.bottom

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.resoluteinternapp.presentation.screen.Screen

data class BottomNavItem(
    val title: String,
    val image: ImageVector,
    val route: String
)

object NavBarItems {
    val BarItems = listOf(
        BottomNavItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = Screen.Home.route
        ),
        BottomNavItem(
            title = "Cart",
            image = Icons.Filled.ShoppingCart,
            route = Screen.Cart.route
        ),
        BottomNavItem(
            title = "Store",
            image = Icons.Filled.Favorite,
            route = Screen.Store.route
        )
    )
}