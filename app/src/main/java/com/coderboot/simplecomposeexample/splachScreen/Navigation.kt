package com.coderboot.simplecomposeexample.splachScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationSplash() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {

        composable(Screens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(Screens.MainScreen.route) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                Text(text = "Main Screen", color = Color.White)
            }
        }

    }
}