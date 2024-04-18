package com.example.hnf_profile.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hnf_profile.R

@Composable
fun ContentCards2(
    exerciseName:String="Null",
    navController: NavController){
    Box(
        modifier = Modifier.fillMaxSize().padding(top=10.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(
                    Color.Black.copy(alpha = 0.4f), shape = RoundedCornerShape(12.dp)
                )
        ) {
            Image(painter = painterResource(id = R.drawable.treadmill),
                contentDescription = null,
                modifier = Modifier
                    .offset(200.dp, (-15).dp)
                    .size(200.dp)
                )

            Image(painter = painterResource(id = R.drawable.kettle),
                contentDescription = null,
                modifier = Modifier
                    .offset(180.dp, 40.dp)
                    .size(100.dp)
            )

            Text(
                text = exerciseName,
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            )

            Button(onClick = {
                navController.navigate("Detail_Screen")
            },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
                    .size(100.dp, 30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF009FD5)
                )
            ) {
                Text(text = "Schedule", fontSize = 12.sp, modifier = Modifier.fillMaxSize())
            }
        }
    }
}

