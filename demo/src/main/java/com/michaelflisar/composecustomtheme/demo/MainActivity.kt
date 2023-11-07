package com.michaelflisar.composethemer.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
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
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.demo.classes.DemoPrefs
import com.michaelflisar.composedemobaseactivity.classes.listSaverKeepEntryStateList
import com.michaelflisar.composedemobaseactivity.composables.DemoCollapsibleRegion
import com.michaelflisar.composedemobaseactivity.composables.DemoSegmentedButtons
import com.michaelflisar.kotpreferences.compose.collectAsState
import com.michaelflisar.kotpreferences.compose.collectAsStateNotNull
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // those states are persisted and retrieved via my kotpreferences library
            // => of course any compose state can be used
            val baseTheme = DemoPrefs.baseTheme.collectAsStateNotNull()
            val dynamic = DemoPrefs.dynamic.collectAsStateNotNull()
            val theme = DemoPrefs.themeKey.collectAsStateNotNull()
            // simple runtime saved states would look like following:
            // val baseTheme = rememberSaveable { mutableStateOf(ComposeTheme.BaseTheme.System) }
            // val dynamic = rememberSaveable { mutableStateOf(false) }
            // val theme = rememberSaveable { mutableStateOf("Default") } // key of the current theme

            val state = ComposeTheme.State(baseTheme, dynamic, theme)
            ComposeTheme(state = state) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = stringResource(R.string.app_name))
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                                actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                            )
                        )
                    },
                    content = {
                        Content(
                            Modifier
                                .fillMaxSize()
                                .padding(it)
                                .padding(16.dp),
                            baseTheme.value,
                            dynamic.value
                        )
                    }
                )
            }
        }
    }

    // ----------------
    // UI - Content
    // ----------------

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun Content(
        modifier: Modifier,
        baseTheme: ComposeTheme.BaseTheme,
        dynamic: Boolean
    ) {
        val showLabels = rememberSaveable {
            mutableStateOf(false)
        }
        val expandedRootRegions = rememberSaveable(Unit, saver = listSaverKeepEntryStateList()) {
            mutableStateListOf(1)
        }
        val scope = rememberCoroutineScope()

        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DemoCollapsibleRegion(
                title = "Theme",
                id = 0,
                expandedIds = expandedRootRegions
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
                id = 1,
                expandedIds = expandedRootRegions
            ) {
                Text("Base Theme Style", style = MaterialTheme.typography.titleMedium)
                DemoSegmentedButtons(
                    items = ComposeTheme.BaseTheme.values().toList(),
                    itemToText = { it.name },
                    initialSelectedIndex = ComposeTheme.BaseTheme.values().indexOf(baseTheme),
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
                title = "Example UI",
                id = 2,
                expandedIds = expandedRootRegions
            ) {
                var tabIndex by remember { mutableIntStateOf(0) }
                val tabs = listOf("Home", "About", "Settings")
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TabRow(selectedTabIndex = tabIndex) {
                        tabs.forEachIndexed { index, title ->
                            Tab(
                                text = { Text(title) },
                                selected = tabIndex == index,
                                onClick = { tabIndex = index }
                            )
                        }
                    }
                    NavigationBar {
                        tabs.forEachIndexed { index, title ->
                            NavigationBarItem(
                                label = {
                                    Text(text = title)
                                },
                                selected = tabIndex == index,
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Home,
                                        contentDescription = null
                                    )
                                },
                                onClick = { tabIndex = index }
                            )
                        }
                    }
                    Card {
                        Text("Card", modifier = Modifier.padding(16.dp))
                    }
                    OutlinedCard {
                        Text("Card", modifier = Modifier.padding(16.dp))
                    }
                    ElevatedCard {
                        Text("Card", modifier = Modifier.padding(16.dp))
                    }
                }
            }
        }
    }
}