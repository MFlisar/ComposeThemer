package com.michaelflisar.composethemer.picker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.picker.classes.Variant

object ThemePicker {

    class State(
        val allThemes: List<ComposeTheme.Theme>,
        val baseTheme: MutableState<ComposeTheme.BaseTheme>,
        val contrast: MutableState<ComposeTheme.Contrast>,
        val dynamic: MutableState<Boolean>,
        val selectedThemeId: MutableState<String>,
        val selectedTheme: androidx.compose.runtime.State<ComposeTheme.Theme?>,
        val isContrastEnabled: androidx.compose.runtime.State<Boolean>,
        val isThemeEnabled: androidx.compose.runtime.State<Boolean>,
    )

    class MultiLevelState(
        val selectedCollection: MutableState<ComposeTheme.Collection?>,
        val selectedGroup: MutableState<ComposeTheme.Group?>,
        val selectedVariant: MutableState<Variant?>,
        val collections: List<ComposeTheme.Collection>,
        val groups: List<ComposeTheme.Group>,
        val variants: List<Variant>,
        val showCollectionPicker: Boolean,
        val showVariantPicker: Boolean,
        val themesOfSelectedGroup: List<ComposeTheme.Theme>
    )

    sealed class SpinnerSetup<T: Any> {
        abstract val showSpinnerForSingleItem: Boolean
        class Default<T: Any>(override val showSpinnerForSingleItem: Boolean = false) : SpinnerSetup<T>()
        class Filterable<T: Any>(
            val label: String?,
            val placeholder: String?,
            override val showSpinnerForSingleItem: Boolean = false,
            val minItemsToShowFilter: Int = 0,
            val filter: (item: T, filter: String) -> Boolean
        ) : SpinnerSetup<T>()
    }
}

@Composable
fun rememberThemePicker(
    baseTheme: MutableState<ComposeTheme.BaseTheme>,
    contrast: MutableState<ComposeTheme.Contrast>,
    dynamic: MutableState<Boolean>,
    themeId: MutableState<String>,
): ThemePicker.State {
    val allThemes = ComposeTheme.getRegisteredThemes().sortedBy { it.fullName.lowercase() }
    val selectedTheme =
        remember(themeId.value) { derivedStateOf { allThemes.find { it.id == themeId.value } } }
    val isContrastEnabled = remember(
        dynamic.value,
        selectedTheme.value
    ) { derivedStateOf { !dynamic.value && selectedTheme.value?.supportsContrast() == true } }
    val isThemeEnabled = remember(dynamic.value) { derivedStateOf { !dynamic.value } }
    return ThemePicker.State(
        allThemes = allThemes,
        baseTheme = baseTheme,
        contrast = contrast,
        dynamic = dynamic,
        selectedThemeId = themeId,
        selectedTheme = selectedTheme,
        isContrastEnabled = isContrastEnabled,
        isThemeEnabled = isThemeEnabled
    )
}

@Composable
fun rememberMultiLevelThemePicker(
    state: ThemePicker.State
) : ThemePicker.MultiLevelState {

    val selectedCollection = remember { mutableStateOf(state.selectedTheme.value?.group?.collection) }
    val selectedGroup = remember { mutableStateOf(state.selectedTheme.value?.group) }
    val selectedVariant = remember { mutableStateOf(state.selectedTheme.value?.let { Variant(it) }) }
    val themesOfSelectedGroup by remember(selectedGroup.value) {
        derivedStateOf {
            state.allThemes.filter {
                it.group == selectedGroup.value
            }
        }
    }

    val collections = ComposeTheme.getRegisteredThemeGroups()
        .map { it.collection }
        .sortedBy { it.name }
        .distinct()
    val showCollectionPicker = collections.size > 1

    val groups by remember(selectedCollection.value) {
        derivedStateOf {
            state.allThemes
                .map { it.group }
                .filter { !showCollectionPicker || it.collection == selectedCollection.value }
                .distinct()
        }
    }

    val variants by remember(selectedGroup.value) {
        derivedStateOf {
            state.allThemes
                .filter { it.group == selectedGroup.value }
                .map { Variant(it) }
            //.distinct()
        }
    }
    val showVariantPicker by remember(variants.size) { derivedStateOf { variants.size > 1 } }

    if (showCollectionPicker) {
        LaunchedEffect(selectedCollection.value) {
            val collection = selectedCollection.value
            val g = selectedGroup.value?.takeIf { it.collection == collection } ?: collection?.allGroups?.first()
            if (g != null) {
                selectedGroup.value = g
                val v = selectedVariant.value
                val vIds = g.getVariantIds()
                if (v != null && !vIds.contains(v.id)) {
                    selectedVariant.value = v
                }
            }
        }
    }

    LaunchedEffect(selectedGroup.value, selectedVariant.value, showVariantPicker) {
        val group = selectedGroup.value

        if (group != null) {
            val defaultVariant = state.allThemes.find { it.variantId() == group.collection.defaultVariantId }?.let { Variant(it) }
            val newId = if (!showVariantPicker) {
                selectedVariant.value = defaultVariant
                group.themes.find { it.variantId() == defaultVariant?.id }?.id
            } else {
                var variant = selectedVariant.value
                if (variant == null || !group.getVariantIds().contains(variant.id)) {
                    selectedVariant.value = defaultVariant
                    variant = defaultVariant
                }
                group.themes.find { it.variantId() == variant?.id }?.id
            }
            if (newId != null) {
                state.selectedThemeId.value = newId
            }
        }
    }

    return ThemePicker.MultiLevelState(
        selectedCollection,
        selectedGroup,
        selectedVariant,
        collections,
        groups,
        variants,
        showCollectionPicker,
        showVariantPicker,
        themesOfSelectedGroup
    )

}