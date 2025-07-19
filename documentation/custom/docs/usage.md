---
icon: material/keyboard
---

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

// save the desired statusbar and navigation bar colors somehow
val statusBarColorPrimary = rememberSaveable { mutableStateOf(true) }
val navigationBarColorPrimary = rememberSaveable { mutableStateOf(true) }

ComposeTheme(
    state = state
) {
    val primary = MaterialTheme.colorScheme.primary
    val background = MaterialTheme.colorScheme.background

    val statusBarColor = remember(statusBarColorPrimary.value, primary, background) {
        derivedStateOf { if (statusBarColorPrimary.value) primary else background }
    }
    val navigationBarColor =
        remember(navigationBarColorPrimary.value, primary, background) {
            derivedStateOf { if (navigationBarColorPrimary.value) primary else background }
        }

    // Statusbar and Navigation Bar is drawn in primary color -> we use this to detect the dark mode for the system bars
    
    // UpdateEdgeToEdgeDefault...helper function to easily enable edgeToEdge
    // SystemBarStyle also offers some extensions (statusBar, navigationBar, transparent) that can be used

    // this app draws a bottom navigation behind the navigation bar in portrait only, in landscape mode it doesn't
    // => landscape may
    val landscape = LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE
    val isDark = state.base.value.isDark()

    UpdateEdgeToEdgeDefault(
        activity = this,
        themeState = state,
        statusBarColor = statusBarColor.value,
        navigationBarColor = if (landscape) {
            SystemBarStyle.defaultScrim(resources, isDark)
        } else navigationBarColor.value,
        isNavigationBarContrastEnforced = landscape
    )
}
```

