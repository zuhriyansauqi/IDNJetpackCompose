package media.idn.compose.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

@Composable
fun IDNTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) DarkThemeColors else LightThemeColors
    val typography = DefaultTypography
    val shapes = DefaultShapes

    ProvideIDNTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content,
    )
}

object IDNTheme {
    val colors: IDNColors
        @Composable get() = LocalIDNColors.current

    val typography: IDNTypography
        @Composable get() = LocalIDNTypography.current

    val shapes: IDNShapes
        @Composable get() = LocalIDNShapes.current

    val illustrations get() = IDNIllustrations
}
