package com.michaelflisar.demo

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalConfiguration
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.UpdateEdgeToEdgeDefault
import com.michaelflisar.composethemer.defaultScrim
import com.michaelflisar.composethemer.themes.ThemeDefault

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val edgeToEdge = true

        setContent {

            // simple runtime saved states
            val baseTheme = rememberSaveable { mutableStateOf(ComposeTheme.BaseTheme.System) }
            val contrast = rememberSaveable { mutableStateOf(ComposeTheme.Contrast.Normal) }
            val dynamic = rememberSaveable { mutableStateOf(false) }
            val theme =
                rememberSaveable { mutableStateOf(ThemeDefault.Theme.id) } // id of the current theme

            val state = ComposeTheme.State(baseTheme, contrast, dynamic, theme)

            // in a live app you may have screens with different colors behind the status and navigation bar =>
            // following states emulate such a behaviour and show how those cases can be handled
            val statusBarColorPrimary = rememberSaveable { mutableStateOf(true) }
            val navigationBarColorPrimary = rememberSaveable { mutableStateOf(true) }

            ComposeTheme(state = state) {

                val primary = MaterialTheme.colorScheme.primary
                val background = MaterialTheme.colorScheme.background

                val statusBarColor = remember(statusBarColorPrimary.value, primary, background) {
                    derivedStateOf { if (statusBarColorPrimary.value) primary else background }
                }
                val navigationBarColor =
                    remember(navigationBarColorPrimary.value, primary, background) {
                        derivedStateOf { if (navigationBarColorPrimary.value) primary else background }
                    }

                // Statusbar and Navigation Bar is drawn in primary color -> we use this to detect the dark mode for the system bars
                if (edgeToEdge) {

                    // UpdateEdgeToEdgeDefault...helper function to easily enable edgeToEdge
                    // SystemBarStyle also offers some extensions (statusBar, navigationBar, transparent) that can be used

                    // this app draws a bottom navigation behind the navigation bar in portrait only, in landscape mode it doesn't
                    // => landscape may
                    val landscape =
                        LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE
                    val isDark = state.base.value.isDark()

                    UpdateEdgeToEdgeDefault(
                        activity = this,
                        themeState = state,
                        statusBarColor = statusBarColor.value,
                        navigationBarColor = if (landscape) {
                            SystemBarStyle.defaultScrim(resources, isDark)
                        } else navigationBarColor.value,
                        isNavigationBarContrastEnforced = landscape
                    )
                }

                DemoApp(
                    baseTheme = baseTheme,
                    contrast = contrast,
                    dynamic = dynamic,
                    theme = theme,
                    statusBarColorPrimary = statusBarColorPrimary,
                    navigationBarColorPrimary = navigationBarColorPrimary
                )
            }
        }
    }
}