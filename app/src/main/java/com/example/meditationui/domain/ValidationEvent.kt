package com.example.meditationui.domain

sealed class ValidationEvent() {
    object Success : ValidationEvent()
    object Error : ValidationEvent()
}
