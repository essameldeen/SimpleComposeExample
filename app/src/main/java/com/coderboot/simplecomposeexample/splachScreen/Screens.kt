package com.coderboot.simplecomposeexample.splachScreen

sealed class Screens(val route: String) {
    object SplashScreen : Screens("splash_screen")
    object MainScreen : Screens("main_screen")
}
