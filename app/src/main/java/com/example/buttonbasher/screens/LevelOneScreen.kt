package com.example.buttonbasher.screens

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.buttonbasher.ViewModel
import com.example.buttonbasher.components.ButtonLevelOne
import com.example.buttonbasher.components.ScoreBox

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun LevelOneScreen(
    viewModel: ViewModel
) {
    Box(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxSize()
    ) {
       Row(
           modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.Center

        ){

            ScoreBox(viewModel.scoreCount)
        }

        ButtonLevelOne(viewModel)
    }
}