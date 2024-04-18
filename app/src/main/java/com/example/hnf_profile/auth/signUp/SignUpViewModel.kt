package com.example.hnf_profile.auth.signUp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hnf_profile.util.UiEvents
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class SignUpViewModel : ViewModel() {

    private val _uiEvents = MutableSharedFlow<UiEvents>()
    val uiEvents = _uiEvents.asSharedFlow()

    private val auth = FirebaseAuth.getInstance()

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var isLoading by mutableStateOf(false)


    fun onEmailChange(value: String) {
        email = value
    }

    fun onPasswordChange(value: String) {
        password = value
    }


    fun registerUser() {
        isLoading = true
        viewModelScope.launch {
            try {
                auth.createUserWithEmailAndPassword(
                    email, password
                ).await()
                _uiEvents.emit(UiEvents.Navigate)
            } catch (e: Exception) {
                e.printStackTrace()
                isLoading = false
                _uiEvents.emit(
                    UiEvents.ShowSnackBar(
                        e.localizedMessage ?: "Unknown error occurred"
                    )
                )
            }
        }
    }
}




