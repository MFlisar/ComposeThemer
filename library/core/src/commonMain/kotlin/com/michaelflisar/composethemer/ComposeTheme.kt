package com.michaelflisar.composethemer

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import com.michaelflisar.composethemer.themes.ThemeDefault

object ComposeTheme {

    private val themes = mutableMapOf<String, Theme<*>>()

    val DEFAULT_GROUPS = listOf(
        ThemeDefault
    )

    val DEFAULT_ALL = DEFAULT_GROUPS.map { it.themes }.flatten()

    /**
     * register a theme so that [ComposeThemer] can find it by its key
     */
    fun register(vararg theme: Theme<*>) {
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
    fun getRegisteredThemeGroups() = themes.map { it.value.group }.distinct()

    internal fun find(key: String): Theme<*> {
        return themes.getOrElse(key) { ThemeDefault.Default }
    }

    interface Group<E : Enum<E>> {
        val name: String
        val themes: List<Theme<E>>

        fun getVariants() = themes.map { it.variant }
        val defaultVariant: E

    }

    /**
     * base theme interface
     *
     * @param key a unique key to identify this theme
     * @param lightScheme the light color scheme
     * @param darkScheme the dark color scheme
     */
    interface Theme<E : Enum<E>> {

        val group: Group<E>
        val variant: E
        val name: String
        val key: String

        val lightScheme: ColorScheme
        val darkScheme: ColorScheme

        val lightSchemeMediumContrast: ColorScheme
        val darkSchemeMediumContrast: ColorScheme
        val lightSchemeHighContrast: ColorScheme
        val darkSchemeHighContrast: ColorScheme

        fun supportsContrast() = lightScheme != lightSchemeMediumContrast

        fun getScheme(isDark: Boolean, contrast: BaseContrast): ColorScheme {
            return if (isDark) {
                when (contrast) {
                    BaseContrast.Normal -> darkScheme
                    BaseContrast.Medium -> darkSchemeMediumContrast
                    BaseContrast.High -> darkSchemeHighContrast
                }
            } else {
                when (contrast) {
                    BaseContrast.Normal -> lightScheme
                    BaseContrast.Medium -> lightSchemeMediumContrast
                    BaseContrast.High -> lightSchemeHighContrast
                }
            }
        }

    }

    /**
     * the current state of the theme
     *
     * @param base the [BaseTheme]
     * @param contrast the [Contrast]
     * @param dynamic if true, the dynamic color theme is applied
     * @param theme the key of the theme that currently should be applied
     */
    class State(
        val base: androidx.compose.runtime.State<BaseTheme>,
        val contrast: androidx.compose.runtime.State<Contrast>,
        val dynamic: androidx.compose.runtime.State<Boolean>,
        val theme: androidx.compose.runtime.State<String>
    ) {
        val composeTheme: Theme<*>
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
     * contrast types (system, normal, medium, high)
     */
    enum class Contrast {
        System,
        Normal,
        Medium,
        High;
    }

    /**
     * contrast types (normal, medium, high)
     */
    enum class BaseContrast {
        Normal,
        Medium,
        High;
    }
}