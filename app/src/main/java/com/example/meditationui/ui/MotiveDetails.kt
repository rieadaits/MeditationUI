package com.example.meditationui.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun MotiveDetails(
    destinationString: String
){
    Box(modifier = Modifier.padding(15.dp)){
        Column(verticalArrangement = Arrangement.Center) {
            Text(text = "Hello $destinationString!")
        }
    }
}