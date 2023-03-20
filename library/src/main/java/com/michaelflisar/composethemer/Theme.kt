package com.michaelflisar.composethemer

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

enum class Theme {
    System,
    Dark,
    Light;

    @Composable
    fun isDark(): Boolean {
        return when (this) {
            System -> isSystemInDarkTheme()
            Dark -> true
            Light -> false
        }
    }
}