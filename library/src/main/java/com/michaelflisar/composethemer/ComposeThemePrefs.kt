package com.michaelflisar.composethemer

import com.michaelflisar.materialpreferences.core.interfaces.StorageSetting

interface ComposeThemePrefs {

    // Main Colors
    val primary: StorageSetting<Int>
    val onPrimary: StorageSetting<Int>
    val secondary: StorageSetting<Int>
    val onSecondary: StorageSetting<Int>
    val tertiary: StorageSetting<Int>
    val onTertiary: StorageSetting<Int>
    
    // Container
    val primaryContainer: StorageSetting<Int>
    val onPrimaryContainer: StorageSetting<Int>
    val secondaryContainer: StorageSetting<Int>
    val onSecondaryContainer: StorageSetting<Int>
    val tertiaryContainer: StorageSetting<Int>
    val onTertiaryContainer: StorageSetting<Int>

    // Background/Surface
    val background: StorageSetting<Int>
    val onBackground: StorageSetting<Int>
    val surface: StorageSetting<Int>
    val onSurface: StorageSetting<Int>
    val surfaceVariant: StorageSetting<Int>
    val onSurfaceVariant: StorageSetting<Int>
    val surfaceTint: StorageSetting<Int>
            
    // Inverse
    val inversePrimary: StorageSetting<Int>
    val inverseSurface: StorageSetting<Int>
    val inverseOnSurface: StorageSetting<Int>
            
    // Specials
    val error: StorageSetting<Int>
    val onError: StorageSetting<Int>
    val errorContainer: StorageSetting<Int>
    val onErrorContainer: StorageSetting<Int>
    val outline: StorageSetting<Int>
    val outlineVariant: StorageSetting<Int>
    val scrim: StorageSetting<Int>

    fun settings() : List<StorageSetting<*>>

    suspend fun reset() {
        settings().forEach {
            (it as? StorageSetting<Int>)?.let {
                it.update(it.defaultValue)
            }
        }
    }
}