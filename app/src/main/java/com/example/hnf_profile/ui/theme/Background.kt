package com.example.hnf_profile.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hnf_profile.R
import com.valentinilk.shimmer.shimmer

@Composable
fun Background(){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.linearGradient(
                listOf(
                    Color(0xFF001F3F),
                    Color(0xFF003366),
                    Color(0xFF004080),
                    Color(0xFF00509E),
                    Color(0xFF0066B2),
                    Color(0xFF0078C0),
                    Color(0xFF008ACC),
                    Color(0xFF009FD5),
                    Color(0xFF00B7DD),
                    Color(0xFF00CED1)
                )
            )
        )
    ){
            Box(
                modifier = Modifier
                    .fillMaxSize()

            ) {
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                        .shimmer()
                        .shimmer()
                ) {
                    val strokeWidth = 20f // Adjust the width of the strip
                    translate(left = -600f, top = -1800f) {
                        drawArc(
                            color =  Color(0xFF009FD5),
                            startAngle = 10f,
                            sweepAngle = 100f,
                            useCenter = false,
                            size = size,
                            style = Stroke(strokeWidth)
                        )
                    }
                }
            }
        Image(painter = painterResource(id = R.drawable.db)
            , contentDescription = "3d Db",
            modifier = Modifier
                .graphicsLayer(
                    alpha = 0.4f
                )
                .shimmer()
                .padding(start = 240.dp, top = 190.dp)
                .size(140.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBackground(){
    Background()
}