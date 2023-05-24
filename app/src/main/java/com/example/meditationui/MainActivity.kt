package com.example.meditationui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.meditationui.ui.HomeScreen
import com.example.meditationui.ui.MeditationScreen
import com.example.meditationui.ui.MusicScreen
import com.example.meditationui.ui.ProfileScreen
import com.example.meditationui.ui.SleepScreen
import com.example.meditationui.ui.theme.AquaBlue
import com.example.meditationui.ui.theme.ButtonBlue
import com.example.meditationui.ui.theme.DeepBlue
import com.example.meditationui.ui.theme.MeditationUiTheme
import com.example.meditationui.utils.NavigationItem
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationUiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    HomeScreen()
                    DestinationsNavHost(navGraph = NavGraphs.root)
                }
            }
        }
    }
}


@Composable
fun NavigationController(navController: NavHostController, navigator: DestinationsNavigator) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {

        composable(NavigationItem.Home.route) {
            HomeScreen(navigator = navigator)
        }

        composable(NavigationItem.Meditation.route) {
            MeditationScreen()
        }

        composable(NavigationItem.Sleep.route) {
            SleepScreen()
        }

        composable(NavigationItem.Music.route) {
            MusicScreen()
        }

        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }

    }

}

@Destination(start = true)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(navigator: DestinationsNavigator) {

    val navController = rememberNavController()

    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Meditation,
        NavigationItem.Sleep,
        NavigationItem.Music,
        NavigationItem.Profile,
    )


    Scaffold(
        bottomBar = {
            BottomNavigation(backgroundColor = DeepBlue) {

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route


                items.forEach { it ->
                    BottomNavigationItem(
                        selected = currentRoute == it.route,
                        modifier = Modifier.padding(2.dp),
                        label = {
                            Text(
                                text = it.title,
                                maxLines = 1,
                                style = TextStyle(fontSize = 12.sp),
                                overflow = TextOverflow.Ellipsis,
                                color = if (currentRoute == it.route) Color.White else Color.LightGray

                            )
                        },

                        icon = {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(if (currentRoute == it.route) ButtonBlue else Color.Transparent)
                                    .padding(6.dp)
                            ){
                                Icon(
                                    painter = painterResource(id = it.iconId),
                                    contentDescription = it.title,
                                    modifier = Modifier.size(16.dp),
                                    tint = if (currentRoute == it.route) Color.White else AquaBlue

                                )
                            }

                        },

                        onClick = {
                            if (currentRoute != it.route) {

                                navController.graph.startDestinationRoute?.let {
                                    navController.popBackStack(it, true)
                                }

                                navController.navigate(it.route) {
                                    launchSingleTop = true
                                }

                            }

                        },
                        selectedContentColor = Color.White,
                        unselectedContentColor = AquaBlue,
                    )

                }


            }


        }) {

        NavigationController(navController = navController, navigator = navigator)

    }

}
