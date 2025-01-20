package com.michaelflisar.composecustomtheme.demo

import android.app.Application
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.themes.ComposeThemes

class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // register available themes
        ComposeTheme.register(*ComposeThemes.ALL.toTypedArray())

        // or register some of them
        // ComposeTheme.register(
        //     ThemeAmberBlue.get(),
        //     ThemeAquaBlue.get(),
        //     ThemeBahamaAndTrinidad.get(),
        //     // ...
        // )

        // get a single theme
        // val theme = ThemeAmberBlue.get()

        // or register your own themes...
        // ...
    }
}