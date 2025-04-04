package com.michaelflisar.composecustomtheme.demo

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrightnessHigh
import androidx.compose.material.icons.filled.BrightnessLow
import androidx.compose.material.icons.filled.BrightnessMedium
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.michaelflisar.composecustomtheme.demo.classes.DemoPrefs
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.UpdateEdgeToEdgeDefault
import com.michaelflisar.composethemer.defaultScrim
import com.michaelflisar.composethemer.demo.R
import com.michaelflisar.composethemer.picker.DefaultThemePicker
import com.michaelflisar.kotpreferences.compose.asMutableState
import com.michaelflisar.toolbox.androiddemoapp.composables.DemoCollapsibleRegion
import com.michaelflisar.toolbox.androiddemoapp.composables.rememberDemoExpandedRegions
import com.michaelflisar.toolbox.composables.MyCheckbox
import com.michaelflisar.toolbox.composables.MyRow

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val edgeToEdge = true

        setContent {

            // those states are persisted and retrieved via my kotpreferences library
            // => of course any compose state can be used
            val baseTheme = DemoPrefs.baseTheme.asMutableState()
            val contrast = DemoPrefs.contrast.asMutableState()
            val dynamic = DemoPrefs.dynamic.asMutableState()
            val theme = DemoPrefs.themeKey.asMutableState()

            // simple runtime saved states would look like following:
            // val baseTheme = rememberSaveable { mutableStateOf(ComposeTheme.BaseTheme.System) }
            // val contrast = rememberSaveable { mutableStateOf(ComposeTheme.Contrast.Normal) }
            // val dynamic = rememberSaveable { mutableStateOf(false) }
            // val theme = rememberSaveable { mutableStateOf(ThemeGreenForest.KEY) } // key of the current theme
            // val edgeToEdge = rememberSaveable { mutableStateOf(false) }

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

                    // extension function => this does the same as the function above
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
        navigationBarColorPrimary: MutableState<Boolean>
    ) {
        val regions = rememberDemoExpandedRegions(listOf(0, 2))

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
                // check out the source code of [DefaultThemePicker] to see how to design your own layout
                // I do provide states for easy implementations of your own layouts
                // DefaultThemePicker is just an example...
                DefaultThemePicker(
                    modifier = Modifier.fillMaxWidth(),
                    baseTheme = baseTheme,
                    contrast = contrast,
                    dynamic = dynamic,
                    theme = theme,
                    singleLevelThemePicker = false,
                    isDynamicColorsSupported = true, // only android supports dynamic colors
                    labelWidth = 72.dp,
                    imageVectorSystem = null,//Icons.Default.PhoneAndroid,
                    baseThemeNameProvider = {
                        when (it) {
                            ComposeTheme.BaseTheme.Dark,
                            ComposeTheme.BaseTheme.Light -> null
                            ComposeTheme.BaseTheme.System -> "System"
                        }
                    },
                    contrastNameProvider = {
                        when (it) {
                            ComposeTheme.Contrast.System -> "System"
                            ComposeTheme.Contrast.Normal,
                            ComposeTheme.Contrast.Medium,
                            ComposeTheme.Contrast.High -> null
                        }
                    }
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
                    MyCheckbox(
                        modifier = Modifier.fillMaxWidth(),
                        title = "Status Bar Primary",
                        checked = statusBarColorPrimary,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    MyCheckbox(
                        modifier = Modifier.fillMaxWidth(),
                        title = "Navigation Bar Primary",
                        checked = navigationBarColorPrimary,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            DemoCollapsibleRegion(
                title = "UI Examples",
                regionId = 2,
                state = regions
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    ElevatedCard(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(modifier = Modifier.padding(8.dp), text = "ElevatedCard")
                    }
                    Card(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(modifier = Modifier.padding(8.dp), text = "Card")
                    }
                    val checked = remember { mutableStateOf(false) }
                    Checkbox(
                        modifier = Modifier.weight(1f),
                        checked = checked.value,
                        onCheckedChange = { checked.value = it })
                }
                MyRow {
                    ColorCard(MaterialTheme.colorScheme.primary, "Primary")
                    ColorCard(MaterialTheme.colorScheme.secondary, "Secondary")
                    ColorCard(MaterialTheme.colorScheme.tertiary, "Tertiary")
                }
                MyRow {
                    ColorCard(MaterialTheme.colorScheme.primaryContainer, "Primary Container")
                    ColorCard(MaterialTheme.colorScheme.secondaryContainer, "Secondary Container")
                    ColorCard(MaterialTheme.colorScheme.tertiaryContainer, "Tertiary Container")
                }
            }
        }
    }
}

@Composable
private fun RowScope.ColorCard(color: Color, label: String) {
    Card(
        modifier = Modifier.weight(1f),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Text(modifier = Modifier.padding(8.dp), text = label)
    }
}