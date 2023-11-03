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

internal object SystemUIUtil {

    @Composable
    fun UpdateStatusbar(
        systemUIColor: ComposeTheme.SystemUIColor,
        colorScheme: ColorScheme
    ) {
        UpdateColors(systemUIColor, colorScheme, SystemUIUtil::setStatusbarTheme)
    }

    @Composable
    fun UpdateNavigation(
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
        var lightForeground = false

        when (systemUIColor) {
            ComposeTheme.SystemUIColor.Primary -> {
                color = colorScheme.primary
                lightForeground = color.luminance() > .5f
            }
            ComposeTheme.SystemUIColor.Surface -> {
                color = colorScheme.surface
                lightForeground = color.luminance() > .5f
            }
            ComposeTheme.SystemUIColor.Default -> {
                // TODO: reset?? how??
            }

            is ComposeTheme.SystemUIColor.Manual -> {
                color = systemUIColor.color
                lightForeground = systemUIColor.lightForeground
            }
        }

        if (color != null) {
            SideEffect {
                function(view, color, lightForeground)
            }
        }
    }

    private fun setStatusbarTheme(
        view: View,
        color: Color,
        lightForeground: Boolean
    ) {
        val activity = view.context as Activity
        activity.window.statusBarColor = color.toArgb()
        WindowCompat.getInsetsController(activity.window, view).isAppearanceLightStatusBars =
            lightForeground
    }

    private fun setNavigationTheme(
        view: View,
        color: Color,
        lightForeground: Boolean
    ) {
        val activity = view.context as Activity
        activity.window.navigationBarColor = color.toArgb()
        WindowCompat.getInsetsController(activity.window, view).isAppearanceLightNavigationBars =
            lightForeground
    }
}