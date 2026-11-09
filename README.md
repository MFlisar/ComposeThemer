[![Maven Central](https://img.shields.io/maven-central/v/io.github.mflisar.composethemer/core?color=blue)](https://central.sonatype.com/artifact/io.github.mflisar.composethemer/core) ![API](https://img.shields.io/badge/api-24%2B-brightgreen.svg) ![Kotlin](https://img.shields.io/github/languages/top/MFlisar/ComposeThemer.svg?color=blueviolet) ![Kotlin Multiplatform](https://img.shields.io/badge/Kotlin_Multiplatform-blue?label=Kotlin)
# ComposeThemer
![Platforms](https://img.shields.io/badge/PLATFORMS-black?style=for-the-badge)

This library provides following main features:

* allows to define custom user themes and applies them automatically
* ability to retrieve all registered themes
* supports system ui theming (status bar + navigation bar)
* build on top of `MaterialTheme`
* supports *dynamic theming* as well as system and user *contrast* settings
* comes with optional collections of predefined themes
    * metro colors based theme collection
    * flat UI based theme collection
    * material 500 colors based theme collection
* offers some edgeToEdge helper functions

> [!NOTE]
> All features are splitted into separate modules, just include the modules you want to use!

> [!TIP]
> Try the interactive demo:
> 
> [![Open Interactive Demo](https://img.shields.io/badge/ComposeThemer_Demo-2962FF?style=for-the-badge&logo=googlechrome&logoColor=white)](https://mflisar.github.io/ComposeThemer/demo/)

# Table of Contents

- [Supported Platforms](#computer-supported-platforms)
- [Versions](#arrow_right-versions)
- [Setup](#wrench-setup)
- [Usage](#rocket-usage)
- [Demo](#sparkles-demo)
- [API](#books-api)
- [Other Libraries](#bulb-other-libraries)

# :computer: Supported Platforms

| Module | Notes |
|---|---|
| core | provides all the basic ComposeThemer classes to use and apply Themes |
| modules-picker | provides states and composables to create a theme picker UI |
| modules-defaultpicker | provides a default theme picker UI |
| themes-flatui | provides a list of themes based on the 20 flatui colors (each one in 5 variations) |
| themes-material500 | provides a list of themes based on the 19 material500 colors (each one in 5 variations) |
| themes-metro | provides a list of themes based on the 20 metro colors (each one in 5 variations) |

# :arrow_right: Versions

| Dependency | Version |
|---|---|
| Kotlin | `2.4.0` |
| Jetbrains Compose | `1.11.1` |
| Jetbrains Compose Material3 | `1.9.0` |

# :wrench: Setup

<details open>

<summary><b>Using Version Catalogs</b></summary>

<br>

Define the dependencies inside your **libs.versions.toml** file.

```toml
[versions]

composethemer = "<LATEST-VERSION>"

[libraries]

composethemer-core = { module = "io.github.mflisar.composethemer:core", version.ref = "composethemer" }
composethemer-modules-picker = { module = "io.github.mflisar.composethemer:modules-picker", version.ref = "composethemer" }
composethemer-modules-defaultpicker = { module = "io.github.mflisar.composethemer:modules-defaultpicker", version.ref = "composethemer" }
composethemer-themes-flatui = { module = "io.github.mflisar.composethemer:themes-flatui", version.ref = "composethemer" }
composethemer-themes-material500 = { module = "io.github.mflisar.composethemer:themes-material500", version.ref = "composethemer" }
composethemer-themes-metro = { module = "io.github.mflisar.composethemer:themes-metro", version.ref = "composethemer" }
```

And then use the definitions in your projects **build.gradle.kts** file like following:

```java
implementation(libs.composethemer.core)
implementation(libs.composethemer.modules.picker)
implementation(libs.composethemer.modules.defaultpicker)
implementation(libs.composethemer.themes.flatui)
implementation(libs.composethemer.themes.material500)
implementation(libs.composethemer.themes.metro)
```

</details>

<details>

<summary><b>Direct Dependency Notation</b></summary>

<br>

Simply add the dependencies inside your **build.gradle.kts** file.

```kotlin
val composethemer = "<LATEST-VERSION>"

implementation("io.github.mflisar.composethemer:core:${composethemer}")
implementation("io.github.mflisar.composethemer:modules-picker:${composethemer}")
implementation("io.github.mflisar.composethemer:modules-defaultpicker:${composethemer}")
implementation("io.github.mflisar.composethemer:themes-flatui:${composethemer}")
implementation("io.github.mflisar.composethemer:themes-material500:${composethemer}")
implementation("io.github.mflisar.composethemer:themes-metro:${composethemer}")
```

</details>

# :rocket: Usage

#### 1) Register available themes

You should do this once only, e.g. in your `Application` class.

```kotlin
// register all themes that you want to use (our just a subset of them, even a single one is enough)
val allThemes: List<ComposeTheme.Theme> =
    DefaultThemes.getAllThemes() +
            MetroThemes.getAllThemes() +
            FlatUIThemes.getAllThemes() +
            Material500Themes.getAllThemes()
ComposeTheme.register(*allThemes.toTypedArray())
```

## 2) Apply the theme

```kotlin

// create a state that holds the current theme settings
val baseTheme = rememberSaveable { mutableStateOf(ComposeTheme.BaseTheme.System) }
val contrast = rememberSaveable { mutableStateOf(ComposeTheme.Contrast.Normal) }
val dynamic = rememberSaveable { mutableStateOf(false) }
val theme = rememberSaveable { mutableStateOf(ThemeDefault.Theme.id) } // id of the current theme
val state = ComposeTheme.State(baseTheme, contrast, dynamic, theme)

// use ComposeTheme instead of MaterialTheme
ComposeTheme(state = state) {
    // app content
}
```

## 3) Navigation and statusbar theming

On android you can use `ComposeTheme` to set the status bar and navigation bar colors based on the current theme.

```kotlin
ComposeTheme(
    state = state
) {
    // set the color that you use behind the status bar and navigation bar (e.g. primary toolbar + surface bottom navigation)
    val statusBarColor = ...
    val navigationBarColor = ...

    // UpdateEdgeToEdgeDefault...helper function to easily enable edgeToEdge
    // SystemBarStyle also offers some extensions (statusBar, navigationBar, transparent) that can be used

    // this app draws a bottom navigation behind the navigation bar in portrait only, in landscape mode it doesn't
    val landscape = LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE
    val isDark = state.base.value.isDark()

    UpdateEdgeToEdgeDefault(
        activity = this,
        themeState = state,
        statusBarColor = statusBarColor,
        navigationBarColor = if (landscape) {
            SystemBarStyle.defaultScrim(resources, isDark)
        } else navigationBarColor,
        isNavigationBarContrastEnforced = landscape
    )
}
```

# :sparkles: Demo

A [demo project](demo) is included.

# :books: API

Check out the [API documentation](https://MFlisar.github.io/ComposeThemer/api/).

# :bulb: Other Libraries

You can find more of my multiplatform libraries that work well together [here](https://mflisar.github.io/Libraries/).

# :twisted_rightwards_arrows: Compatibility

When combining my libraries, you can find compatibility information [here](https://mflisar.github.io/Libraries/compatibilities/).
