package com.michaelflisar.composecustomtheme

import android.app.Activity
import android.view.View
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
        UpdateColors(systemUIColor, colorScheme, SystemUIUtil::setStatusbarTheme)
    }

    @Composable
    internal fun UpdateNavigation(
        systemUIColor: ComposeTheme.SystemUIColor,
        colorScheme: ColorScheme
    ) {
        UpdateColors(systemUIColor, colorScheme, SystemUIUtil::setNavigationTheme)
    }

    @Composable
    private fun UpdateColors(
        systemUIColor: ComposeTheme.SystemUIColor,
        colorScheme: ColorScheme,
        function: (view: View, color: Color, lightForeground: Boolean) -> Unit
    ) {
        val view = LocalView.current

        var color: Color? = null
        var isDark = false

        when (systemUIColor) {
            ComposeTheme.SystemUIColor.Primary -> {
                color = colorScheme.primary
                isDark = color.luminance() < .5f
            }

            ComposeTheme.SystemUIColor.Surface -> {
                color = colorScheme.surface
                isDark = color.luminance() < .5f
            }

            ComposeTheme.SystemUIColor.Default -> {
                // TODO: reset?? how??
            }

            is ComposeTheme.SystemUIColor.Manual -> {
                color = systemUIColor.color
                isDark = systemUIColor.isDark
            }
        }

        if (color != null) {
            SideEffect {
                function(view, color, isDark)
            }
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