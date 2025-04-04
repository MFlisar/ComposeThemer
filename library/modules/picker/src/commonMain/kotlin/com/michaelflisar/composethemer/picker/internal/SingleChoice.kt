package com.michaelflisar.composethemer.picker.internal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun <T> SingleChoice(
    modifier: Modifier,
    items: List<T>,
    selected: MutableState<T>,
    labelProvider: @Composable (item: T) -> Unit,
    iconProvider: @Composable (item: T) -> Unit,
    enabled: Boolean = true
) {
    SingleChoiceSegmentedButtonRow(modifier) {
        items.forEachIndexed { index, item ->
            SegmentedButton(
                selected = selected.value == item,
                onClick = { selected.value = item },
                shape = SegmentedButtonDefaults.itemShape(index = index, count = items.size),
                enabled = enabled
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    iconProvider(item)
                    labelProvider(item)
                }
            }
        }
    }
}