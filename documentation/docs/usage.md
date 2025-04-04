---
icon: material/keyboard
---

#### Register themes

You must register your themes. In an android app the `Application` is the perfect place to do it, in `jvm` somewhere outside of the application scope would be fine. Just make sure that this is only done once.

```kotlin

// register available themes
val allThemes: List<ComposeTheme.Theme<*>> = ComposeTheme.DEFAULT_ALL + MetroThemes.ALL
    // optionally filter themes based on their variants or whatever you want
    // .filter { it.variant == MetroThemeVariant.Triade }
ComposeTheme.register(*allThemes.toTypedArray())

// or register some of them
// ComposeTheme.register(
//     ThemeDefault.Default,
//     MetroThemeGreen.Analogic,
//     MetroThemeGreen.Mono,
//     MetroThemeGreen.Triade,
//     MetroThemeGreen.Complementary,
//     MetroThemeGreen.Tetrade,
//     // ...
// )

// get a single theme
// val theme =MetroThemeGreen.Analogic

// or register your own themes...
// ...

```

#### Usage

=== "Android"

    For android I do offer additional `edgeToEdge` features.

    ```kotlin
    // simply wrap your composable content inside ComposeTheme as if you would use MaterialTheme directly
    val baseTheme = remember { mutableStateOf(ComposeTheme.BaseTheme.System) }
    val contrast = remember { mutableStateOf(ComposeTheme.Contrast.Normal) }
    val dynamic = remember { mutableStateOf(false) }
    val theme = remember { mutableStateOf(ThemeDefault.Default.key) } // the key of a registered theme
    val state = ComposeTheme.State(baseTheme, contrast, dynamic, theme)
    ComposeTheme(state = state) {

        // update edgeToEdge to the correct styles with the provided helper functions
        // e.g. like following if the layout has a primary toolbar at top and nothing at bottom
        val landscape = LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE
        val isDark = state.base.value.isDark()
        UpdateEdgeToEdgeDefault(
            activity = this,
            themeState = state,
            statusBarColor = MaterialTheme.colorScheme.primary,
            navigationBarColor = if (landscape) {
                SystemBarStyle.defaultScrim(resources, isDark)
            } else MaterialTheme.colorScheme.background,
            isNavigationBarContrastEnforced = landscape
        )

        // content
    }
    ```

=== "Others"

    ```kotlin
    // simply wrap your composable content inside ComposeTheme as if you would use MaterialTheme directly
    val baseTheme = remember { mutableStateOf(ComposeTheme.BaseTheme.System) }
    val contrast = remember { mutableStateOf(ComposeTheme.Contrast.Normal) }
    val dynamic = remember { mutableStateOf(false) }
    val theme = remember { mutableStateOf(ThemeDefault.Default.key) } // the key of a registered theme
    val state = ComposeTheme.State(baseTheme, contrast, dynamic, theme)
    ComposeTheme(state = state) {
        // content
    }
    ```