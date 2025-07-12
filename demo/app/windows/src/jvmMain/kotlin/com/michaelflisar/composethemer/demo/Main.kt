package com.michaelflisar.composethemer.demo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.FlatUIThemes
import com.michaelflisar.composethemer.Material500Themes
import com.michaelflisar.composethemer.MetroThemes
import com.michaelflisar.composethemer.themes.DefaultThemes
import com.michaelflisar.composethemer.themes.ThemeDefault

fun main() {

    // register available themes
    val allThemes: List<ComposeTheme.Theme> =
        DefaultThemes.getAllThemes() +
                MetroThemes.getAllThemes() +
                FlatUIThemes.getAllThemes() +
                Material500Themes.getAllThemes()
    ComposeTheme.register(*allThemes.toTypedArray())

    application {

        Window(
            title = "Compose Themer Demo",
            onCloseRequest = ::exitApplication,
            state = rememberWindowState(
                position = WindowPosition(Alignment.Center),
                width = 800.dp,
                height = 600.dp
            )
        ) {
            val baseTheme = remember { mutableStateOf(ComposeTheme.BaseTheme.System) }
            val contrast = remember { mutableStateOf(ComposeTheme.Contrast.Normal) }
            val dynamic = remember { mutableStateOf(false) }
            val theme = remember { mutableStateOf(ThemeDefault.id) }
            val state = ComposeTheme.State(baseTheme, contrast, dynamic, theme)

            ComposeTheme(state = state) {
                Surface {
                    DemoContent(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState()),
                        baseTheme = baseTheme,
                        contrast = contrast,
                        dynamic = dynamic,
                        theme = theme
                    )
                }
            }
        }
    }
}