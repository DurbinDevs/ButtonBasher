package com.example.buttonbasher

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel(){

    var scoreCount by mutableStateOf(0)
    private set

    fun scoreCount(){
            scoreCount++
    }
}