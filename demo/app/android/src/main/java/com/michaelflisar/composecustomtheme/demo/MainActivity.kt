package com.michaelflisar.composecustomtheme.demo

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.UpdateEdgeToEdgeDefault
import com.michaelflisar.composethemer.defaultScrim
import com.michaelflisar.composethemer.demo.DemoContent
import com.michaelflisar.composethemer.demo.R
import com.michaelflisar.composethemer.themes.ThemeDefault
import com.michaelflisar.kmptemplate.composables.DemoCheckbox
import com.michaelflisar.kmptemplate.composables.DemoCollapsibleRegion
import com.michaelflisar.kmptemplate.composables.rememberDemoExpandedRegions

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

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = stringResource(R.string.app_name))
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = statusBarColor.value,
                                titleContentColor = contentColorFor(statusBarColor.value),
                                actionIconContentColor = contentColorFor(statusBarColor.value)
                            )
                        )
                    },
                    bottomBar = {
                        BottomAppBar(
                            containerColor = navigationBarColor.value,
                            tonalElevation = 0.dp,
                            actions = {
                                IconButton(onClick = { }) {
                                    Icon(Icons.Filled.Home, contentDescription = "Home")
                                }
                            },
                            floatingActionButton = {
                                FloatingActionButton(onClick = {}) {
                                    Icon(Icons.Filled.Info, contentDescription = null)
                                }
                            }
                        )
                    },
                    content = { padding ->
                        Content(
                            Modifier
                                .fillMaxSize()
                                // consume insets as scaffold doesn't do it by default
                                .consumeWindowInsets(padding)
                                .verticalScroll(rememberScrollState())
                                .padding(padding)
                                .padding(16.dp),
                            baseTheme,
                            contrast,
                            dynamic,
                            theme,
                            statusBarColorPrimary,
                            navigationBarColorPrimary
                        )
                    }
                )
            }
        }
    }

    // ----------------
    // UI - Content
    // ----------------

    @Composable
    private fun Content(
        modifier: Modifier,
        baseTheme: MutableState<ComposeTheme.BaseTheme>,
        contrast: MutableState<ComposeTheme.Contrast>,
        dynamic: MutableState<Boolean>,
        theme: MutableState<String>,
        statusBarColorPrimary: MutableState<Boolean>,
        navigationBarColorPrimary: MutableState<Boolean>,
    ) {
        val regions = rememberDemoExpandedRegions(listOf(0))

        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DemoCollapsibleRegion(
                title = "Theme",
                info = "${ComposeTheme.getRegisteredThemes().size} themes available",
                regionId = 0,
                state = regions
            ) {
                DemoContent(
                    modifier = Modifier.fillMaxWidth(),
                    baseTheme = baseTheme,
                    contrast = contrast,
                    dynamic = dynamic,
                    theme = theme,
                    isSystemContrastSupported = true, // only android supports system contrast
                    isDynamicColorsSupported = true // only android supports dynamic colors
                )
            }
            DemoCollapsibleRegion(
                title = "System Bar Styles",
                regionId = 1,
                state = regions
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    DemoCheckbox(
                        modifier = Modifier.fillMaxWidth(),
                        title = "Status Bar Primary",
                        checked = statusBarColorPrimary,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    DemoCheckbox(
                        modifier = Modifier.fillMaxWidth(),
                        title = "Navigation Bar Primary",
                        checked = navigationBarColorPrimary,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}