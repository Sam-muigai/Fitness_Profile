package com.example.hnf_profile.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContentCards(
    image: Painter,
    exerciseName:String="Null"
){
    Card(
        modifier= Modifier
            .fillMaxWidth()
            .height(160.dp)
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.fillMaxSize()){
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .graphicsLayer(alpha = 0.5f)
                        //.aspectRatio(28f/16)
                        .clip(shape = MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop,
                    //colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.Green, blendMode = androidx.compose.ui.graphics.BlendMode.Darken)
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF0066B2).copy(alpha = 0.4f))
                        .padding(20.dp),
                    contentAlignment = Alignment.BottomStart
                ) {

                    Text(
                        text = exerciseName,
                        fontSize = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier.align(alignment = Alignment.BottomEnd)
                            .padding(top=65.dp)
                    ) {
                        Text(text = "Schedule")
                    }
                }

            }
        }
    }


}
