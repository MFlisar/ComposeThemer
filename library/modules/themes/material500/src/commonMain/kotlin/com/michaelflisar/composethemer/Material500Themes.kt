package com.michaelflisar.composethemer

import com.michaelflisar.composethemer.ComposeTheme.Key
import com.michaelflisar.composethemer.themes.*

object Material500Themes : ComposeTheme.Collection {

    override val key = Key("material500", "Material 500")

    override val defaultVariantId = "tetrade"

    override val allGroups = listOf(
        // Themes Begin
        ThemeMaterial500Amber,
        ThemeMaterial500Blue,
        ThemeMaterial500BlueGrey,
        ThemeMaterial500Brown,
        ThemeMaterial500Cyan,
        ThemeMaterial500DeepOrange,
        ThemeMaterial500DeepPurple,
        ThemeMaterial500Green,
        ThemeMaterial500Grey,
        ThemeMaterial500Indigo,
        ThemeMaterial500LightBlue,
        ThemeMaterial500LightGreen,
        ThemeMaterial500Lime,
        ThemeMaterial500Orange,
        ThemeMaterial500Pink,
        ThemeMaterial500Purple,
        ThemeMaterial500Red,
        ThemeMaterial500Teal,
        ThemeMaterial500Yellow,
        // Themes End
    )
}