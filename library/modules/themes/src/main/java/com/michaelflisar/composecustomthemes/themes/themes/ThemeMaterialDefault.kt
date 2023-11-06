package com.michaelflisar.composecustomthemes.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composecustomtheme.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Material Default"
 */
object ThemeMaterialDefault {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Material Default",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff6200ee),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffbb86fc),
        onPrimaryContainer = Color(0xff100c14),
        secondary = Color(0xff018786),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffa4f1ef),
        onSecondaryContainer = Color(0xff0e1414),
        tertiary = Color(0xff03dac6),
        onTertiary = Color(0xff000000),
        tertiaryContainer = Color(0xffcefaf8),
        onTertiaryContainer = Color(0xff111414),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfffaf8fe),
        onBackground = Color(0xff090909),
        surface = Color(0xfffaf8fe),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe6e0ee),
        onSurfaceVariant = Color(0xff121112),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff131017),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffda99ff),
        surfaceTint = Color(0xff6200ee),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffbb86fc),
        onPrimary = Color(0xff120e14),
        primaryContainer = Color(0xff6200ee),
        onPrimaryContainer = Color(0xffefdfff),
        secondary = Color(0xff03dac6),
        onSecondary = Color(0xff041413),
        secondaryContainer = Color(0xff003e3e),
        onSecondaryContainer = Color(0xffdfe9e9),
        tertiary = Color(0xff03dac6),
        onTertiary = Color(0xff041413),
        tertiaryContainer = Color(0xff005047),
        onTertiaryContainer = Color(0xffdfecea),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff19161c),
        onBackground = Color(0xffececed),
        surface = Color(0xff19161c),
        onSurface = Color(0xffececed),
        surfaceVariant = Color(0xff3f3a46),
        onSurfaceVariant = Color(0xffe0e0e1),
        outline = Color(0xff76767d),
        outlineVariant = Color(0xff2c2c2e),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffbf8fe),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff5f4876),
        surfaceTint = Color(0xffbb86fc),
    )

}