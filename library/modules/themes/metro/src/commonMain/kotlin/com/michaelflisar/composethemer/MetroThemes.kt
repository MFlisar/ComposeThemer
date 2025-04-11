package com.michaelflisar.composethemer

import com.michaelflisar.composethemer.ComposeTheme.Key
import com.michaelflisar.composethemer.themes.*

object MetroThemes : ComposeTheme.Collection {

    override val key = Key("metro", "Metro")

    override val defaultVariantId = "tetrade"

    override val allGroups by lazy {
        listOf(
            // Themes Begin
            ThemeMetroAmber,
            ThemeMetroBrown,
            ThemeMetroCobalt,
            ThemeMetroCrimson,
            ThemeMetroCyan,
            ThemeMetroEmerald,
            ThemeMetroGreen,
            ThemeMetroIndogo,
            ThemeMetroLime,
            ThemeMetroMagenta,
            ThemeMetroMauve,
            ThemeMetroOlive,
            ThemeMetroOrange,
            ThemeMetroPink,
            ThemeMetroRed,
            ThemeMetroSienna,
            ThemeMetroSteel,
            ThemeMetroTeal,
            ThemeMetroViolet,
            ThemeMetroYellow,
            // Themes End
        )
    }
}