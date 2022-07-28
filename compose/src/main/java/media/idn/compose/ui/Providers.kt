package media.idn.compose.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalIDNColors = staticCompositionLocalOf<IDNColors> { error("No IDNColors Provided") }
internal val LocalIDNTypography =
    staticCompositionLocalOf<IDNTypography> { error("No IDNTypography Provided") }
internal val LocalIDNShapes = staticCompositionLocalOf<IDNShapes> { error("No IDNShapes Provided") }

@Composable
fun ProvideIDNTheme(
    colors: IDNColors,
    typography: IDNTypography,
    shapes: IDNShapes,
    content: @Composable () -> Unit,
) {
    val colorPalette = remember { colors }
    val defaultTypography = remember { typography }
    val defaultShapes = remember { shapes }

    colorPalette.update(colors)
    defaultTypography.update(typography)
    defaultShapes.update(shapes)

    CompositionLocalProvider(
        LocalIDNColors provides colorPalette,
        LocalIDNTypography provides defaultTypography,
        LocalIDNShapes provides defaultShapes,
        content = content,
    )
}
