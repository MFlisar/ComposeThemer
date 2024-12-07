### About

[![Maven](https://img.shields.io/maven-central/v/io.github.mflisar.composethemer/core?style=for-the-badge&color=blue)](https://central.sonatype.com/namespace/io.github.mflisar.composethemer)
[![API](https://img.shields.io/badge/api-21%2B-brightgreen.svg?style=for-the-badge)](https://android-arsenal.com/api?level=21)
[![Kotlin](https://img.shields.io/github/languages/top/mflisar/kotpreferences.svg?style=for-the-badge&color=blueviolet)](https://kotlinlang.org/)
[![KMP](https://img.shields.io/badge/Kotlin_Multiplatform-blue?style=for-the-badge&label=Kotlin)](https://kotlinlang.org/docs/multiplatform.html)
[![License](https://img.shields.io/github/license/MFlisar/ComposeThemer?style=for-the-badge)](LICENSE)

<h1 align="center">ComposeThemer</h1>

This is a **full compose theme engine** that handles applying a theme as well as updating the system ui elements. Extendible and allows to simply apply user selected themes inside your app.

## :heavy_check_mark: Features

* allows to define custom user themes and applies them automatically
* ability to retrieve all registered themes
* supports system ui theming (status bar + navigation bar)
* build on top of `MaterialTheme`
* comes with optional *59 build-in themes*
* offers some edgeToEdge helper functions

**All features are splitted into separate modules, just include the modules you want to use!**

## :camera: Screenshots

| ![Demo](screenshots/demo.gif?raw=true "Demo") |
| :-: |

## :link: Dependencies

|      Dependency       | Version |                     Infos                      |
|:---------------------:|:-------:|:----------------------------------------------:|
| Compose Multiplatform | `1.7.1` | based on compose `1.7.5` and material3 `1.3.1` |

> [!NOTE]  
> This library does not use any experimental compose APIs and therefore should be forward compatible with newer compose versions!

## :elephant: Gradle

This library is distributed via [maven central](https://central.sonatype.com/).

*build.gradle.kts*

```kts
val composethemer = "<LATEST-VERSION>"

// core module
implementation("io.github.mflisar.composethemer:core:$composethemer")

// extension module
implementation("io.github.mflisar.composethemer:themes:$composethemer")
```

## :zap: Modules

| Module   | Info | Description                                         |
|----------|------|-----------------------------------------------------|
| `core`   |      | the core module that provides all theming functions |
| `themes` |      | a collection of 59 predefined themes                |

## </> Basic Usage

Inside your application register all available themes (or at least one) like following:

```kotlin
class App : Application() {

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
```

Then use the `ComposeTheme` composable to apply the theme like following:

```kotlin
// simply wrap your composable content inside ComposeTheme as if you would use MaterialTheme directly
val baseTheme = remember { mutableStateOf(ComposeTheme.BaseTheme.System) }
val dynamic = remember { mutableStateOf(false) }
val theme = remember { mutableStateOf(ThemeGreenForest.KEY) } // the key of an registered theme
val state = ComposeTheme.State(baseTheme, dynamic, theme)
ComposeTheme(state = state) {

    // update edgeToEdge to the correct styles with the provided helper functions
    // e.g. like following if the layout has a primary toolbar at top and nothing at bottom
    // TIPP:
    // this functions has an overload that works with SystemBarStyle instead if you want to use that directly
    ComposeTheme.enableEdgeToEdge(
        activity = this,
        statusBarColor = MaterialTheme.colorScheme.primary,
        navigationBarColor = if (landscape) {
            SystemBarStyle.defaultScrim(resources)
        } else MaterialTheme.colorScheme.background,
        isNavigationBarContrastEnforced = landscape
    )

    // content
}
```

<details>
<summary>Themes Extension Module</summary>

```kotlin
// returns a list of all existing default themes
val themes = ComposeTheme.getRegisteredThemes()

// or get the default themes one by one (all named like Theme*)
val theme = ThemeAmberBlue.get()
// ... there are 59 predefined themes availabe ...
```

</details>

<details>
<summary>SystemBarStyle functions</summary>

I added some extensions to `SystemBarStyle.Companion`.

```kotlin
// following gives you a fully transparent SystemBarStyle or the default SystemBarStyle for the statusbar or navigationbar
SystemBarStyle.transparent()
SystemBarStyle.statusBar()
SystemBarStyle.navigationBar()
// this gives you the default scrim color that is normally defined privately aand can't be easily accessed
SystemBarStyle.defaultScrim(resource)
```

</details>

<details>
<summary>Disable the edgeToEdge mode</summary>

If desired, you can still use this library without using the edgeToEdge feature.

```kotlin
ComposeTheme(state = state, edgeToEdge = false) {
    // content
}
```

</details>

## :pray: Credits

This library contains 59 predefined color schemes inside the `themes` module. Those are all directly copied from [FlexColorScheme](https://rydmike.com/flexcolorscheme/themesplayground-latest/) - a very useful homepage that allows you to **create your own themes** and also contains 54 predefined themes already. With the permission of [Rydmike](https://github.com/rydmike) I just copied every single predefined theme from his homepage and added it to this library.


