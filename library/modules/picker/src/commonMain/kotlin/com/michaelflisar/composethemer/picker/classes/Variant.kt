package com.michaelflisar.composethemer.picker.classes

import com.michaelflisar.composethemer.ComposeTheme

data class Variant(
    val id: String,
    val name: String
) {
    constructor(theme: ComposeTheme.Theme): this(theme.variantId(), theme.variantName())
}