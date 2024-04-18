package com.example.hnf_profile.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hnf_profile.R

@Composable
fun Profile() {
    Box(
        modifier = Modifier
            .width(340.dp)
            .height(160.dp)
            .background(Color.Black.copy(alpha = 0.4f),
                shape = RoundedCornerShape(12.dp)),
//        elevation = CardDefaults.cardElevation(
//            defaultElevation = 6.dp
//        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ProfileImage()
                ProfileDetails()
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ReminderToCompleteProfile()
            }
        }
    }
}

@Composable
fun ProfileImage(
    modifier: Modifier = Modifier
){
    Image(painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = null,
        modifier = modifier
            .size(100.dp)
            .border(width = 4.dp, color = Color(0xFF00B7DD), shape = CircleShape)
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .padding(5.dp)
            .clip(CircleShape)
    )
}

@Composable
fun ProfileDetails(
    //modifier: Modifier = Modifier,
    name:String="No name",
    email:String="no-email@null.com",
    phNo:String="null00000"
){
    Box{
        Column(
            modifier = Modifier.padding(top=6.dp).padding(start=14.dp)
        ) {
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 22.sp, color = Color.White)
            Text(text = "E-mail: $email", color = Color.White)
            Text(text = "Contact: $phNo", color = Color.White)
            LinearProgressBar(progress=0.7f)
        }
    }
}

@Composable
fun LinearProgressBar(progress:Float){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 15.dp)) {
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp),
            color = Color(0xFF00B7DD),
            trackColor = Color.LightGray,
        )
    }
}

@Composable
fun ReminderToCompleteProfile(){
    Box(
        modifier = Modifier
            .background(color = Color.LightGray,
                shape = RoundedCornerShape(16.dp)
            )
            .height(20.dp)
            .width(150.dp),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Complete your Profile.")
    }
}