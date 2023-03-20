package com.michaelflisar.composethemer.preferences

import androidx.compose.ui.graphics.toArgb
import com.michaelflisar.composethemer.*
import com.michaelflisar.composethemer.ComposeThemePrefs
import com.michaelflisar.materialpreferences.core.SettingsModel
import com.michaelflisar.materialpreferences.datastore.DataStoreStorage

object ThemePrefsLight : SettingsModel(DataStoreStorage(name = "compose_themer_light")),
    ComposeThemePrefs {

    // Main Colors
    override val primary by intPref(md_theme_light_primary.toArgb())
    override val onPrimary by intPref(md_theme_light_onPrimary.toArgb())
    override val secondary by intPref(md_theme_light_secondary.toArgb())
    override val onSecondary by intPref(md_theme_light_onSecondary.toArgb())
    override val tertiary by intPref(md_theme_light_tertiary.toArgb())
    override val onTertiary by intPref(md_theme_light_onTertiary.toArgb())

    // Container
    override val primaryContainer by intPref(md_theme_light_primaryContainer.toArgb())
    override val onPrimaryContainer by intPref(md_theme_light_onPrimaryContainer.toArgb())
    override val secondaryContainer by intPref(md_theme_light_secondaryContainer.toArgb())
    override val onSecondaryContainer by intPref(md_theme_light_onSecondaryContainer.toArgb())
    override val tertiaryContainer by intPref(md_theme_light_tertiaryContainer.toArgb())
    override val onTertiaryContainer by intPref(md_theme_light_onTertiaryContainer.toArgb())

    // Background/Surface
    override val background by intPref(md_theme_light_background.toArgb())
    override val onBackground by intPref(md_theme_light_onBackground.toArgb())
    override val surface by intPref(md_theme_light_surface.toArgb())
    override val onSurface by intPref(md_theme_light_onSurface.toArgb())
    override val surfaceVariant by intPref(md_theme_light_surfaceVariant.toArgb())
    override val onSurfaceVariant by intPref(md_theme_light_onSurfaceVariant.toArgb())
    override val surfaceTint by intPref(md_theme_light_surfaceTint.toArgb())

    // Inverse
    override val inversePrimary by intPref(md_theme_light_inversePrimary.toArgb())
    override val inverseSurface by intPref(md_theme_light_inverseSurface.toArgb())
    override val inverseOnSurface by intPref(md_theme_light_inverseOnSurface.toArgb())

    // Specials
    override val error by intPref(md_theme_light_error.toArgb())
    override val onError by intPref(md_theme_light_onError.toArgb())
    override val errorContainer by intPref(md_theme_light_errorContainer.toArgb())
    override val onErrorContainer by intPref(md_theme_light_onErrorContainer.toArgb())
    override val outline by intPref(md_theme_light_outline.toArgb())
    override val outlineVariant by intPref(md_theme_light_outlineVariant.toArgb())
    override val scrim by intPref(md_theme_light_scrim.toArgb())

    override fun settings() = settings
}