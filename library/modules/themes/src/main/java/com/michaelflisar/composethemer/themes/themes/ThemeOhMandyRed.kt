package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Oh Mandy Red"
 */
object ThemeOhMandyRed {

    const val KEY = "Oh Mandy Red"
    
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

        primary = Color(0xffcd5758),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffe49797),
        onPrimaryContainer = Color(0xff130d0d),
        secondary = Color(0xff69b9cd),
        onSecondary = Color(0xff000000),
        secondaryContainer = Color(0xffa6edff),
        onSecondaryContainer = Color(0xff0e1414),
        tertiary = Color(0xff57c8d3),
        onTertiary = Color(0xff000000),
        tertiaryContainer = Color(0xff90f2fc),
        onTertiaryContainer = Color(0xff0c1414),
        error = Color(0xff790000),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfff1d8d8),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfffdfafa),
        onBackground = Color(0xff090909),
        surface = Color(0xfffdfafa),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffece5e5),
        onSurfaceVariant = Color(0xff121111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff161212),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xfffff0f0),
        surfaceTint = Color(0xffcd5758),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffda8585),
        onPrimary = Color(0xfffff9f9),
        primaryContainer = Color(0xffc05253),
        onPrimaryContainer = Color(0xfffdecec),
        secondary = Color(0xff85c6d6),
        onSecondary = Color(0xff0e1314),
        secondaryContainer = Color(0xff21859e),
        onSecondaryContainer = Color(0xffe4f4f8),
        tertiary = Color(0xff68cdd7),
        onTertiary = Color(0xff0c1414),
        tertiaryContainer = Color(0xff037481),
        onTertiaryContainer = Color(0xffe0f1f4),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff1b1616),
        onBackground = Color(0xffedecec),
        surface = Color(0xff1b1616),
        onSurface = Color(0xffedecec),
        surfaceVariant = Color(0xff433a3a),
        onSurfaceVariant = Color(0xffe1e0e0),
        outline = Color(0xff7d7676),
        outlineVariant = Color(0xff2e2c2c),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffdf8f8),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff6c4747),
        surfaceTint = Color(0xffda8585),
    )

}