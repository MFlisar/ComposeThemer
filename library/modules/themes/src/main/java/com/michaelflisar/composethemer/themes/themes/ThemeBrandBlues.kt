package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Brand Blues"
 */
object ThemeBrandBlues {

    const val KEY = "Brand Blues"
    
    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = KEY,
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff3b5998),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffa8cae6),
        onPrimaryContainer = Color(0xff0e1113),
        secondary = Color(0xff55acee),
        onSecondary = Color(0xff000000),
        secondaryContainer = Color(0xffcbe5ff),
        onSecondaryContainer = Color(0xff111314),
        tertiary = Color(0xff4285f4),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffd6e2ff),
        onTertiaryContainer = Color(0xff121314),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfff9fafc),
        onBackground = Color(0xff090909),
        surface = Color(0xfff9fafc),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe4e5e9),
        onSurfaceVariant = Color(0xff111112),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff121214),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffd3e1ff),
        surfaceTint = Color(0xff3b5998),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff8b9dc3),
        onPrimary = Color(0xfff9fbfe),
        primaryContainer = Color(0xff3b5998),
        onPrimaryContainer = Color(0xffe9edf7),
        secondary = Color(0xffa0d1f5),
        onSecondary = Color(0xff101414),
        secondaryContainer = Color(0xff004b75),
        onSecondaryContainer = Color(0xffdfebf2),
        tertiary = Color(0xff88b2f8),
        onTertiary = Color(0xff0e1114),
        tertiaryContainer = Color(0xff004397),
        onTertiaryContainer = Color(0xffdfeaf7),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff17181a),
        onBackground = Color(0xffececed),
        surface = Color(0xff17181a),
        onSurface = Color(0xffececed),
        surfaceVariant = Color(0xff3b3c40),
        onSurfaceVariant = Color(0xffe0e0e1),
        outline = Color(0xff76767d),
        outlineVariant = Color(0xff2c2c2e),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff9fafb),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff4a5262),
        surfaceTint = Color(0xff8b9dc3),
    )

}