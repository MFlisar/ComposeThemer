package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.michaelflisar.composethemer.ComposeTheme

object ThemeDefault {

    const val KEY = "Default"

    fun get() = ComposeTheme.Theme(
        key = KEY,
        colorSchemeLight = lightColorScheme(),
        colorSchemeDark = darkColorScheme()
    )
}