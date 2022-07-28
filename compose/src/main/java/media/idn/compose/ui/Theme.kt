package media.idn.compose.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun IDNTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
// TODO: CRASH!!
//region systemUiController
//    val systemUiController = rememberSystemUiController()
//    val useDarkIcons = IDNTheme.colors.isLight
//
//    SideEffect {
//        systemUiController.setSystemBarsColor(
//            color = Color.Transparent,
//            darkIcons = useDarkIcons,
//        )
//    }
//endregion

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
}
