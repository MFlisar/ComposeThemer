package com.michaelflisar.composethemer

import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import com.michaelflisar.composethemer.ComposeTheme.enableEdgeToEdge

object ComposeTheme {

    private val themes = mutableMapOf<String, Theme>()

    private val DEFAULT_THEME = Theme("")

    /**
     * register a theme so that [ComposeThemer] can find it by its key
     */
    fun register(vararg theme: Theme) {
        theme.forEach { it ->
            if (themes.containsKey(it.key))
                throw RuntimeException("Key '${it.key}' was provided multiple times! Please provide unique keys for your themes!")
            themes[it.key] = it
        }

    }

    /**
     * get a list of all registered themes
     */
    fun getRegisteredThemes() = themes.map { it.value }

    internal fun find(key: String): Theme {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            themes.getOrDefault(key, DEFAULT_THEME)
        } else {
            if (themes.containsKey(key))
                themes[key]!!
            else DEFAULT_THEME
        }
    }

    /**
     * base theme class
     *
     * @param key a unique key to identify this theme
     * @param colorSchemeLight the light color scheme
     * @param colorSchemeDark the dark color scheme
     */
    data class Theme(
        val key: String,
        val colorSchemeLight: ColorScheme = lightColorScheme(),
        val colorSchemeDark: ColorScheme = darkColorScheme()
    )

    /**
     * the current state of the theme
     *
     * @param base the [BaseTheme]
     * @param dynamic if true, the dynamic color theme is applied
     * @param theme the key of the theme that currently should be applied
     */
    class State(
        val base: androidx.compose.runtime.State<BaseTheme>,
        val dynamic: androidx.compose.runtime.State<Boolean>,
        val theme: androidx.compose.runtime.State<String>
    ) {
        val composeTheme: Theme
            get() = find(theme.value)
    }

    /**
     * base theme to define if the dark/light or system derived color theme should be used
     */
    enum class BaseTheme {
        Dark,
        Light,
        System;

        @Composable
        fun isDark() = when (this) {
            Dark -> true
            Light -> false
            System -> isSystemInDarkTheme()
        }
    }

    /**
     * enabled edgeToEdge and makes the system bars transparent so that the theme can apply its color correctly
     */
    fun enableEdgeToEdge(
        activity: ComponentActivity,
        statusBarColor: Color,
        navigationBarColor: Color,
        isStatusBarContrastEnforced: Boolean? = null,
        isNavigationBarContrastEnforced: Boolean? = null
    ) {
        enableEdgeToEdge(
            activity = activity,
            statusBarStyle = SystemBarStyle.statusBar { statusBarColor.luminance() < .5f },
            navigationBarStyle = SystemBarStyle.navigationBar { navigationBarColor.luminance() < .5f },
            isStatusBarContrastEnforced,
            isNavigationBarContrastEnforced
        )
    }

    /**
     * enabled edgeToEdge and makes the system bars transparent so that the theme can apply its color correctly
     */
    fun enableEdgeToEdge(
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
    /**
     * updates the statusbar color
     *
     * @param color the color for the statusbar
     * @param isDark defined if the color is a dark color (and needs a light foreground) or not
     */
    @Composable
    fun UpdateStatusbar(
        color: Color,
        isStatusBarContrastEnforced: Boolean = true,
        isDark: Boolean = color.luminance() < .5f
    ) {
        val view = LocalView.current
        SideEffect {
            SystemUIUtil.setStatusbarTheme(view, color, isDark, isStatusBarContrastEnforced)
        }
    }

    /**
     * updates the navigation bar color
     *
     * @param color the color for the navigation bar
     * @param isNavigationBarContrastEnforced defined if the contrast is enforced or not
     * @param isDark defined if the color is a dark color (and needs a light foreground) or not
     */
    @Composable
    fun UpdateNavigation(
        color: Color,
        isNavigationBarContrastEnforced: Boolean = true,
        isDark: Boolean = color.luminance() < .5f
    ) {
        val view = LocalView.current
        SideEffect {
            SystemUIUtil.setNavigationTheme(view, color, isDark, isNavigationBarContrastEnforced)
        }
    }*/
}

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

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = shapes,
        typography = typography,
        content = content
    )
}