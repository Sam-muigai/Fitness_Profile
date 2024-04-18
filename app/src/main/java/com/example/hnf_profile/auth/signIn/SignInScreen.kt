package com.example.hnf_profile.auth.signIn

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.hnf_profile.util.UiEvents
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SignInScreen(
    viewModel: SignInViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    onSignUpClicked: () -> Unit,
    onAuthSuccess: () -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = Unit,
        block = {
            viewModel.uiEvents.collectLatest { event ->
                when (event) {
                    UiEvents.Navigate -> {
                        onAuthSuccess.invoke()
                    }

                    is UiEvents.ShowSnackBar -> {
                        Toast.makeText(context, event.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        })
    SignInScreenContent(
        email = viewModel.email,
        onEmailChange = viewModel::onEmailChange,
        password = viewModel.password,
        onPasswordChange = viewModel::onPasswordChange,
        onSignInClicked = viewModel::loginUser,
        isLoading = viewModel.isLoading,
        onSignUpClicked = onSignUpClicked
    )
}


@Composable
fun SignInScreenContent(
    modifier: Modifier = Modifier,
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onSignInClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
    isLoading: Boolean = false
) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = onEmailChange
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = onPasswordChange
            )
            AnimatedVisibility(visible = !isLoading) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    onClick = onSignInClicked
                ) {
                    Text(text = "Sign In")
                }
            }
            AnimatedVisibility(visible = isLoading) {
                CircularProgressIndicator()
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                onClick = onSignUpClicked
            ) {
                Text(text = "Sign Up")
            }
        }
    }
}