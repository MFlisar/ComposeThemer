package com.michaelflisar.composethemer

import android.app.Activity
import android.app.UiModeManager
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ColorScheme
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
import androidx.compose.ui.platform.LocalInspectionMode
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
            if (state.base.value.isDark()) dynamicDarkColorScheme(context) else dynamicLightColorScheme(
                context
            )
        }

        else -> theme.selectSchemeForContrast(state.base.value.isDark(), state.contrast.value)
    }
    val darkTheme = state.base.value.isDark()

    if (!edgeToEdge) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                val window = (view.context as Activity).window
                window.statusBarColor = colorScheme.primary.toArgb()
                WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars =
                    darkTheme
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
    //statusBarOnColor: Color = MaterialTheme.colorScheme.onPrimary,
    statusBarIsDark: () -> Boolean = { statusBarColor.luminance() < .5f },
    navigationBarColor: Color = if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        SystemBarStyle.defaultScrim(activity.resources, themeState.base.value.isDark())
    } else MaterialTheme.colorScheme.background,
    isNavigationBarContrastEnforced: Boolean = LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE
) {
    // Portrait: Statusbar is Primary, Navigation is Background
    // Landscape: Navigation has enforced contrast + default scrim
    LaunchedEffect(
        themeState,
        statusBarColor,
        navigationBarColor,
        isNavigationBarContrastEnforced
    ) {
        ComposeTheme.enableEdgeToEdge(
            activity,
            statusBarColor = statusBarColor,
            statusBarIsDark = statusBarIsDark,
            navigationBarColor = navigationBarColor,
            isNavigationBarContrastEnforced = isNavigationBarContrastEnforced
        )
    }
}

fun isContrastAvailable(): Boolean {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE
}

@Composable
private fun ComposeTheme.Theme<*>.selectSchemeForContrast(
    isDark: Boolean,
    contrast: ComposeTheme.Contrast
): ColorScheme {

    val context = LocalContext.current
    val colorScheme = if (isDark) darkScheme else lightScheme
    val isPreview = LocalInspectionMode.current

    // TODO(b/336693596): UIModeManager is not yet supported in preview
    if (!isPreview) {
        val baseContrast = when (contrast) {
            ComposeTheme.Contrast.System -> {
                if (isContrastAvailable()) {
                    val uiModeManager =
                        context.getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
                    val contrastLevel = uiModeManager.contrast
                    when (contrastLevel) {
                        in 0.0f..0.33f -> ComposeTheme.BaseContrast.Normal
                        in 0.34f..0.66f -> ComposeTheme.BaseContrast.Medium
                        in 0.67f..1.0f -> ComposeTheme.BaseContrast.High
                        else -> ComposeTheme.BaseContrast.Normal
                    }
                } else {
                    ComposeTheme.BaseContrast.Normal
                }
            }

            ComposeTheme.Contrast.Normal -> ComposeTheme.BaseContrast.Normal
            ComposeTheme.Contrast.Medium -> ComposeTheme.BaseContrast.Medium
            ComposeTheme.Contrast.High -> ComposeTheme.BaseContrast.High
        }

        return getScheme(isDark, baseContrast)

    } else return colorScheme
}
