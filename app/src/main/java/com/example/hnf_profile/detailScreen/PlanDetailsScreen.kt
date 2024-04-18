package com.example.hnf_profile.detailScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PlanDetails(navController: NavController){
    PlanDetailsBg()
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {
            BlankDummyCard_GoBackButton(navController)
        }
        item {
            PlanDetails_AboutCard()
        }
        item{
            PlanDetails_Procedure()
        }
        
        item {
            PlanDetails_DisclaimerCard()
        }
    }
}

@Composable
fun PlanDetails_AboutCard(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color.Gray.copy(alpha = 0.4f),
                shape = RoundedCornerShape(12.dp)
            )
    ){
        Text(text = "About",
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp),
            fontSize = 24.sp
            )
    }
}

@Composable
fun PlanDetails_Procedure(){
    Text(text = "Are you Ready to kickstart this Routine?",
        color = Color.White,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier
            .padding(start=16.dp, bottom=16.dp),
        fontSize = 24.sp
        )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color.Gray.copy(alpha = 0.4f),
                shape = RoundedCornerShape(12.dp)
            )
    ){
        Text(text = "Step 1: Wake Up! \n" +
                "Step 2: Don't feel Lethargy\n" +
                "Step 3: Stay Alert!\n" +
                "Step 4: Focus\n" +
                "Step 5: Achieve your Goal!",
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(16.dp),
            fontSize = 16.sp
        )
    }
}

@Composable
fun PlanDetails_DisclaimerCard(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(
                Color(0xFF00B7DD),
                shape = RoundedCornerShape(12.dp)
            )
    ){
        Text(text = "Disclaimer: \n" +
                "The above written plans are general plans and have not been suggested by any physician",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(16.dp),
            fontSize = 8.sp
        )
    }
}

@Composable
fun BlankDummyCard_GoBackButton(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(
                Color.White.copy(alpha = 0f),
                shape = RoundedCornerShape(12.dp)
            )
    ){
        IconButton(onClick = {navController.navigate("Main_Screen") }) {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription ="Back Arrow",
                tint=Color(0xFF00B7DD),
                modifier = Modifier.size(40.dp))
        }
    }
}


