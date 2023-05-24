package com.example.meditationui.utils

import androidx.compose.ui.graphics.Color

object HexToJetpackColor {
    fun getColor(colorString: String): androidx.compose.ui.graphics.Color {
        return Color(android.graphics.Color.parseColor("$colorString"))
    }
}