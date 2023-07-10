package com.coderboot.simplecomposeexample.navigationWithBadges

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val name: String,
    val badgeCount: Int = 0,
    val icon: ImageVector,
    val route: String
)
