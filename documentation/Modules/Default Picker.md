This module provides a default theme picker ui implementation.

<!-- snippet: DefaultThemePicker -->
```kt
@Composable
fun DefaultThemePicker(
    modifier: Modifier,
    baseTheme: MutableState<ComposeTheme.BaseTheme>,
    contrast: MutableState<ComposeTheme.Contrast>,
    dynamic: MutableState<Boolean>,
    theme: MutableState<String>,
    singleLevelThemePicker: Boolean,
    labelWidth: Dp = 128.dp,
    labelBaseTheme: String = "Base Theme",
    labelContrast: String = "Contrast",
    labelDynamic: String = "Dynamic Colors",
    labelTheme: String = "Theme",
    filterLabel: String = "Filter",
    filterPlaceholder: String = "Search in themes",
    imageVectorSystem: ImageVector? = Icons.Default.LaptopWindows,
    baseThemeContent: @Composable (item: ComposeTheme.BaseTheme?, data: SingleChoice.ItemData) -> Unit = { item, data ->
        val icon = when (item) {
            ComposeTheme.BaseTheme.Dark -> Icons.Default.DarkMode
            ComposeTheme.BaseTheme.Light -> Icons.Default.LightMode
            ComposeTheme.BaseTheme.System -> imageVectorSystem
            else -> null
        }
        DefaultThemePickerIconTextContent(data, icon = icon, text = item?.name)
    },
    contrastContent: @Composable (item: ComposeTheme.Contrast?, data: SingleChoice.ItemData) -> Unit = { item, data ->
        val icon = when (item) {
            ComposeTheme.Contrast.Normal -> Icons.Default.BrightnessLow
            ComposeTheme.Contrast.Medium -> Icons.Default.BrightnessMedium
            ComposeTheme.Contrast.High -> Icons.Default.BrightnessHigh
            ComposeTheme.Contrast.System -> imageVectorSystem
            else -> null
        }
        DefaultThemePickerIconTextContent(data, icon = icon, text = item?.name)
    },
)
```
<!-- endSnippet -->
