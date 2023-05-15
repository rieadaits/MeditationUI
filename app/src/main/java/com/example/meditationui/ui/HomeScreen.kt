package com.example.meditationui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.meditationui.R
import com.example.meditationui.ui.theme.ButtonBlue
import com.example.meditationui.ui.theme.DarkerButtonBlue
import com.example.meditationui.ui.theme.DeepBlue
import com.example.meditationui.ui.theme.TextWhite


@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
    ) {
        Column() {
            GreetingSection()
            ChipSection(chips = listOf("hello", "world", "boy"))
        }
    }
}

@Composable
fun GreetingSection(
    name: String = "Riead",
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(text = "Good morning, $name", style = MaterialTheme.typography.headlineSmall)
            Text(text = "We wish you have a good day!", style = MaterialTheme.typography.bodySmall)
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "search",
            modifier = Modifier.size(24.dp),
            tint = Color.White
        )
    }
}

@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember { mutableStateOf(0) }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable { selectedChipIndex = it }
                    .background(if (selectedChipIndex == it) ButtonBlue else DarkerButtonBlue)
                    .padding(15.dp)) {
                Text(
                    text = chips[it], color = TextWhite
                )
            }

        }
    }
}