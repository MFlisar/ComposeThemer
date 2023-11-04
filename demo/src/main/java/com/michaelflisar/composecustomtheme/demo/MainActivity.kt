package com.michaelflisar.composecustomtheme.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.michaelflisar.composecustomtheme.ComposeTheme
import com.michaelflisar.composecustomtheme.demo.classes.DemoPrefs
import com.michaelflisar.composedemobaseactivity.composables.DemoSegmentedButtons
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

    @Composable
    private fun Content(
        modifier: Modifier,
        baseTheme: ComposeTheme.BaseTheme,
        dynamic: Boolean
    ) {
        val scope = rememberCoroutineScope()
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Text("Theme", style = MaterialTheme.typography.titleMedium)

            if (dynamic) {
                Text(
                    "If dynamic theme is enabled the selected theme won't have any impact as colors are derived dynamically from the current wallpaper!",
                    style = MaterialTheme.typography.bodySmall
                )
            } else {
                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    ComposeTheme.getRegisteredThemes().forEach {
                        Button(
                            onClick = {
                                scope.launch {
                                    DemoPrefs.themeKey.update(it.key)
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (baseTheme.isDark()) it.colorSchemeDark.primary else it.colorSchemeLight.primary,
                                contentColor = if (baseTheme.isDark()) it.colorSchemeDark.onPrimary else it.colorSchemeLight.onPrimary
                            )
                        ) {
                            Text(it.key)
                        }
                    }
                }
            }

            Text("Base Theme Style", style = MaterialTheme.typography.titleMedium)

            DemoSegmentedButtons(
                items = ComposeTheme.BaseTheme.values().toList(),
                itemToText = { it.name },
                initialSelectedIndex = ComposeTheme.BaseTheme.values().indexOf(baseTheme),
                onItemSelected = { index, item ->
                    scope.launch {
                        DemoPrefs.baseTheme.update(item)
                    }
                })

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

            Divider(modifier = Modifier.padding(vertical = 16.dp))

            Text("Example UI", style = MaterialTheme.typography.titleMedium)

            var tabIndex by remember { mutableIntStateOf(0) }
            val tabs = listOf("Home", "About", "Settings")
            Column {
                Text("Hello World")
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
                                Icon(imageVector = Icons.Default.Home, contentDescription = null)
                            },
                            onClick = { tabIndex = index }
                        )
                    }
                }
            }
        }
    }
}