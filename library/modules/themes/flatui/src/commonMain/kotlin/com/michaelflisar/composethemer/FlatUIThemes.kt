package com.michaelflisar.composethemer

import com.michaelflisar.composethemer.ComposeTheme.Key
import com.michaelflisar.composethemer.themes.*

object FlatUIThemes : ComposeTheme.Collection {

    override val key = Key("flatui", "Flat UI")

    override val defaultVariantId = "triade"

    override val allGroups = listOf(
        // Themes Begin
        ThemeFlatUIAlizarin,
        ThemeFlatUIAmethyst,
        ThemeFlatUIAsbestos,
        ThemeFlatUIBelizehole,
        ThemeFlatUICarrot,
        ThemeFlatUIClouds,
        ThemeFlatUIConcrete,
        ThemeFlatUIEmerald,
        ThemeFlatUIGreensea,
        ThemeFlatUIMidnightBlue,
        ThemeFlatUINephritis,
        ThemeFlatUIOrange,
        ThemeFlatUIPeterriver,
        ThemeFlatUIPomegranate,
        ThemeFlatUIPumpkin,
        ThemeFlatUISilver,
        ThemeFlatUISunflower,
        ThemeFlatUITurquoise,
        ThemeFlatUIWetasphalt,
        ThemeFlatUIWisteria,
        // Themes End
    )
}