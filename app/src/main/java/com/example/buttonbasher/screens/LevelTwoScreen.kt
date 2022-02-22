package com.example.buttonbasher.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.buttonbasher.ViewModel
import com.example.buttonbasher.components.ScoreBox
import com.example.buttonbasher.components.TimerBox
import com.example.buttonbasher.levels.LevelTwo
import com.example.buttonbasher.navigation.Route


@Composable
fun LevelTwoScreen(
    viewModel: ViewModel,
    navController: NavController
) {

    val timeRemaining = viewModel.timeRemaining.collectAsState().value


    Box(
        Modifier
            .padding(5.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            TimerBox(timeRemaining)
            ScoreBox(viewModel.scoreCount)
        }
        LevelTwo(viewModel = viewModel)
    }

}