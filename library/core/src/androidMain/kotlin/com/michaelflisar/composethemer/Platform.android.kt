package com.michaelflisar.composethemer

import android.os.Build

actual val ComposeTheme.isDynamicColorsSupported: Boolean
    get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

actual val ComposeTheme.isContrastAvailable: Boolean
    get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE

actual val ComposeTheme.isSystemContrastSupported: Boolean
    get() = isContrastAvailable
