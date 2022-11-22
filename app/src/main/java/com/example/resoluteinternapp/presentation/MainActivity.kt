package com.example.resoluteinternapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.resoluteinternapp.presentation.navigation.NavigationSetup
import com.example.resoluteinternapp.presentation.navigation.bottom.BottomBar
import com.example.resoluteinternapp.presentation.theme.ResoluteInternAPPTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ResoluteInternAPPTheme {

                MyApp()

            }
        }
    }
}


@Composable
fun MyApp() {

    val navController = rememberNavController()

    Scaffold(

        bottomBar = { BottomBar(navController = navController) },

        content = {
            Box(modifier = Modifier.padding(it)) {
                NavigationSetup(navController = navController)
            }
        }
    )


}