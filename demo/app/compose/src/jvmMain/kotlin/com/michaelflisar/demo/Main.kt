package com.michaelflisar.demo

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.michaelflisar.composechangelog.demo.BuildKonfig
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.themes.ThemeDefault

fun main() {

    // register available themes
    Shared.registerThemes()

    application {
        Window(
            title = BuildKonfig.appName,
            onCloseRequest = ::exitApplication,
            state = rememberWindowState(
                position = WindowPosition(Alignment.Center),
                width = 1024.dp,
                height = 800.dp
            )
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
}