package com.michaelflisar.composethemer.picker.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

object ThemeColorPreview {
    enum class Type {
        Primary,
        All
    }
}

@Composable
fun ThemeColorPreview(
    colorScheme: ColorScheme?,
    preview: ThemeColorPreview.Type = ThemeColorPreview.Type.All
) {
    if (colorScheme != null) {
        val lineHeight = with(LocalDensity.current) { LocalTextStyle.current.lineHeight.toDp() }
        Canvas(
            modifier = Modifier.size(lineHeight).clip(RoundedCornerShape(size = 4.dp))
        ) {

            val w = size.width
            val h = size.height
            val strokeWidth = 1.dp.toPx()

            when (preview) {
                ThemeColorPreview.Type.Primary -> {
                    drawRect(
                        color = colorScheme.primary,
                        topLeft = Offset(0f, 0f),
                        size = Size(w, h),
                        style = Fill
                    )
                }

                ThemeColorPreview.Type.All -> {
                    drawRect(
                        color = colorScheme.primary,
                        topLeft = Offset(0f, 0f),
                        size = Size(w / 2f, h),
                        style = Fill
                    )
                    drawRect(
                        color = colorScheme.secondary,
                        topLeft = Offset(w / 2f, 0f),
                        size = Size(w / 2f, h / 2f),
                        style = Fill
                    )
                    drawRect(
                        color = colorScheme.tertiary,
                        topLeft = Offset(w / 2f, h / 2f),
                        size = Size(w / 2f, h / 2f),
                        style = Fill
                    )
                    drawLine(
                        color = colorScheme.background,
                        start = Offset(w / 2f, h / 2f),
                        end = Offset(w, h / 2f),
                        strokeWidth = strokeWidth
                    )
                    drawLine(
                        color = colorScheme.background,
                        start = Offset(w / 2f, 0f),
                        end = Offset(w / 2f, h),
                        strokeWidth = strokeWidth
                    )
                }
            }
        }
    }
}