package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Bahama And Trinidad"
 */
object ThemeBahamaAndTrinidad {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Bahama And Trinidad",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff095d9e),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffa6cced),
        onPrimaryContainer = Color(0xff0e1114),
        secondary = Color(0xff7cc8f8),
        onSecondary = Color(0xff000000),
        secondaryContainer = Color(0xffc5e7ff),
        onSecondaryContainer = Color(0xff111314),
        tertiary = Color(0xffdd520f),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffffdbcd),
        onTertiaryContainer = Color(0xff141211),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfff8fafc),
        onBackground = Color(0xff090909),
        surface = Color(0xfff8fafc),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe1e6e9),
        onSurfaceVariant = Color(0xff111212),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff101314),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffa2d8ff),
        surfaceTint = Color(0xff095d9e),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff4585b5),
        onPrimary = Color(0xfff4f9fd),
        primaryContainer = Color(0xff095d9e),
        onPrimaryContainer = Color(0xffe1eef8),
        secondary = Color(0xff9cd5f9),
        onSecondary = Color(0xff101414),
        secondaryContainer = Color(0xff3a7292),
        onSecondaryContainer = Color(0xffe8f1f6),
        tertiary = Color(0xffe57c4a),
        onTertiary = Color(0xfffff8f4),
        tertiaryContainer = Color(0xffdd520f),
        onTertiaryContainer = Color(0xffffece2),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff131619),
        onBackground = Color(0xffececec),
        surface = Color(0xff131619),
        onSurface = Color(0xffececec),
        surfaceVariant = Color(0xff333a3f),
        onSurfaceVariant = Color(0xffdfe0e0),
        outline = Color(0xff797979),
        outlineVariant = Color(0xff2d2d2d),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff5f8fb),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff2c475c),
        surfaceTint = Color(0xff4585b5),
    )

}