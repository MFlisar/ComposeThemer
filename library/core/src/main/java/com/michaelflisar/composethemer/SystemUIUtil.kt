package com.michaelflisar.composethemer

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
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
internal object SystemUIUtil {

/*
    fun setStatusbarTheme(
        view: View,
        color: Color,
        isDark: Boolean,
        isStatusBarContrastEnforced: Boolean
    ) {
        val activity = view.context as Activity
        activity.window.statusBarColor = color.toArgb()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            activity.window.isStatusBarContrastEnforced = isStatusBarContrastEnforced
        }
        WindowCompat.getInsetsController(activity.window, view).isAppearanceLightStatusBars = !isDark
    }

    fun setNavigationTheme(
        view: View,
        color: Color,
        isDark: Boolean,
        isNavigationBarContrastEnforced: Boolean
    ) {
        val activity = view.context as Activity
        activity.window.navigationBarColor = color.toArgb()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            activity.window.isNavigationBarContrastEnforced = isNavigationBarContrastEnforced
        }
        WindowCompat.getInsetsController(activity.window, view).isAppearanceLightNavigationBars = !isDark
    }*/
}