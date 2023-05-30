package com.example.meditationui.domain

sealed class UIEvent {
    data class AccountNumber(val accountNumber: String) : UIEvent()
    data class ConfirmationAccountNumber(val confirmationAccountNumber: String) : UIEvent()
    data class BankCode(val bankCode: String) : UIEvent()
    data class HolderName(val holderName: String) : UIEvent()
    object Submit : UIEvent()
}