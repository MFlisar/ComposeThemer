package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Mango Mojito"
 */
object ThemeMangoMojito {

    const val KEY = "Mango Mojito"
    
    fun get() = ComposeTheme.Theme(
        key = KEY,
        colorSchemeLight = Light,
        colorSchemeDark = Dark
    )

    private val Light = lightColorScheme(

        primary = Color(0xffc78d20),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffdeb059),
        onPrimaryContainer = Color(0xff120f08),
        secondary = Color(0xff616247),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffbcbca8),
        onSecondaryContainer = Color(0xff10100e),
        tertiary = Color(0xff8d9440),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffbfc39b),
        onTertiaryContainer = Color(0xff10100d),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfffdfbf8),
        onBackground = Color(0xff090909),
        surface = Color(0xfffdfbf8),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffebe8e2),
        onSurfaceVariant = Color(0xff121211),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff151411),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xfffff8b9),
        surfaceTint = Color(0xffc78d20),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffdeb059),
        onPrimary = Color(0xff14110a),
        primaryContainer = Color(0xffc78d20),
        onPrimaryContainer = Color(0xfffff5e4),
        secondary = Color(0xff81816c),
        onSecondary = Color(0xfff9f9f7),
        secondaryContainer = Color(0xff5a5a35),
        onSecondaryContainer = Color(0xffedede8),
        tertiary = Color(0xffafb479),
        onTertiary = Color(0xff11120d),
        tertiaryContainer = Color(0xff82883d),
        onTertiaryContainer = Color(0xfff4f5e9),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff1b1914),
        onBackground = Color(0xffedecec),
        surface = Color(0xff1b1914),
        onSurface = Color(0xffedecec),
        surfaceVariant = Color(0xff433e35),
        onSurfaceVariant = Color(0xffe1e0df),
        outline = Color(0xff7d7676),
        outlineVariant = Color(0xff2e2c2c),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffdfaf6),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff6e5a34),
        surfaceTint = Color(0xffdeb059),
    )

}