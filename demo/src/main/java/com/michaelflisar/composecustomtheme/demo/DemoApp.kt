package com.michaelflisar.composethemer.demo

import android.app.Application
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.themes.ComposeThemes
import com.michaelflisar.composethemer.themes.themes.ThemeAmberBlue

class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // register available themes
        ComposeTheme.register(*ComposeThemes.getAll(
            // optional - default value is Primary for statusbar and Default for navigation
            // statusBarColor = ComposeTheme.SystemUIColor.Surface,
            // navigationBarColor = ComposeTheme.SystemUIColor.Surface
        ).toTypedArray())

        // or register some of them
        // ComposeTheme.register(
        //     ThemeAmberBlue.get(),
        //     ThemeAquaBlue.get(),
        //     ThemeBahamaAndTrinidad.get(),
        //     // ...
        // )

        // get a single theme and customise it
        // val theme = ThemeAmberBlue.get(
        //     statusBarColor = ComposeTheme.SystemUIColor.Surface,
        //     navigationBarColor = ComposeTheme.SystemUIColor.Surface
        // )

        // or register your own themes...
        // ...
    }
}