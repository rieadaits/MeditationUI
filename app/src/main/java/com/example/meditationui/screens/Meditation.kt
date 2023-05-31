package com.example.meditationui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.meditationui.domain.UIEvent
import com.example.meditationui.domain.ValidationEvent
import com.example.meditationui.screens.bank_viewmodel.BankViewModel
import com.example.meditationui.screens.widgets.meditationWidgets.BankInputField

@Composable
fun MeditationScreen(
    bankFormViewModel: BankViewModel = viewModel()
) {
    val state = bankFormViewModel.uiState.collectAsState()
    val context = LocalContext.current
    val localFocus = LocalFocusManager.current
    LaunchedEffect(key1 = context, block = {
        bankFormViewModel.validationEvent.collect { event ->
            when (event) {
                is ValidationEvent.Success -> {
                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
                }

                is ValidationEvent.Error -> {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    })
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BankInputField(label = "Account Number",
                isError = state.value.hasAccountError,
                onDone = {},
                onNext = {
                localFocus.moveFocus(
                    FocusDirection.Down
                )
            }, onTextChanged = {
                bankFormViewModel.onEvent(UIEvent.AccountNumber(it))
            })
            BankInputField(
                label = "Confirm Account Number",
                isError = state.value.hasConfirmAccountError,
                onDone = {},
                onNext = {
                         localFocus.moveFocus(FocusDirection.Down)
                },
                onTextChanged = {
                    bankFormViewModel.onEvent(UIEvent.ConfirmationAccountNumber(it))
                })
            BankInputField(label = "Bank Code",
                isError = state.value.hasCodeError,
                onDone = {},
                onNext = {
                    localFocus.moveFocus(FocusDirection.Down)},
                onTextChanged = {
                    bankFormViewModel.onEvent(UIEvent.BankCode(it))})
            BankInputField(label = "Owner Name",
                isError = state.value.hasNameError,
                onDone = {
                    localFocus.clearFocus()
                },
                onNext = {},
                onTextChanged = {
                bankFormViewModel.onEvent(UIEvent.HolderName(it))
                })

            Button(
                onClick = {
                          bankFormViewModel.onEvent(UIEvent.Submit)
                },
            ) {
                Text("Submit")
            }
        }
    }
}