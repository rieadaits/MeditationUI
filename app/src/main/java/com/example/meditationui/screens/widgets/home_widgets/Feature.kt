package com.example.meditationui.screens.widgets.home_widgets

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Feature(
    val title: String,
    @DrawableRes val iconId: Int,
    val lightColor: String,
    val mediumColor: String,
    val darkColor:  String,
) : Parcelable
