package com.example.hnf_profile.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hnf_profile.auth.signIn.SignInScreen
import com.example.hnf_profile.auth.signUp.SignUpScreen
import com.example.hnf_profile.detailScreen.PlanDetails
import com.google.firebase.auth.FirebaseAuth

@Composable
fun Navigation() {
    val navController = rememberNavController()

    val auth = FirebaseAuth.getInstance()

    val startDestination = if (auth.currentUser == null) {
        "Sign_In_Screen"
    } else {
        "Main_Screen"
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = "Main_Screen") {
            MainProfile_n_Content_Screen(navController)
        }
        composable(route = "Detail_Screen") {
            PlanDetails(navController)
        }
        composable(route = "Sign_Up_Screen") {
            SignUpScreen {
                navController.navigate("Main_Screen") {
                    popUpTo("Sign_Up_Screen") {
                        inclusive = true
                    }
                }
            }
        }
        composable(route = "Sign_In_Screen") {
            SignInScreen(
                onSignUpClicked = {
                    navController.navigate("Sign_Up_Screen")
                }
            ) {
                navController.navigate("Main_Screen") {
                    popUpTo("Sign_In_Screen") {
                        inclusive = true
                    }
                }
            }
        }
    }
}