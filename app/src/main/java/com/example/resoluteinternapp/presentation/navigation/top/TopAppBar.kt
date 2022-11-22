package com.example.resoluteinternapp.presentation.navigation.top

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector


@Composable
fun TopBarDefault(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    androidx.compose.material.TopAppBar(
        title = { Text(text = title) },

        navigationIcon = {
            IconButton(onClick = {
                onClick()
            }) {
                Icon(imageVector = icon,
                    contentDescription = null
                )
            }
        }
    )

}