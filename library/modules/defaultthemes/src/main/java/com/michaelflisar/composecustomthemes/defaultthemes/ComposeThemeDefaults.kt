package com.michaelflisar.composecustomthemes.defaultthemes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.composables.materialcolors.MaterialColors
import com.michaelflisar.composecustomtheme.ComposeTheme

object ComposeThemeDefaults {

    fun getDefaultThemes(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = listOf(
        ComposeTheme.Theme(
            key = "default",
            colorSchemeLight = lightColorScheme(),
            colorSchemeDark = darkColorScheme(),
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "red",
            colorSchemeLight = redColorScheme(false),
            colorSchemeDark = redColorScheme(true),
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "pink",
            colorSchemeLight = pinkColorScheme(false),
            colorSchemeDark = pinkColorScheme(true),
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "purple",
            colorSchemeLight = purpleColorScheme(false),
            colorSchemeDark = purpleColorScheme(true),
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "indigo",
            colorSchemeLight = indigoColorScheme(false),
            colorSchemeDark = indigoColorScheme(true),
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "blue",
            colorSchemeLight = blueColorScheme(false),
            colorSchemeDark = blueColorScheme(true),
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "cyan",
            colorSchemeLight = cyanColorScheme(false),
            colorSchemeDark = cyanColorScheme(true),
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "teal",
            colorSchemeLight = tealColorScheme(false),
            colorSchemeDark = tealColorScheme(true),
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "green",
            colorSchemeLight = greenColorScheme(false),
            colorSchemeDark = greenColorScheme(true),
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "lime",
            colorSchemeLight = limeColorScheme(false),
            colorSchemeDark = limeColorScheme(true),
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "yellow",
            colorSchemeLight = yellowColorScheme(false),
            colorSchemeDark = yellowColorScheme(true),
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "amber",
            colorSchemeLight = amberColorScheme(false),
            colorSchemeDark = amberColorScheme(true),
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "orange",
            colorSchemeLight = orangeColorScheme(false),
            colorSchemeDark = orangeColorScheme(true),
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "brown",
            colorSchemeLight = brownColorScheme(false),
            colorSchemeDark = brownColorScheme(true),
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        ),
        ComposeTheme.Theme(
            key = "gray",
            colorSchemeLight = grayColorScheme(false),
            colorSchemeDark = grayColorScheme(true),
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        )
    )

    private fun redColorScheme(dark: Boolean) = MaterialThemeUtil.colorScheme(
        dark, MaterialColors.Red, MaterialColors.Red, MaterialColors.Green
    )

    private fun pinkColorScheme(dark: Boolean) = MaterialThemeUtil.colorScheme(
        dark, MaterialColors.Pink, MaterialColors.Pink, MaterialColors.Green
    )

    private fun purpleColorScheme(dark: Boolean) = MaterialThemeUtil.colorScheme(
        dark, MaterialColors.Purple, MaterialColors.DeepPurple, MaterialColors.Green
    )

    private fun indigoColorScheme(dark: Boolean) = MaterialThemeUtil.colorScheme(
        dark, MaterialColors.Indigo, MaterialColors.Indigo, MaterialColors.Green
    )

    private fun blueColorScheme(dark: Boolean) = MaterialThemeUtil.colorScheme(
        dark, MaterialColors.Blue, MaterialColors.LightBlue, MaterialColors.Orange
    )

    private fun cyanColorScheme(dark: Boolean) = MaterialThemeUtil.colorScheme(
        dark, MaterialColors.Cyan, MaterialColors.Cyan, MaterialColors.Orange
    )

    private fun tealColorScheme(dark: Boolean) = MaterialThemeUtil.colorScheme(
        dark, MaterialColors.Teal, MaterialColors.Cyan, MaterialColors.Orange
    )

    private fun greenColorScheme(dark: Boolean) = MaterialThemeUtil.colorScheme(
        dark, MaterialColors.Green, MaterialColors.LightGreen, MaterialColors.Orange
    )

    private fun limeColorScheme(dark: Boolean) = MaterialThemeUtil.colorScheme(
        dark, MaterialColors.Lime, MaterialColors.Lime, MaterialColors.Orange
    )

    private fun yellowColorScheme(dark: Boolean) = MaterialThemeUtil.colorScheme(
        dark, MaterialColors.Yellow, MaterialColors.Yellow, MaterialColors.Orange
    )

    private fun amberColorScheme(dark: Boolean) = MaterialThemeUtil.colorScheme(
        dark, MaterialColors.Amber, MaterialColors.Amber, MaterialColors.Red
    )

    private fun orangeColorScheme(dark: Boolean) = MaterialThemeUtil.colorScheme(
        dark, MaterialColors.Orange, MaterialColors.DeepOrange, MaterialColors.Red
    )

    private fun brownColorScheme(dark: Boolean) = MaterialThemeUtil.colorScheme(
        dark, MaterialColors.Brown, MaterialColors.Brown, MaterialColors.Yellow
    )

    private fun grayColorScheme(dark: Boolean) = MaterialThemeUtil.colorScheme(
        dark, MaterialColors.Gray, MaterialColors.Gray, MaterialColors.BlueGrey
    )

}