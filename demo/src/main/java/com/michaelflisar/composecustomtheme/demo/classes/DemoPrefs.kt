package com.michaelflisar.composecustomtheme.demo.classes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composecustomtheme.ComposeTheme
import com.michaelflisar.kotpreferences.core.SettingsModel
import com.michaelflisar.kotpreferences.datastore.DataStoreStorage

object DemoPrefs : SettingsModel(DataStoreStorage(name = "demo_prefs")) {
    val themeKey by stringPref("green")
    val baseTheme by enumPref(ComposeTheme.BaseTheme.System)
    val dynamic by boolPref(false)
}