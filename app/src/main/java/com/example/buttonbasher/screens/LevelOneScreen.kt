package com.example.buttonbasher.screens

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.buttonbasher.ViewModel
import com.example.buttonbasher.components.ButtonLevelOne
import com.example.buttonbasher.components.ScoreBox
import com.example.buttonbasher.components.TimerBox
import com.example.buttonbasher.navigation.Route

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun LevelOneScreen(
    navController: NavController,
    viewModel: ViewModel
) {
    val timeRemaining = viewModel.timeRemaining.collectAsState().value

    if (viewModel.gameTimerComplete.value) {
        LaunchedEffect(key1 = true ){
            navController.navigate(Route.LEVEL_TWO)
            Log.d(TAG, "LevelOneScreen: ")
        }
    }
    Box(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxSize()
    ) {
        Row(
           modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.SpaceEvenly

        ){
            TimerBox(timeRemaining)
            ScoreBox(viewModel.scoreCount)
        }

        ButtonLevelOne(viewModel)
    }
}