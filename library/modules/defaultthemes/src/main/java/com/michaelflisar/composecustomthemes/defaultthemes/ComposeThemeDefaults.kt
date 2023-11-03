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
            colorSchemeLight = Color1.LightColors,
            colorSchemeDark = Color1.DarkColors,
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "blue",
            colorSchemeLight = Color2.LightColors,
            colorSchemeDark = Color2.DarkColors,
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "red",
            colorSchemeLight = Color3.LightColors,
            colorSchemeDark = Color3.DarkColors,
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        )
    )
}