package com.example.buttonbasher.levels

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.buttonbasher.ViewModel
import kotlin.random.Random
import kotlin.random.nextInt


@Composable
fun LevelOne(
    viewModel: ViewModel
) {

    var clicked by remember {
        mutableStateOf(false)
    }

    val count = viewModel.scoreCount
    val timerStarted = viewModel.timerStarted


    val circleSize: Dp by animateDpAsState(
        when (count) {
            in 0..10 -> 100.dp
            in 11..20 -> 50.dp
            in 21..30-> 25.dp
            else -> 12.dp
        }
    )

    if (clicked && !timerStarted){
        viewModel.startTimer()
    }
    var randomY by remember {
        mutableStateOf(50.dp)
    }
  var randomX by remember {
        mutableStateOf(0.dp)
    }
    if (clicked) {
        randomX = Random.nextInt(0..280).dp
        randomY = Random.nextInt(50..600).dp
        viewModel.scoreCount()
        clicked = !clicked
    }

    Box(
        modifier = Modifier
            .height(circleSize)
            .width(circleSize)
            .absoluteOffset(
                x = randomX,
                y = randomY
            )
            .clip(RoundedCornerShape(100.dp))
            .clickable { clicked = true}
            .background(Color.Black)

    ) {

    }




}