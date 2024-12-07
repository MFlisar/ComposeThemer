package com.michaelflisar.composethemer

import android.content.res.Configuration
import android.content.res.Resources
import androidx.activity.SystemBarStyle
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

fun SystemBarStyle.Companion.transparent(
    detectDarkMode: (Resources) -> Boolean = { resources ->
        (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) ==
                Configuration.UI_MODE_NIGHT_YES
    }
): SystemBarStyle = auto(
    android.graphics.Color.TRANSPARENT,
    android.graphics.Color.TRANSPARENT,
    detectDarkMode
)

fun SystemBarStyle.Companion.statusBar(
    detectDarkMode: (Resources) -> Boolean = { resources ->
        (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) ==
                Configuration.UI_MODE_NIGHT_YES
    }
): SystemBarStyle = transparent(detectDarkMode)

// copied from EdgeToEdge!
private val DefaultLightScrimColor = Color(0xe6, 0xFF, 0xFF, 0xFF)
private val DefaultLightScrim = DefaultLightScrimColor.toArgb()
private val DefaultDarkScrimColor = Color(0x80, 0x1b, 0x1b, 0x1b)
private val DefaultDarkScrim = DefaultDarkScrimColor.toArgb()

fun SystemBarStyle.Companion.defaultScrim(
    resources: Resources,
    darkMode: Boolean = (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
): Color {
    return if (darkMode) DefaultDarkScrimColor else DefaultLightScrimColor
}

fun SystemBarStyle.Companion.navigationBar(
    detectDarkMode: (Resources) -> Boolean = { resources ->
        (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) ==
                Configuration.UI_MODE_NIGHT_YES
    }
): SystemBarStyle = auto(DefaultLightScrim, DefaultDarkScrim, detectDarkMode)