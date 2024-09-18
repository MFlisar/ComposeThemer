package com.michaelflisar.composethemer

import android.app.Activity
import android.content.res.Configuration
import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/**
 * this is the main composable that simple applies the correct theme
 * and also updates the system ui if necessary
 *
 * @param state the composable state that holds the currently selected theme data
 * @param shapes the shapes for [MaterialTheme]
 * @param typography the typography for [MaterialTheme]
 * @param content the content
 */
@Composable
fun ComposeTheme(
    state: ComposeTheme.State,
    shapes: Shapes = MaterialTheme.shapes,
    typography: Typography = MaterialTheme.typography,
    edgeToEdge: Boolean = true,
    content: @Composable () -> Unit
) {
    val theme = ComposeTheme.find(state.theme.value)
    val colorScheme = when {
        state.dynamic.value && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (state.base.value.isDark()) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        state.base.value.isDark() -> theme.colorSchemeDark
        else -> theme.colorSchemeLight
    }
    val darkTheme = state.base.value.isDark()

    if (!edgeToEdge) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                val window = (view.context as Activity).window
                window.statusBarColor = colorScheme.primary.toArgb()
                WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = shapes,
        typography = typography,
        content = content
    )
}

/**
 * enabled edgeToEdge and makes the system bars transparent so that the theme can apply its color correctly
 */
fun ComposeTheme.enableEdgeToEdge(
    activity: ComponentActivity,
    statusBarColor: Color,
    navigationBarColor: Color,
    statusBarIsDark: () -> Boolean = { statusBarColor.luminance() < .5f },
    navigationBarIsDark: () -> Boolean = { navigationBarColor.luminance() < .5f },
    isStatusBarContrastEnforced: Boolean? = null,
    isNavigationBarContrastEnforced: Boolean? = null
) {
    enableEdgeToEdge(
        activity = activity,
        statusBarStyle = SystemBarStyle.statusBar { statusBarIsDark() },
        navigationBarStyle = SystemBarStyle.navigationBar { navigationBarIsDark() },
        isStatusBarContrastEnforced,
        isNavigationBarContrastEnforced
    )
}

/**
 * enabled edgeToEdge and makes the system bars transparent so that the theme can apply its color correctly
 */
fun ComposeTheme.enableEdgeToEdge(
    activity: ComponentActivity,
    statusBarStyle: SystemBarStyle = SystemBarStyle.statusBar(),
    navigationBarStyle: SystemBarStyle = SystemBarStyle.navigationBar(),
    isStatusBarContrastEnforced: Boolean? = null,
    isNavigationBarContrastEnforced: Boolean? = null
) {
    activity.enableEdgeToEdge(
        statusBarStyle,
        navigationBarStyle
    )
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        if (isStatusBarContrastEnforced != null)
            activity.window.isStatusBarContrastEnforced = isStatusBarContrastEnforced
        if (isNavigationBarContrastEnforced != null)
            activity.window.isNavigationBarContrastEnforced = isNavigationBarContrastEnforced
    }
}

/*
 * helper function to update the edge-to-edge mode
 *
 * default activity has a primary colored top bar
 *
 * this function assumes that the top bar is on top always
 *
 * PORTRAIT:
 *  => statusbar: expects primary color background
 *  => navigationbar: expects background color background
 *      + no scriom
 * LANDSCAPE:
 *  => statusbar: expects primary color background
 *  => navigationbar: expects background color background
 *      + scrim
 */
@Composable
fun UpdateEdgeToEdgeDefault(
    activity: ComponentActivity,
    themeState: ComposeTheme.State,
    statusBarColor: Color = MaterialTheme.colorScheme.primary,
    statusBarOnColor: Color = MaterialTheme.colorScheme.onPrimary,
    statusBarIsDark: () -> Boolean = { statusBarOnColor.luminance() > .5f },
    navigationBarColor: Color = if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        SystemBarStyle.defaultScrim(activity.resources)
    } else MaterialTheme.colorScheme.background,
    isNavigationBarContrastEnforced: Boolean = LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE
) {
    // Portrait: Statusbar is Primary, Navigation is Background
    // Landscape: Navigation has enforced contrast + default scrim
    LaunchedEffect(themeState) {
        ComposeTheme.enableEdgeToEdge(
            activity,
            statusBarColor = statusBarColor,
            statusBarIsDark = statusBarIsDark,
            navigationBarColor = navigationBarColor,
            isNavigationBarContrastEnforced = isNavigationBarContrastEnforced
        )
    }
}