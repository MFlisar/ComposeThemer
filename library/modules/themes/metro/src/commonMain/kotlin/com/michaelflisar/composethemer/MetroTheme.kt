package com.michaelflisar.composethemer

abstract class MetroTheme(
    override val group: MetroThemeGroup,
    override val variant: MetroThemeVariant,
    colors: ComposeThemeColors
) : ComposeTheme.Theme<MetroThemeVariant> {

    override val name
        get() = "${group.name} $variant"
    override val key
        get() = MetroThemes.getKey(name)

    override val lightScheme = colors.lightScheme()
    override val darkScheme = colors.darkScheme()

    override val lightSchemeMediumContrast = colors.lightSchemeMediumContrast()
    override val darkSchemeMediumContrast = colors.darkSchemeMediumContrast()

    override val lightSchemeHighContrast = colors.lightSchemeHighContrast()
    override val darkSchemeHighContrast = colors.darkSchemeHighContrast()

}