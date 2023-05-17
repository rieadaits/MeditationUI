package com.example.meditationui.ui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Feature(
    val title: String,
    @DrawableRes val iconId: Int,
    val lightColor: Color,
    val darkColor: Color,
    val mediumColor: Color,
)
