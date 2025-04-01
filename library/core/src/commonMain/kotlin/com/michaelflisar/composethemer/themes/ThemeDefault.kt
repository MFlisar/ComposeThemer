package com.michaelflisar.composethemer.themes

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.michaelflisar.composethemer.ComposeTheme

object ThemeDefault : ComposeTheme.Group<ThemeDefaultVariant> {

    override val name = "Default"
    override val themes = listOf(Default)
    override val defaultVariant = ThemeDefaultVariant.Default

    object Default : ComposeTheme.Theme<ThemeDefaultVariant> {

        override val group = ThemeDefault
        override val variant = ThemeDefaultVariant.Default
        override val name = ThemeDefault.name
        override val key = ""

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