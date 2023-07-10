package com.coderboot.simplecomposeexample.navigationWithBadges

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            HomeScreen()
        }
        composable(Screen.ChatScreen.route) {
            ChatScreen()
        }
        composable(Screen.SettingScreen.route) {
            SettingScreen()
        }
    }
}


@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationItem>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemSelect: (BottomNavigationItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {

        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                onClick = { onItemSelect(item) },
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        if (item.badgeCount > 0) {

                            BadgedBox( badge = { Badge { Text(item.badgeCount.toString()) } } ){
                                Icon(imageVector = item.icon, contentDescription = item.name)
                            }
                        } else {
                            Icon(imageVector = item.icon, contentDescription = item.name)
                        }

                        if (selected) {
                            Text(
                                text = item.name,
                                color = Color.Green,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }

                },
            )


        }

    }
}

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object ChatScreen : Screen("chat_screen")
    object SettingScreen : Screen("setting_screen")


    // make this function with mandatory arguments
    fun witArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}