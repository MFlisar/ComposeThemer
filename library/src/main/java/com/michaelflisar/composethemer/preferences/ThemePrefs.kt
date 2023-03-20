package com.michaelflisar.composethemer.preferences

import com.michaelflisar.composethemer.Theme
import com.michaelflisar.materialpreferences.core.SettingsModel
import com.michaelflisar.materialpreferences.datastore.DataStoreStorage

object ThemePrefs : SettingsModel(DataStoreStorage(name = "compose_themer_common")) {
    val theme by enumPref(Theme.System)
    val dynamicTheme by boolPref(false)
}