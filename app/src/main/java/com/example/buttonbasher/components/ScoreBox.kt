package com.example.buttonbasher.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ScoreBox(score: Int) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Text(
            text = "Score",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.width(5.dp))
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(40.dp)
                .width(100.dp)
                .clip(RoundedCornerShape(20.dp))
                .border(
                    width = 2.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(20.dp)
                )
                .background(
                    Color.LightGray,
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Text(
                text = score.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        }
    }

}