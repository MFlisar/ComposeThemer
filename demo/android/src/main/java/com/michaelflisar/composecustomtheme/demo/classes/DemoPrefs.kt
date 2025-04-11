package com.michaelflisar.composecustomtheme.demo.classes

import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.themes.ThemeFlatUIEmerald
import com.michaelflisar.kotpreferences.core.SettingsModel
import com.michaelflisar.kotpreferences.core.enumPref
import com.michaelflisar.kotpreferences.storage.datastore.DataStoreStorage
import com.michaelflisar.kotpreferences.storage.datastore.create

object DemoPrefs : SettingsModel(DataStoreStorage.create(name = "demo_prefs")) {
    val themeKey by stringPref(ThemeFlatUIEmerald.Tetrade.id)
    val baseTheme by enumPref(ComposeTheme.BaseTheme.System)
    val contrast by enumPref(ComposeTheme.Contrast.System)
    val dynamic by boolPref(false)
}