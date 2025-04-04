package com.michaelflisar.composethemer.themes

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.michaelflisar.composethemer.ComposeTheme

object ThemeDefault : ComposeTheme.Group {

    override val collection = DefaultThemes
    override val groupKey = ComposeTheme.Key("", "Default")
    override val themes = listOf(Theme)

    object Theme : ComposeTheme.Theme {

        override val themeKey = ComposeTheme.Key("", "Default")
        override val group = ThemeDefault

        override val lightScheme: ColorScheme = lightColorScheme()
        override val darkScheme: ColorScheme = darkColorScheme()

        override val lightSchemeMediumContrast: ColorScheme
            get() = lightScheme
        override val darkSchemeMediumContrast: ColorScheme
            get() = darkScheme

        override val lightSchemeHighContrast: ColorScheme
            get() = lightScheme
        override val darkSchemeHighContrast: ColorScheme
            get() = darkScheme

    }
}

