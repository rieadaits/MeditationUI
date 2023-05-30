package com.example.meditationui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.meditationui.screens.widgets.meditationWidgets.BankInputField

@Composable
fun MeditationScreen() {
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
            BankInputField(label = "Bank", onDone = {}, onNext = {}, onTextChanged = {})
            BankInputField(label = "Bank", onDone = {}, onNext = {}, onTextChanged = {})
            BankInputField(label = "Bank", onDone = {}, onNext = {}, onTextChanged = {})
            BankInputField(label = "Bank", onDone = {}, onNext = {}, onTextChanged = {})

            Button(
                onClick = {

                },
            ) {
                Text("Submit")
            }
        }
    }
}