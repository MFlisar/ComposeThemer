package com.michaelflisar.composethemer

import com.michaelflisar.composethemer.ComposeTheme.Key
import com.michaelflisar.composethemer.themes.ThemeFlatUIAlizarin
import com.michaelflisar.composethemer.themes.ThemeFlatUIAmethyst
import com.michaelflisar.composethemer.themes.ThemeFlatUIAsbestos
import com.michaelflisar.composethemer.themes.ThemeFlatUIBelizehole
import com.michaelflisar.composethemer.themes.ThemeFlatUICarrot
import com.michaelflisar.composethemer.themes.ThemeFlatUIClouds
import com.michaelflisar.composethemer.themes.ThemeFlatUIConcrete
import com.michaelflisar.composethemer.themes.ThemeFlatUIEmerald
import com.michaelflisar.composethemer.themes.ThemeFlatUIGreensea
import com.michaelflisar.composethemer.themes.ThemeFlatUIMidnightBlue
import com.michaelflisar.composethemer.themes.ThemeFlatUINephritis
import com.michaelflisar.composethemer.themes.ThemeFlatUIOrange
import com.michaelflisar.composethemer.themes.ThemeFlatUIPeterriver
import com.michaelflisar.composethemer.themes.ThemeFlatUIPomegranate
import com.michaelflisar.composethemer.themes.ThemeFlatUIPumpkin
import com.michaelflisar.composethemer.themes.ThemeFlatUISilver
import com.michaelflisar.composethemer.themes.ThemeFlatUISunflower
import com.michaelflisar.composethemer.themes.ThemeFlatUITurquoise
import com.michaelflisar.composethemer.themes.ThemeFlatUIWetasphalt
import com.michaelflisar.composethemer.themes.ThemeFlatUIWisteria

object FlatUIThemes : ComposeTheme.Collection {

    override val key = Key("flatui", "Flat UI")

    override val defaultVariantId = "tetrade"

    override val allGroups by lazy {
        listOf(
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
}