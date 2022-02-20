package com.example.buttonbasher

import android.content.ContentValues.TAG
import android.os.CountDownTimer
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.concurrent.timer

class ViewModel(
) : ViewModel() {

    var scoreCount by mutableStateOf(0)
        private set

    var timerStarted = false
    var gameTimerComplete = mutableStateOf(false)
    private var gameTimer: CountDownTimer? = null
    private val _timeRemaining = MutableStateFlow<Long>(30)
    val timeRemaining: StateFlow<Long> = _timeRemaining

    fun scoreCount() {
        scoreCount++
    }

    fun startTimer(){
        timerStarted = true
            gameTimer()
    }



    fun gameTimer() {
        gameTimer = object : CountDownTimer(30000, 1000) {
            override fun onTick(secUntilFinished: Long) {
                _timeRemaining.value = secUntilFinished / 1000
            }

            override fun onFinish() {
                gameTimerComplete.value = true
            }

        }.start()
    }

}