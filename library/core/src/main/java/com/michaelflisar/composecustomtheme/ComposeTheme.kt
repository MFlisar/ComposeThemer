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

    fun register(vararg theme: Theme) {
        theme.forEach { it ->
            if (themes.containsKey(it.key))
                throw RuntimeException("Key '${it.key}' was provided multiple times! Please provide unique keys for your themes!")
            themes[it.key] = it
        }

    }

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

    data class Theme(
        val key: String,
        val colorSchemeLight: ColorScheme = lightColorScheme(),
        val colorSchemeDark: ColorScheme = darkColorScheme(),
        val statusBarColor: SystemUIColor = SystemUIColor.Default,
        val navigationBarColor: SystemUIColor = SystemUIColor.Default
    )

    sealed class SystemUIColor {
        data object Default : SystemUIColor()
        data object Primary : SystemUIColor()
        data object Surface : SystemUIColor()
        class Manual(val color: Color, val isDark: Boolean) : SystemUIColor()
    }

    class State(
        val base: androidx.compose.runtime.State<BaseTheme>,
        val dynamic: androidx.compose.runtime.State<Boolean>,
        val theme: androidx.compose.runtime.State<String>
    )

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