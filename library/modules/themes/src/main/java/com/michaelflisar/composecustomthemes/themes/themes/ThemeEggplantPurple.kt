package com.michaelflisar.composecustomthemes.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composecustomtheme.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Eggplant Purple"
 */
object ThemeEggplantPurple {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Eggplant Purple",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff9a25ae),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffffd6fe),
        onPrimaryContainer = Color(0xff141214),
        secondary = Color(0xff8728cf),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xfff2daff),
        onSecondaryContainer = Color(0xff141214),
        tertiary = Color(0xff934932),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffffdbd0),
        onTertiaryContainer = Color(0xff141211),
        error = Color(0xffba1a1a),
        onError = Color(0xffffffff),
        errorContainer = Color(0xffffdad6),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfffcf9fc),
        onBackground = Color(0xff090909),
        surface = Color(0xfffcf9fc),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe9e2ea),
        onSurfaceVariant = Color(0xff121112),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff141115),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffffbeff),
        surfaceTint = Color(0xff9a25ae),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xfff9abff),
        onPrimary = Color(0xff141114),
        primaryContainer = Color(0xff7b008f),
        onPrimaryContainer = Color(0xfff3dff6),
        secondary = Color(0xffe0b6ff),
        onSecondary = Color(0xff141214),
        secondaryContainer = Color(0xff6b00af),
        onSecondaryContainer = Color(0xfff0dffb),
        tertiary = Color(0xffffb59f),
        onTertiary = Color(0xff141210),
        tertiaryContainer = Color(0xff76331d),
        onTertiaryContainer = Color(0xfff2e7e4),
        error = Color(0xffffb4ab),
        onError = Color(0xff141211),
        errorContainer = Color(0xff93000a),
        onErrorContainer = Color(0xfff6dfe1),
        background = Color(0xff1c181d),
        onBackground = Color(0xffedeced),
        surface = Color(0xff1c181d),
        onSurface = Color(0xffedeced),
        surfaceVariant = Color(0xff463e46),
        onSurfaceVariant = Color(0xffe1e0e1),
        outline = Color(0xff7d767d),
        outlineVariant = Color(0xff2e2c2e),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffefaff),
        inverseOnSurface = Color(0xff131314),
        inversePrimary = Color(0xff765877),
        surfaceTint = Color(0xfff9abff),
    )

}