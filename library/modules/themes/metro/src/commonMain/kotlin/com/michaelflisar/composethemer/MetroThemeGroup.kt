package com.michaelflisar.composethemer

abstract class MetroThemeGroup : ComposeTheme.Group<MetroThemeVariant> {
    override val defaultVariant = MetroThemeVariant.Triade
}