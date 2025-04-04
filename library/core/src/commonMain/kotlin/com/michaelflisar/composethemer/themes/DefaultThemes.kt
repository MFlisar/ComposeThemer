package com.michaelflisar.composethemer.themes

import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.ComposeTheme.Key

object DefaultThemes : ComposeTheme.Collection {

    override val key = Key("", "Default")

    override val defaultVariantId = ""

    override val allGroups = listOf(
        // Themes Begin
        ThemeDefault
        // Themes End
    )
}