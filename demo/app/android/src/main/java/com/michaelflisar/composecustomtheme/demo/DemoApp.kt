package com.michaelflisar.composecustomtheme.demo

import android.app.Application
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.FlatUIThemes
import com.michaelflisar.composethemer.Material500Themes
import com.michaelflisar.composethemer.MetroThemes
import com.michaelflisar.composethemer.themes.DefaultThemes

class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // register available themes
        val allThemes: List<ComposeTheme.Theme> =
            DefaultThemes.getAllThemes() +
                    MetroThemes.getAllThemes() +
                    FlatUIThemes.getAllThemes() +
                    Material500Themes.getAllThemes()
        ComposeTheme.register(*allThemes.toTypedArray())

        // or register some of them
        // ComposeTheme.register(
        //     // Metro Themes
        //     MetroThemeLime.Analogic,
        //     MetroThemeLime.Mono,
        //     MetroThemeLime.Triade,
        //     MetroThemeLime.Complementary,
        //     MetroThemeLime.Tetrade,
        //     // ...
        // )

        // get a single theme
        // val theme = MetroThemeLime.Triade

        // or register your own themes...
        // ...
    }
}