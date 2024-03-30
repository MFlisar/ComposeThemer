package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.michaelflisar.composethemer.ComposeTheme

object ThemeDefault {

    const val KEY = "Default"

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = KEY,
        colorSchemeLight = lightColorScheme(),
        colorSchemeDark = darkColorScheme(),
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )
}