package com.michaelflisar.composecustomtheme

import android.os.Build
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView

object ComposeTheme {

    private val themes = mutableMapOf<String, Theme>()

    private val DEFAULT_THEME = Theme("")

    /**
     * register a theme so that [ComposeTheme] can find it by its key
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
     * @param statusBarColor the [SystemUIColor] for the status bar
     * @param navigationBarColor the [SystemUIColor] for the navigation bar
     */
    data class Theme(
        val key: String,
        val colorSchemeLight: ColorScheme = lightColorScheme(),
        val colorSchemeDark: ColorScheme = darkColorScheme(),
        val statusBarColor: SystemUIColor = SystemUIColor.Default,
        val navigationBarColor: SystemUIColor = SystemUIColor.Default
    )

    /**
     * the class for system ui color modes
     */
    sealed class SystemUIColor {

        /**
         * this mode won't change the system ui in any way
         */
        data object Default : SystemUIColor()

        /**
         * this mode will set the system ui to the themes primary color
         */
        data object Primary : SystemUIColor()

        /**
         * this mode will set the system ui to the themes surface color
         */
        data object Surface : SystemUIColor()

        /**
         * this mode will set the system ui to a user defined color
         *
         * @param color the color
         * @param isDark defined if the color is dark (and needs a light foreground color) or not
         */
        class Manual(val color: Color, val isDark: Boolean) : SystemUIColor()
    }

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
    )

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
            if (state.base.value.isDark()) dynamicDarkColorScheme(context) else dynamicLightColorScheme(
                context
            )
        }

        state.base.value.isDark() -> theme.colorSchemeDark
        else -> theme.colorSchemeLight
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SystemUIUtil.UpdateStatusbar(
            systemUIColor = theme.statusBarColor,
            colorScheme = colorScheme
        )
        SystemUIUtil.UpdateNavigation(
            systemUIColor = theme.navigationBarColor,
            colorScheme = colorScheme
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = shapes,
        typography = typography,
        content = content
    )
}