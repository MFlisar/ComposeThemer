package com.michaelflisar.composecustomtheme.demo

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.michaelflisar.composecustomtheme.demo.classes.DemoPrefs
import com.michaelflisar.composedemobaseactivity.classes.listSaverKeepEntryStateList
import com.michaelflisar.composedemobaseactivity.composables.DemoCollapsibleRegion
import com.michaelflisar.composedemobaseactivity.composables.DemoSegmentedButtons
import com.michaelflisar.composedemobaseactivity.composables.rememberExpandedRegions
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.defaultScrim
import com.michaelflisar.composethemer.demo.R
import com.michaelflisar.composethemer.enableEdgeToEdge
import com.michaelflisar.composethemer.navigationBar
import com.michaelflisar.composethemer.statusBar
import com.michaelflisar.kotpreferences.compose.collectAsState
import com.michaelflisar.kotpreferences.compose.collectAsStateNotNull
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val edgeToEdge = true
        val variant = 1

        setContent {

            // those states are persisted and retrieved via my kotpreferences library
            // => of course any compose state can be used
            val baseTheme = DemoPrefs.baseTheme.collectAsStateNotNull()
            val dynamic = DemoPrefs.dynamic.collectAsStateNotNull()
            val theme = DemoPrefs.themeKey.collectAsStateNotNull()

            // simple runtime saved states would look like following:
            // val baseTheme = rememberSaveable { mutableStateOf(ComposeTheme.BaseTheme.System) }
            // val dynamic = rememberSaveable { mutableStateOf(false) }
            // val theme = rememberSaveable { mutableStateOf(ThemeGreenForest.KEY) } // key of the current theme
            // val edgeToEdge = rememberSaveable { mutableStateOf(false) }

            val state = ComposeTheme.State(baseTheme, dynamic, theme)

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

                    // ComposeTheme.enableEdgeToEdge...helper function to easily enable edgeToEdge
                    // SystemBarStyle also offers some extensions (statusBar, navigationBar, transparent) that can be used

                    // this app draws a bottom navigation behind the navigation bar in portrait only, in landscape mode it doesn't
                    // => landscape may
                    val landscape =
                        LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE

                    if (variant == 1) {

                        // Variant 1
                        LaunchedEffect(state, statusBarColor, navigationBarColor) {
                            ComposeTheme.enableEdgeToEdge(
                                activity = this@MainActivity,
                                statusBarColor = statusBarColor.value,
                                navigationBarColor = if (landscape) {
                                    SystemBarStyle.defaultScrim(resources)
                                } else navigationBarColor.value,
                                isNavigationBarContrastEnforced = landscape
                            )
                        }
                    } else {

                        // Variant 2
                        val isDarkStatusBar = remember(statusBarColor.value) {
                            derivedStateOf { statusBarColor.value.luminance() < .5f }
                        }
                        val isDarkNavigationBar = remember(navigationBarColor.value, landscape, resources) {
                            derivedStateOf {
                                (if (landscape) {
                                    SystemBarStyle.defaultScrim(resources)
                                } else navigationBarColor.value).luminance() < .5f
                            }
                        }
                        LaunchedEffect(state, isDarkStatusBar, isDarkNavigationBar) {
                            ComposeTheme.enableEdgeToEdge(
                                this@MainActivity,
                                statusBarStyle = SystemBarStyle.statusBar { isDarkStatusBar.value },
                                navigationBarStyle = SystemBarStyle.navigationBar { isDarkNavigationBar.value },
                                isNavigationBarContrastEnforced = landscape
                            )
                        }
                    }
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
                            baseTheme.value,
                            dynamic.value,
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
        baseTheme: ComposeTheme.BaseTheme,
        dynamic: Boolean,
        statusBarColorPrimary: MutableState<Boolean>,
        navigationBarColorPrimary: MutableState<Boolean>
    ) {
        val showLabels = rememberSaveable { mutableStateOf(true) }
        val regionsState = rememberExpandedRegions(listOf(1))
        val scope = rememberCoroutineScope()

        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DemoCollapsibleRegion(
                title = "Theme",
                regionId = 0,
                expandedRegionsState = regionsState
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Theme", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.weight(1f))
                    Text("Show Labels", style = MaterialTheme.typography.labelSmall)
                    Checkbox(
                        checked = showLabels.value,
                        onCheckedChange = {
                            showLabels.value = it
                        }
                    )
                }
                val selected = DemoPrefs.themeKey.collectAsState()
                if (dynamic) {
                    Text(
                        "If dynamic theme is enabled the selected theme won't have any impact as colors are derived dynamically from the current wallpaper!",
                        style = MaterialTheme.typography.bodySmall
                    )
                } else {
                    Text(
                        "${ComposeTheme.getRegisteredThemes().size} themes available",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Row(
                        modifier = Modifier.horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        ComposeTheme.getRegisteredThemes()
                            .forEach {
                                FilterChip(
                                    selected = selected.value == it.key,
                                    onClick = {
                                        scope.launch {
                                            DemoPrefs.themeKey.update(it.key)
                                        }
                                    },
                                    label = {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            if (showLabels.value) {
                                                Text(it.key)
                                            }
                                            Box(
                                                modifier = Modifier
                                                    .size(16.dp)
                                                    .clip(CircleShape)
                                                    .background(if (baseTheme.isDark()) it.colorSchemeDark.primary else it.colorSchemeLight.primary)
                                            )
                                        }

                                    },
                                    leadingIcon = if (selected.value == it.key) {
                                        {
                                            Icon(Icons.Default.Check, contentDescription = null)
                                        }
                                    } else null
                                )
                            }
                    }
                    Text(
                        "Selected Theme: ${selected.value}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            DemoCollapsibleRegion(
                title = "Theme Settings",
                regionId = 1,
                expandedRegionsState = regionsState
            ) {
                Text("Base Theme Style", style = MaterialTheme.typography.titleMedium)
                DemoSegmentedButtons(
                    items = ComposeTheme.BaseTheme.entries,
                    itemToText = { it.name },
                    initialSelectedIndex = ComposeTheme.BaseTheme.entries.indexOf(baseTheme),
                    onItemSelected = { index, item ->
                        scope.launch {
                            DemoPrefs.baseTheme.update(item)
                        }
                    }
                )
                Text("Enable dynamic theme?", style = MaterialTheme.typography.titleMedium)
                DemoSegmentedButtons(
                    items = listOf("Yes", "No"),
                    initialSelectedIndex = if (dynamic) 0 else 1,
                    onItemSelected = { index ->
                        scope.launch {
                            DemoPrefs.dynamic.update(index == 0)
                        }
                    }
                )
            }
            DemoCollapsibleRegion(
                title = "System Bar Styles",
                regionId = 2,
                expandedRegionsState = regionsState
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Status Bar Primary", style = MaterialTheme.typography.titleMedium)
                        Checkbox(
                            checked = statusBarColorPrimary.value,
                            onCheckedChange = {
                                statusBarColorPrimary.value = it
                            }
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Navigation Bar Primary", style = MaterialTheme.typography.titleMedium)
                        Checkbox(
                            checked = navigationBarColorPrimary.value,
                            onCheckedChange = {
                                navigationBarColorPrimary.value = it
                            }
                        )
                    }
                }
            }
        }
    }
}