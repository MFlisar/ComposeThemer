package com.michaelflisar.composethemer.themes

import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeThemeColors
import com.michaelflisar.composethemer.*
import com.michaelflisar.composethemer.base.BaseTheme

object <FILE_NAME> : ComposeTheme.Group {

    private object Colors {
        // colors begin
        // colors end
    }

    // themes begin
    // themes end

    override val collection = <COLLECTION>
    override val groupKey = ComposeTheme.Key("<GROUP_KEY>", "<GROUP_NAME>")
    override val themes = listOf(<THEMES>)
}