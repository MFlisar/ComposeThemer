package com.michaelflisar.composecustomtheme.demo

import android.app.Application
import com.michaelflisar.composecustomtheme.ComposeTheme
import com.michaelflisar.composecustomthemes.defaultthemes.ComposeThemeDefaults

class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // register available themes
        ComposeTheme.register(*ComposeThemeDefaults.getAllThemes().toTypedArray())

        // or register some of them
        // ComposeTheme.register(
        //     ComposeThemeDefaults.greenTheme(),
        //     ComposeThemeDefaults.blueTheme(),
        //     ComposeThemeDefaults.redTheme(),
        //     // ...
        // )

        // or register your own themes...
        // ...
    }
}