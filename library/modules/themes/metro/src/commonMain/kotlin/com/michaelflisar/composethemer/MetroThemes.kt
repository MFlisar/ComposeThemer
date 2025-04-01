package com.michaelflisar.composethemer

import com.michaelflisar.composethemer.themes.MetroThemeGreen
import com.michaelflisar.composethemer.themes.MetroThemeLime

object MetroThemes {

    const val GROUP_NAME = "Metro Themes"

    private const val KEY_PREFIX = "metro"

    internal fun getKey(name: String): String {
        return "${KEY_PREFIX}_${name.replace(" ", "_").lowercase()}"
    }

    val ALL_GROUPS = listOf(
        MetroThemeLime,
        MetroThemeGreen
    )

    val ALL = ALL_GROUPS.map { it.themes }.flatten()
}