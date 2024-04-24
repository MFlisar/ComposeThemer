package com.michaelflisar.composecustomtheme.demo.classes

import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.themes.themes.ThemeBlueDelight
import com.michaelflisar.kotpreferences.core.SettingsModel
import com.michaelflisar.kotpreferences.datastore.DataStoreStorage

object DemoPrefs : SettingsModel(DataStoreStorage(name = "demo_prefs")) {
    val themeKey by stringPref(ThemeBlueDelight.KEY)
    val baseTheme by enumPref(ComposeTheme.BaseTheme.System)
    val dynamic by boolPref(false)
}