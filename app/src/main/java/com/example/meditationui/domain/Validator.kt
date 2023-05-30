package com.example.meditationui.domain

object Validator {

    fun validateAccountNumber(accountNumber: String): ValidationResult {
        return ValidationResult(accountNumber.isNotEmpty() && accountNumber.length > 5)
    }

    fun validateConfirmAccountNumber(
        accountNumber: String,
        confirmAccountNumber: String
    ): ValidationResult {
        return ValidationResult(confirmAccountNumber.isNotEmpty() && confirmAccountNumber == accountNumber)
    }

    fun validateBankCodeNumber(codeNumber: String): ValidationResult {
        return ValidationResult(codeNumber.isNotEmpty() && codeNumber.length > 4)
    }

    fun validateAccountHolderName(accountHolderName: String): ValidationResult {
        return ValidationResult(accountHolderName.isNotEmpty())
    }
}

data class ValidationResult(val status: Boolean = false)