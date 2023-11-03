package com.michaelflisar.composecustomthemes.defaultthemes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composecustomtheme.ComposeTheme

/*
 * color palette examples simple copied from here:
 * https://www.geeksforgeeks.org/android-jetpack-compose-theme-picker-palette/
 */
object ComposeThemeDefaults {

    private val red200 = Color(0XFFEF9A9A)
    private val red500 = Color(0XFFF44336)
    private val red700 = Color(0XFFD32F2F)
    private val pink200 = Color(0XFFF27584)
    private val pink500 = Color(0XFFEF5366)

    private val pink700 = Color(0XFFD74A5B)
    private val purple200 = Color(0XFFCE93D8)
    private val purple500 = Color(0XFF9C27B0)
    private val purple700 = Color(0XFF7B1FA2)

    private val indigo200 = Color(0XFF9FA8DA)
    private val indigo500 = Color(0XFF3F51B5)
    private val indigo700 = Color(0XFF303f9f)
    private val blue200 = Color(0XFF90CAF9)
    private val blue500 = Color(0xFF2195F2)
    private val blue700 = Color(0xFF1976D2)

    private val teal200 = Color(0XFF80DEEA)

    private val green200 = Color(0XFFA5D6A7)
    private val green500 = Color(0XFF4CAF50)
    private val green700 = Color(0XFF388E3C)

    private val yellow200 = Color(0XFFFFF59D)
    private val yellow500 = Color(0XFFFFEB3B)
    private val yellow700 = Color(0XFFFBC02D)

    private val orange200 = Color(0XFFFFCC80)
    private val orange500 = Color(0XFFFF9800)
    private val orange700 = Color(0XFFF57C00)

    private val brown200 = Color(0XFFBCAAA4)
    private val brown500 = Color(0XFF795548)
    private val brown700 = Color(0XFF5D4037)
    private val grey200 = Color(0XFFEEEEEE)
    private val grey500 = Color(0XFF9E9E9E)
    private val grey700 = Color(0XFF616161)

    // dark palettes
    val DarkPinkColorPalette = darkColorScheme(
        primary = pink200,
        secondary = pink500,
        tertiary = teal200,
        background = Color.Black,
        surface = Color.Black,
        onPrimary = Color.Black,
        onTertiary = Color.White,
        onBackground = Color.White,
        onSurface = Color.White,
        error = Color.Red,
    )

    val DarkGreenColorPalette = darkColorScheme(
        primary = green200,
        secondary = green700,
        tertiary = teal200,
        background = Color.Black,
        surface = Color.Black,
        onPrimary = Color.Black,
        onTertiary = Color.White,
        onBackground = Color.White,
        onSurface = Color.White,
        error = Color.Red,
    )

    val DarkPurpleColorPalette = darkColorScheme(
        primary = purple200,
        secondary = purple700,
        tertiary = teal200,
        background = Color.Black,
        surface = Color.Black,
        onPrimary = Color.Black,
        onTertiary = Color.White,
        onBackground = Color.White,
        onSurface = Color.White,
        error = Color.Red,
    )

    val DarkBlueColorPalette = darkColorScheme(
        primary = blue200,
        secondary = blue700,
        tertiary = teal200,
        background = Color.Black,
        surface = Color.Black,
        onPrimary = Color.Black,
        onTertiary = Color.White,
        onBackground = Color.White,
        onSurface = Color.White,
        error = Color.Red,
    )

    val DarkOrangeColorPalette = darkColorScheme(
        primary = orange200,
        secondary = orange700,
        tertiary = teal200,
        background = Color.Black,
        surface = Color.Black,
        onPrimary = Color.Black,
        onTertiary = Color.White,
        onBackground = Color.White,
        onSurface = Color.White,
        error = Color.Red,
    )

    val DarkRedColorPalette = darkColorScheme(
        primary = red200,
        secondary = red500,
        tertiary = teal200,
        surface = Color.Black
    )

    val DarkYellowColorPalette = darkColorScheme(
        primary = yellow200,
        secondary = yellow500,
        tertiary = teal200,
        surface = Color.Black
    )

    val DarkBrownColorPalette = darkColorScheme(
        primary = brown200,
        secondary = brown500,
        tertiary = teal200,
        surface = Color.Black
    )

    val DarkGreyColorPalette = darkColorScheme(
        primary = grey200,
        secondary = grey500,
        tertiary = teal200,
        surface = Color.Black
    )

    val DarkIndigoColorPalette = darkColorScheme(
        primary = indigo200,
        secondary = indigo500,
        tertiary = teal200,
        surface = Color.Black
    )

    // Light pallets
    val LightPinkColorPalette = lightColorScheme(
        primary = pink500,
        secondary = pink700,
        tertiary = teal200,
        background = Color.White,
        surface = Color.White,
        onPrimary = Color.White,
        onTertiary = Color.Black,
        onBackground = Color.Black,
        onSurface = Color.Black
    )

    val LightGreenColorPalette = lightColorScheme(
        primary = green500,
        secondary = green700,
        tertiary = teal200,
        background = Color.White,
        surface = Color.White,
        onPrimary = Color.White,
        onTertiary = Color.Black,
        onBackground = Color.Black,
        onSurface = Color.Black
    )

    val LightPurpleColorPalette = lightColorScheme(
        primary = purple500,
        secondary = purple700,
        tertiary = teal200,
        background = Color.White,
        surface = Color.White,
        onPrimary = Color.White,
        onTertiary = Color.Black,
        onBackground = Color.Black,
        onSurface = Color.Black
    )

    val LightBlueColorPalette = lightColorScheme(
        primary = blue500,
        secondary = blue700,
        tertiary = teal200,
        background = Color.White,
        surface = Color.White,
        onPrimary = Color.White,
        onTertiary = Color.Black,
        onBackground = Color.Black,
        onSurface = Color.Black
    )

    val LightOrangeColorPalette = lightColorScheme(
        primary = orange500,
        secondary = orange700,
        tertiary = teal200,
        background = Color.White,
        surface = Color.White,
        onPrimary = Color.White,
        onTertiary = Color.Black,
        onBackground = Color.Black,
        onSurface = Color.Black
    )

    val LightRedColorPalette = lightColorScheme(
        primary = red500,
        secondary = red700,
        tertiary = teal200,
        surface = Color.White
    )

    val LightYellowColorPalette = lightColorScheme(
        primary = yellow500,
        secondary = yellow700,
        tertiary = teal200,
        surface = Color.White
    )

    val LightBrownColorPalette = lightColorScheme(
        primary = brown500,
        secondary = brown700,
        tertiary = teal200,
        surface = Color.White
    )

    val LightGreyColorPalette = lightColorScheme(
        primary = grey500,
        secondary = grey700,
        tertiary = teal200,
        surface = Color.White
    )

    val LightIndigoColorPalette = lightColorScheme(
        primary = indigo500,
        secondary = indigo700,
        tertiary = teal200,
        surface = Color.White
    )

    fun getDefaultThemes(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = listOf(
        ComposeTheme.Theme(
            key = "green",
            colorSchemeLight = LightGreenColorPalette,
            colorSchemeDark = DarkGreenColorPalette,
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "blue",
            colorSchemeLight = LightBlueColorPalette,
            colorSchemeDark = DarkBlueColorPalette,
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "red",
            colorSchemeLight = LightRedColorPalette,
            colorSchemeDark = DarkRedColorPalette,
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "grey",
            colorSchemeLight = LightGreyColorPalette,
            colorSchemeDark = DarkGreyColorPalette,
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "brown",
            colorSchemeLight = LightBrownColorPalette,
            colorSchemeDark = DarkBrownColorPalette,
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "indigo",
            colorSchemeLight = LightIndigoColorPalette,
            colorSchemeDark = DarkIndigoColorPalette,
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "orange",
            colorSchemeLight = LightOrangeColorPalette,
            colorSchemeDark = DarkOrangeColorPalette,
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "pink",
            colorSchemeLight = LightPinkColorPalette,
            colorSchemeDark = DarkPinkColorPalette,
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "purple",
            colorSchemeLight = LightPurpleColorPalette,
            colorSchemeDark = DarkPurpleColorPalette,
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "yellow",
            colorSchemeLight = LightYellowColorPalette,
            colorSchemeDark = DarkYellowColorPalette,
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        )
    )
}