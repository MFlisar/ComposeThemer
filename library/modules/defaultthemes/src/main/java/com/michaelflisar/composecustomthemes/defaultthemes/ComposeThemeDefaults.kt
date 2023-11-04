package com.michaelflisar.composecustomthemes.defaultthemes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.michaelflisar.composecustomtheme.ComposeTheme
import com.michaelflisar.composecustomthemes.defaultthemes.themes.ComposeThemeAmber
import com.michaelflisar.composecustomthemes.defaultthemes.themes.ComposeThemeBlue
import com.michaelflisar.composecustomthemes.defaultthemes.themes.ComposeThemeBrown
import com.michaelflisar.composecustomthemes.defaultthemes.themes.ComposeThemeCyan
import com.michaelflisar.composecustomthemes.defaultthemes.themes.ComposeThemeDeepOrange
import com.michaelflisar.composecustomthemes.defaultthemes.themes.ComposeThemeDeepPurple
import com.michaelflisar.composecustomthemes.defaultthemes.themes.ComposeThemeGreen
import com.michaelflisar.composecustomthemes.defaultthemes.themes.ComposeThemeIndigo
import com.michaelflisar.composecustomthemes.defaultthemes.themes.ComposeThemeLightBlue
import com.michaelflisar.composecustomthemes.defaultthemes.themes.ComposeThemeLightGreen
import com.michaelflisar.composecustomthemes.defaultthemes.themes.ComposeThemeLime
import com.michaelflisar.composecustomthemes.defaultthemes.themes.ComposeThemeOrange
import com.michaelflisar.composecustomthemes.defaultthemes.themes.ComposeThemePink
import com.michaelflisar.composecustomthemes.defaultthemes.themes.ComposeThemePurple
import com.michaelflisar.composecustomthemes.defaultthemes.themes.ComposeThemeRed
import com.michaelflisar.composecustomthemes.defaultthemes.themes.ComposeThemeTeal
import com.michaelflisar.composecustomthemes.defaultthemes.themes.ComposeThemeYellow

object ComposeThemeDefaults {

    fun getAllThemes(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = listOf(
        defaultTheme(statusBarColor, navigationBarColor),
        amberTheme(statusBarColor, navigationBarColor),
        blueTheme(statusBarColor, navigationBarColor),
        brownTheme(statusBarColor, navigationBarColor),
        cyanTheme(statusBarColor, navigationBarColor),
        deepOrangeTheme(statusBarColor, navigationBarColor),
        deepPurpleTheme(statusBarColor, navigationBarColor),
        greenTheme(statusBarColor, navigationBarColor),
        indigoTheme(statusBarColor, navigationBarColor),
        lightBlueTheme(statusBarColor, navigationBarColor),
        lightGreenTheme(statusBarColor, navigationBarColor),
        limeTheme(statusBarColor, navigationBarColor),
        orangeTheme(statusBarColor, navigationBarColor),
        pinkTheme(statusBarColor, navigationBarColor),
        purpleTheme(statusBarColor, navigationBarColor),
        redTheme(statusBarColor, navigationBarColor),
        tealTheme(statusBarColor, navigationBarColor),
        yellowTheme(statusBarColor, navigationBarColor)
    )

    fun defaultTheme(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default,
        key: String = "default"
    ) = ComposeTheme.Theme(
        key = key,
        colorSchemeLight = lightColorScheme(),
        colorSchemeDark = darkColorScheme(),
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    fun amberTheme(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default,
        key: String = "amber"
    ) = ComposeTheme.Theme(
        key = key,
        colorSchemeLight = ComposeThemeAmber.LightColors,
        colorSchemeDark = ComposeThemeAmber.DarkColors,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    fun blueTheme(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default,
        key: String = "blue"
    ) = ComposeTheme.Theme(
        key = key,
        colorSchemeLight = ComposeThemeBlue.LightColors,
        colorSchemeDark = ComposeThemeBlue.DarkColors,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    fun brownTheme(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default,
        key: String = "brown"
    ) = ComposeTheme.Theme(
        key = key,
        colorSchemeLight = ComposeThemeBrown.LightColors,
        colorSchemeDark = ComposeThemeBrown.DarkColors,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    fun cyanTheme(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default,
        key: String = "cyan"
    ) = ComposeTheme.Theme(
        key = key,
        colorSchemeLight = ComposeThemeCyan.LightColors,
        colorSchemeDark = ComposeThemeCyan.DarkColors,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    fun deepOrangeTheme(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default,
        key: String = "deepOrange"
    ) = ComposeTheme.Theme(
        key = key,
        colorSchemeLight = ComposeThemeDeepOrange.LightColors,
        colorSchemeDark = ComposeThemeDeepOrange.DarkColors,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    fun deepPurpleTheme(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default,
        key: String = "deepPurple"
    ) = ComposeTheme.Theme(
        key = key,
        colorSchemeLight = ComposeThemeDeepPurple.LightColors,
        colorSchemeDark = ComposeThemeDeepPurple.DarkColors,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    fun greenTheme(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default,
        key: String = "green"
    ) = ComposeTheme.Theme(
        key = key,
        colorSchemeLight = ComposeThemeGreen.LightColors,
        colorSchemeDark = ComposeThemeGreen.DarkColors,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    fun indigoTheme(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default,
        key: String = "indigo"
    ) = ComposeTheme.Theme(
        key = key,
        colorSchemeLight = ComposeThemeIndigo.LightColors,
        colorSchemeDark = ComposeThemeIndigo.DarkColors,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    fun lightBlueTheme(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default,
        key: String = "lightBlue"
    ) = ComposeTheme.Theme(
        key = key,
        colorSchemeLight = ComposeThemeLightBlue.LightColors,
        colorSchemeDark = ComposeThemeLightBlue.DarkColors,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    fun lightGreenTheme(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default,
        key: String = "lightGreen"
    ) = ComposeTheme.Theme(
        key = key,
        colorSchemeLight = ComposeThemeLightGreen.LightColors,
        colorSchemeDark = ComposeThemeLightGreen.DarkColors,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    fun limeTheme(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default,
        key: String = "lime"
    ) = ComposeTheme.Theme(
        key = key,
        colorSchemeLight = ComposeThemeLime.LightColors,
        colorSchemeDark = ComposeThemeLime.DarkColors,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    fun orangeTheme(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default,
        key: String = "orange"
    ) = ComposeTheme.Theme(
        key = key,
        colorSchemeLight = ComposeThemeOrange.LightColors,
        colorSchemeDark = ComposeThemeOrange.DarkColors,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    fun pinkTheme(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default,
        key: String = "pink"
    ) = ComposeTheme.Theme(
        key = key,
        colorSchemeLight = ComposeThemePink.LightColors,
        colorSchemeDark = ComposeThemePink.DarkColors,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    fun purpleTheme(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default,
        key: String = "purple"
    ) = ComposeTheme.Theme(
        key = key,
        colorSchemeLight = ComposeThemePurple.LightColors,
        colorSchemeDark = ComposeThemePurple.DarkColors,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    fun redTheme(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default,
        key: String = "red"
    ) = ComposeTheme.Theme(
        key = key,
        colorSchemeLight = ComposeThemeRed.LightColors,
        colorSchemeDark = ComposeThemeRed.DarkColors,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    fun tealTheme(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default,
        key: String = "teal"
    ) = ComposeTheme.Theme(
        key = key,
        colorSchemeLight = ComposeThemeTeal.LightColors,
        colorSchemeDark = ComposeThemeTeal.DarkColors,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    fun yellowTheme(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default,
        key: String = "yellow"
    ) = ComposeTheme.Theme(
        key = key,
        colorSchemeLight = ComposeThemeYellow.LightColors,
        colorSchemeDark = ComposeThemeYellow.DarkColors,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )
}