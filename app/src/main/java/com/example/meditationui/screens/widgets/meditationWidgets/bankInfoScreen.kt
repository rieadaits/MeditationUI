package com.example.meditationui.screens.widgets.meditationWidgets

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.meditationui.screens.bank_viewmodel.BankViewModel
import com.ramcosta.composedestinations.annotation.Destination


@Destination
@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun BankInfoDetailsScreen(
    model: BankViewModel = viewModel()
){
    val viewModel = model.uiState.collectAsState()
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {
        Text(text = "start", color = Color.Red)
        Text(text = viewModel.value.accountNumber, color = Color.Red)
        Text(text = viewModel.value.confirmAccountNumber, color = Color.Red)
        Text(text = viewModel.value.code, color = Color.Red)
        Text(text = viewModel.value.ownerName, color = Color.Red)
        Text(text = "end", color = Color.Red)
    }
}