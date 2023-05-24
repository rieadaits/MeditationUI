package com.example.meditationui.utils

import androidx.annotation.DrawableRes
import com.example.meditationui.R

sealed class NavigationItem(val route: String, val title: String, @DrawableRes val iconId: Int) {

    object Home : NavigationItem("home", "Home", R.drawable.ic_home)

    object Meditation : NavigationItem("meditation","Meditate", R.drawable.ic_bubble)

    object Sleep : NavigationItem("sleep","Sleep", R.drawable.ic_moon)

    object Music : NavigationItem("music","Music", R.drawable.ic_music)

    object Profile : NavigationItem("profile","Profile", R.drawable.ic_profile)

}
