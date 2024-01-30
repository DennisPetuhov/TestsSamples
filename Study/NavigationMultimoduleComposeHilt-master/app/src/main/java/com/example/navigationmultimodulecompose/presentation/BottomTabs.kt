package com.example.navigationmultimodulecompose.presentation

import androidx.annotation.DrawableRes
import com.example.navigationmultimodulecompose.R

enum class BottomTabs(

    val title: String,
    @DrawableRes
    val icon: Int,
    val route: String
) {

    HOME(
        "home",
        R.drawable.ic_launcher_foreground,
        "home"
    ),
    SETTINGS(
        "settings",
        R.drawable.ic_launcher_background,
        "settings"
    )
}
