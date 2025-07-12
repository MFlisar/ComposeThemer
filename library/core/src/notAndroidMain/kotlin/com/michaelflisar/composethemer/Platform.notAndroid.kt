package com.michaelflisar.composethemer

actual val ComposeTheme.isDynamicColorsSupported: Boolean
    get() = false

actual val ComposeTheme.isContrastAvailable: Boolean
    get() = false

actual val ComposeTheme.isSystemContrastSupported: Boolean
    get() = isContrastAvailable