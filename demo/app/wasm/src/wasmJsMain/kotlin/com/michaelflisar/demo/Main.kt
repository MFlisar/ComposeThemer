package com.michaelflisar.demo

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.themes.ThemeDefault

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
suspend fun main() {

    Shared.registerThemes()

    ComposeViewport(
        // mit container id geht es nicht --> wäre aber gut, dann würde ein Loader angezeigt werden, aktuell wird der nicht angezeigt...
        // viewportContainerId = wasmSetup.canvasElementId
    ) {
        val baseTheme = remember { mutableStateOf(ComposeTheme.BaseTheme.System) }
        val contrast = remember { mutableStateOf(ComposeTheme.Contrast.Normal) }
        val dynamic = remember { mutableStateOf(false) }
        val theme = remember { mutableStateOf(ThemeDefault.id) }
        val state = ComposeTheme.State(baseTheme, contrast, dynamic, theme)

        ComposeTheme(state = state) {
            DemoApp(
                baseTheme = baseTheme,
                contrast = contrast,
                dynamic = dynamic,
                theme = theme
            )
        }
    }
}