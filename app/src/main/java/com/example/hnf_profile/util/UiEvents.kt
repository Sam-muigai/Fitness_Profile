package com.example.hnf_profile.util

sealed class UiEvents {
    data object Navigate : UiEvents()
    data class ShowSnackBar(val message: String) : UiEvents()
}