package com.example.meditationui.domain

data class UIState(
    val accountNumber: String = "",
    val confirmAccountNumber: String = "",
    val code: String = "",
    val ownerName: String = "",
    val hasAccountError: Boolean = false,
    val hasConfirmAccountError: Boolean = false,
    val hasCodeError: Boolean = false,
    val hasNameError: Boolean = false,
)
