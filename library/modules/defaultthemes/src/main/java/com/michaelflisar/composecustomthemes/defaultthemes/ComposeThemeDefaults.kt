package com.michaelflisar.composecustomthemes.defaultthemes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.michaelflisar.composecustomtheme.ComposeTheme

object ComposeThemeDefaults {

    fun getDefaultThemes(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = listOf(
        ComposeTheme.Theme(
            key = "default",
            colorSchemeLight = lightColorScheme(),
            colorSchemeDark = darkColorScheme(),
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "green",
            colorSchemeLight = ColorGreenGreenOrange.LightColors,
            colorSchemeDark = ColorGreenGreenOrange.DarkColors,
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "blue",
            colorSchemeLight = ColorBlueBlueRed.LightColors,
            colorSchemeDark = ColorBlueBlueRed.DarkColors,
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "red",
            colorSchemeLight = ColorRedRedBlue.LightColors,
            colorSchemeDark = ColorRedRedBlue.DarkColors,
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        )
    )
}