package com.michaelflisar.composethemer

import android.app.Activity
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/**
 * a collection of useful functions
 */
object SystemUIUtil {

    /**
     * updates the statusbar to be transparent and enables edge to edge
     * preparation so that the theme can apply its colors correctly
     */
    internal fun enableEdgeToEdge(
        activity: ComponentActivity,
        themeState: ComposeTheme.State,
        colorScheme: ColorScheme,
        isSystemInDarkTheme: Boolean
    ) {
        val composeTheme = themeState.composeTheme

        val darkStatusBar = getColor(composeTheme.statusBarColor, colorScheme, colorScheme.primary).luminance() < .5f
        val darkNavigationBar = getColor(composeTheme.navigationBarColor, colorScheme, colorScheme.background).luminance() < .5f

        activity.enableEdgeToEdge(
            statusBarStyle = if (darkStatusBar) {
                SystemBarStyle.dark(android.graphics.Color.TRANSPARENT)
            } else SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT
            ),
            navigationBarStyle = if (darkNavigationBar) {
                SystemBarStyle.dark( android.graphics.Color.TRANSPARENT)
            } else SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT
            )
        )
    }

    /**
     * updates the statusbar color
     *
     * @param color the color for the statusbar
     * @param isDark defined if the color is a dark color (and needs a light foreground) or not
     */
    @Composable
    fun updateStatusbar(
        color: Color,
        isDark: Boolean = color.luminance() < .5f
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            setStatusbarTheme(view, color, isDark)
        }
    }

    /**
     * updates the navigation bar color
     *
     * @param color the color for the navigation bar
     * @param isDark defined if the color is a dark color (and needs a light foreground) or not
     */
    @Composable
    fun updateNavigation(
        color: Color,
        isDark: Boolean = color.luminance() < .5f
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            setNavigationTheme(view, color, isDark)
        }
    }

    @Composable
    internal fun UpdateStatusbar(
        systemUIColor: ComposeTheme.SystemUIColor,
        colorScheme: ColorScheme
    ) {
        UpdateColors(systemUIColor, colorScheme, colorScheme.primary, SystemUIUtil::setStatusbarTheme)
    }

    @Composable
    internal fun UpdateNavigation(
        systemUIColor: ComposeTheme.SystemUIColor,
        colorScheme: ColorScheme
    ) {
        UpdateColors(systemUIColor, colorScheme, colorScheme.background, SystemUIUtil::setNavigationTheme)
    }

    @Composable
    private fun UpdateColors(
        systemUIColor: ComposeTheme.SystemUIColor,
        colorScheme: ColorScheme,
        defaultColor: Color,
        function: (view: View, color: Color, lightForeground: Boolean) -> Unit
    ) {
        val view = LocalView.current
        val color = getColor(systemUIColor, colorScheme, defaultColor)
        val isDark = color.luminance() < .5f
        SideEffect {
            function(view, color, isDark)
        }
    }

    private fun getColor(
        systemUIColor: ComposeTheme.SystemUIColor,
        colorScheme: ColorScheme,
        defaultColor: Color
    ): Color {
        return when (systemUIColor) {
            ComposeTheme.SystemUIColor.Primary -> colorScheme.primary
            ComposeTheme.SystemUIColor.Surface -> colorScheme.surface
            ComposeTheme.SystemUIColor.Default -> defaultColor
            is ComposeTheme.SystemUIColor.Manual -> systemUIColor.color
        }
    }

    private fun setStatusbarTheme(
        view: View,
        color: Color,
        isDark: Boolean
    ) {
        val activity = view.context as Activity
        activity.window.statusBarColor = color.toArgb()
        WindowCompat.getInsetsController(activity.window, view).isAppearanceLightStatusBars =
            !isDark
    }

    private fun setNavigationTheme(
        view: View,
        color: Color,
        isDark: Boolean
    ) {
        val activity = view.context as Activity
        activity.window.navigationBarColor = color.toArgb()
        WindowCompat.getInsetsController(activity.window, view).isAppearanceLightNavigationBars =
            !isDark
    }
}