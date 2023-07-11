package com.coderboot.simplecomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.coderboot.simplecomposeexample.multiSelectList.MultiSelectItem
import com.coderboot.simplecomposeexample.navigationWithBadges.BottomNavigationBar
import com.coderboot.simplecomposeexample.navigationWithBadges.BottomNavigationItem
import com.coderboot.simplecomposeexample.navigationWithBadges.Navigation
import com.coderboot.simplecomposeexample.navigationWithBadges.Screen
import com.coderboot.simplecomposeexample.ui.theme.MeditationUIYouTubeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationUIYouTubeTheme {
                MultiSelectItem()
            }


//            MeditationUIYouTubeTheme {
//                val navController = rememberNavController()
//                val items = listOf(
//                    BottomNavigationItem(
//                        name = "Home",
//                        route = Screen.HomeScreen.route,
//                        icon = Icons.Default.Home
//                    ),
//                    BottomNavigationItem(
//                        name = "Chat",
//                        route = Screen.ChatScreen.route,
//                        icon = Icons.Default.Notifications,
//                        badgeCount = 20
//                    ),
//                    BottomNavigationItem(
//                        name = "Setting",
//                        route = Screen.SettingScreen.route,
//                        icon = Icons.Default.Settings
//                    )
//                )
//                Scaffold(
//                    bottomBar = {
//                        BottomNavigationBar(
//                            items = items,
//                            navController = navController,
//                            onItemSelect = {
//                                navController.navigate(it.route)
//
//                            }
//                        )
//                    }
//                ) {
//                    Navigation(navController = navController)
//                }
//            }
//            MeditationUIYouTubeTheme {
//                NavigationSplash()
//            }
//            MeditationUIYouTubeTheme {
//               Navigation()
//            }
//            MeditationUIYouTubeTheme {
//                ProfileScreen()
//            }

//            var stateSize by remember {
//                mutableStateOf(200.dp)
//            }
//            val size by animateDpAsState(
//                targetValue = stateSize, tween(
//                    durationMillis = 3000, delayMillis = 300, easing = LinearOutSlowInEasing
//                )
////
////                spring(
////                    Spring.DampingRatioHighBouncy,
////                )
//            )
//            val infiniteTransition = rememberInfiniteTransition()
//            val color by infiniteTransition.animateColor(
//                initialValue = Color.Red,
//                targetValue = Color.Green,
//                animationSpec = infiniteRepeatable(
//                    tween(
//                        durationMillis = 2000
//                    ), repeatMode = RepeatMode.Reverse
//                )
//            )
//
//            Box(
//                modifier = Modifier
//                    .size(size)
//                    .background(color),
//                contentAlignment = Alignment.Center
//            ) {
//
//                Button(onClick = {
//                    stateSize += 50.dp
//
//                }) {
//                    Text("Increase Size")
//                }
//
//            }
//
//            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
//                CircularProgress(percentage = 0.8f, number = 100)
//            }
        }
    }
}

@Composable
fun CircularProgress(
    percentage: Float,
    number: Int,
    fontSize: TextUnit = 28.sp,
    radius: Dp = 50.dp,
    color: Color = Color.Green,
    strokeWith: Dp = 8.dp,
    animationDuration: Int = 1000,
    animationDelay: Int = 0,
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f, animationSpec = tween(
            durationMillis = animationDuration, delayMillis = animationDelay
        )
    )
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier.size(radius * 2f)
    ) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = color,
                - 90f,
                360 * curPercentage.value,
                useCenter = false,
                style = Stroke(strokeWith.toPx(), cap = StrokeCap.Round)
            )
        }

        Text(
            text = (curPercentage.value * number).toInt().toString(),
            color = Color.Black,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

