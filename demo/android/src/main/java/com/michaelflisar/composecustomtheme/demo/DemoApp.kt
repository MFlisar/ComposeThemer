package com.michaelflisar.composecustomtheme.demo

import android.app.Application
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.MetroThemes

class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // register available themes
        val allThemes: List<ComposeTheme.Theme<*>> = ComposeTheme.DEFAULT_ALL +
                MetroThemes.ALL.map { it }
        //.filter { it.subGroupType == MetroThemes.SubGroup.Analogic }
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