package com.example.buttonbasher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.buttonbasher.screens.LevelOneScreen
import com.example.buttonbasher.ui.theme.ButtonBasherTheme
import androidx.navigation.compose.rememberNavController
import com.example.buttonbasher.navigation.Route
import com.example.buttonbasher.screens.LevelTwoScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonBasherTheme {
                val navController = rememberNavController()
                val viewModel = ViewModel()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavHost(navController = navController,
                    startDestination = Route.LEVEL_ONE
                        ){

                        composable(Route.LEVEL_ONE) {
                            LevelOneScreen(
                                viewModel = viewModel,
                                navController = navController
                            )
                        }
                        composable(Route.LEVEL_TWO) {
                            LevelTwoScreen()

                        }
                    }
                }
            }
        }
    }
}

