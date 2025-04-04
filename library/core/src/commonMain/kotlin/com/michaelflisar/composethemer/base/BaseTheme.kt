package com.michaelflisar.composethemer.base

import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.ComposeThemeColors

abstract class BaseTheme(
    override val themeKey: ComposeTheme.Key,
    override val group: ComposeTheme.Group,
    colors: ComposeThemeColors
) : ComposeTheme.Theme {

    override val lightScheme = colors.lightScheme()
    override val darkScheme = colors.darkScheme()

    override val lightSchemeMediumContrast = colors.lightSchemeMediumContrast()
    override val darkSchemeMediumContrast = colors.darkSchemeMediumContrast()

    override val lightSchemeHighContrast = colors.lightSchemeHighContrast()
    override val darkSchemeHighContrast = colors.darkSchemeHighContrast()

}