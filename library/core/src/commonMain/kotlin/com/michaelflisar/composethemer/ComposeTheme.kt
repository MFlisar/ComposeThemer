package com.michaelflisar.composethemer

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb

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
        return if (themes.containsKey(key)) themes[key]!! else DEFAULT_THEME
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
}