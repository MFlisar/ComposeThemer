package com.michaelflisar.composethemer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.michaelflisar.materialpreferences.core.interfaces.StorageSetting

// TODO: entfernen und beim nächsten Release von Compose in MaterialPreferences in compose module anlegen
@Composable
fun <T> StorageSetting<T>.collectAsState() = flow.collectAsState(initial = defaultValue)