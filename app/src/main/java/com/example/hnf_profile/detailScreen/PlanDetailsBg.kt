package com.example.hnf_profile.detailScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.hnf_profile.R

@Composable
fun PlanDetailsBg(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                listOf(
                    Color(0xFFFFFFFF), // White
                    Color(0xFFAFEEEE),// Pale Turquoise
                    Color(0xFF00B7DD),
                    Color(0xFF00CED1)
                )
            )
        )){

        Image(painter = painterResource(id = R.drawable.running_woman),
            contentDescription = "runningWoman",
            modifier = Modifier.size(360.dp).align(Alignment.TopCenter)
        )
    }
}