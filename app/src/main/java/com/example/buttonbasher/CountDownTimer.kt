package com.example.buttonbasher

import android.os.CountDownTimer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

var _timeRemaining = MutableStateFlow<Long>(3000)
val timeRemaining: StateFlow<Long> = _timeRemaining

class CountDownTimer() : CountDownTimer(3000, 1000) {
    override fun onTick(secUntilFinished: Long) {
        _timeRemaining.value = secUntilFinished
    }

    override fun onFinish() {

    }

}