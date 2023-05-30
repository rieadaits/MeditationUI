package com.example.meditationui.screens.bank_viewmodel

import androidx.lifecycle.ViewModel
import com.example.meditationui.domain.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class BankViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(UIState())
    val uiState: StateFlow<UIState> = _uiState.asStateFlow()
}