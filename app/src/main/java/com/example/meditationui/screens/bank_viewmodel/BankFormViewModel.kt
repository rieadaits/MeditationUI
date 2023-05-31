package com.example.meditationui.screens.bank_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meditationui.domain.UIEvent
import com.example.meditationui.domain.UIState
import com.example.meditationui.domain.ValidationEvent
import com.example.meditationui.domain.Validator.validateAccountHolderName
import com.example.meditationui.domain.Validator.validateAccountNumber
import com.example.meditationui.domain.Validator.validateBankCodeNumber
import com.example.meditationui.domain.Validator.validateConfirmAccountNumber
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BankViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(UIState())
    val uiState: StateFlow<UIState> = _uiState.asStateFlow()

    val validationEvent = MutableSharedFlow<ValidationEvent>()

    fun onEvent(event: UIEvent) {
        when (event) {
            is UIEvent.AccountNumber -> {
                _uiState.value = _uiState.value.copy(accountNumber = event.accountNumber)
            }

            is UIEvent.BankCode -> {
                _uiState.value = _uiState.value.copy(code = event.bankCode)
            }

            is UIEvent.ConfirmationAccountNumber -> {
                _uiState.value =
                    _uiState.value.copy(confirmAccountNumber = event.confirmationAccountNumber)
            }

            is UIEvent.HolderName -> {
                _uiState.value = _uiState.value.copy(ownerName = event.holderName)
            }

            is UIEvent.Submit -> {
                _validateInput()
            }
        }
    }

    private fun _validateInput() {
        val accountResult = validateAccountNumber(accountNumber = _uiState.value.accountNumber)
        val confirmAccountNumberResult = validateConfirmAccountNumber(
            accountNumber = _uiState.value.accountNumber,
            confirmAccountNumber = _uiState.value.confirmAccountNumber
        )
        val ownerNameResult =
            validateAccountHolderName(accountHolderName = _uiState.value.ownerName)
        val bankCodeResult = validateBankCodeNumber(codeNumber = _uiState.value.code)

        _uiState.value = _uiState.value.copy(
            hasAccountError = !accountResult.status,
            hasCodeError = !bankCodeResult.status,
            hasConfirmAccountError = !confirmAccountNumberResult.status,
            hasNameError = !ownerNameResult.status
        )

        val hasError = listOf(
            accountResult, confirmAccountNumberResult, ownerNameResult, bankCodeResult
        ).any{
            !it.status
        }

        viewModelScope.launch {
            if(!hasError){
                validationEvent.emit(ValidationEvent.Success)
            }else{
                validationEvent.emit(ValidationEvent.Error)
            }
        }
    }
}