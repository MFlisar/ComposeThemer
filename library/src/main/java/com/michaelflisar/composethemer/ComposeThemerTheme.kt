package com.michaelflisar.composethemer

import android.os.Build
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.michaelflisar.composethemer.internal.AppTheme
import com.michaelflisar.composethemer.preferences.ThemePrefs
import com.michaelflisar.composethemer.preferences.ThemePrefsDark
import com.michaelflisar.composethemer.preferences.ThemePrefsLight

@Composable
fun ComposeThemerTheme(
    shapes: Shapes = MaterialTheme.shapes,
    typography: Typography = MaterialTheme.typography,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current

    val theme by ThemePrefs.theme.collectAsState()
    val dynamicTheme by ThemePrefs.dynamicTheme.collectAsState()

    val lightThemeColors = AppTheme.create(ThemePrefsLight)
    val darkThemeColors = AppTheme.create(ThemePrefsDark)

    val isDark = theme.isDark()

    val colorScheme by remember(
        theme,
        dynamicTheme,
        lightThemeColors,
        darkThemeColors
    ) {
        derivedStateOf {
            when {
                dynamicTheme && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                    if (isDark) dynamicDarkColorScheme(context) else dynamicLightColorScheme(
                        context
                    )
                }
                isDark -> darkThemeColors.getAsDarkTheme()
                else -> lightThemeColors.getAsLightTheme()
            }
        }
    }

    if (!LocalView.current.isInEditMode) {
        val systemUiController = rememberSystemUiController()
        val color = colorScheme.primary
        val useDarkIcons = colorScheme.onPrimary.luminance() < .5f
        //val useDarkIcons = !isSystemInDarkTheme()
        DisposableEffect(systemUiController, useDarkIcons, color) {
            systemUiController.setStatusBarColor(color = color, darkIcons = useDarkIcons)
            //systemUiController.setNavigationBarColor(color = Color.Transparent, darkIcons = !darkTheme)
            onDispose {}
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = shapes,
        typography = typography,
        content = content
    )
}