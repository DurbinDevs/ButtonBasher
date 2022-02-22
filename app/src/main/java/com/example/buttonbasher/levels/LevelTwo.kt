package com.example.buttonbasher.levels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.buttonbasher.ViewModel
import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun LevelTwo(
    viewModel: ViewModel
) {


    var clicked by remember {
        mutableStateOf(false)
    }
    val timerStarted = viewModel.timerStarted
    val gameTimerComplete = viewModel.gameTimerComplete.value
    val count = viewModel.scoreCount
    Log.d(TAG, "LevelTwotimer finish: $gameTimerComplete")
    Log.d(TAG, "LevelTwotimer started: $timerStarted")
    val circleSize: Dp by animateDpAsState(
        when (count) {
            in 0..50 -> 100.dp
            in 50..100 -> 50.dp
            in 100..150 -> 25.dp
            else -> 12.dp
        }
    )
    if (clicked && gameTimerComplete){
        viewModel.startTimer()
        clicked = !clicked
    }

    var randomY by remember {
        mutableStateOf(50.dp)
    }
    var randomX by remember {
        mutableStateOf(0.dp)
    }

    if (timerStarted) {
        LaunchedEffect(key1 = randomY, block = {
            delay(1000)
            randomX = Random.nextInt(0..280).dp
            randomY = Random.nextInt(50..600).dp
        } )
    }

//    val circlePositionX: Dp by animateDpAsState(
//        Random.nextInt(0..280).dp,
//        animationSpec = tween(
//            durationMillis = 500,
//
//        )
//    )
//
//    val circlePositionY: Dp by animateDpAsState(
//        Random.nextInt(50..600).dp,
//        animationSpec = tween(
//            durationMillis = 500
//        )
//    )


    Box(
        modifier = Modifier
            .size(circleSize, circleSize)
            .absoluteOffset(
                randomX,
                randomY
            )
            .clip(RoundedCornerShape(100.dp))
            .clickable { clicked = true; viewModel.scoreCount() }
            .background(Color.Blue)
    )
}