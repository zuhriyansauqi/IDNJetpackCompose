package media.idn.compose.components

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import media.idn.compose.ui.IDNTheme

@Composable
fun IDNDivider(
    type: IDNDivider = IDNDivider.NORMAL
) {
    Divider(
        color = type.color,
        thickness = 1.dp,
    )
}

enum class IDNDivider {
    NORMAL,
    VARIANT;

    val color: Color
        @Composable
        get() = when (this) {
            NORMAL -> IDNTheme.colors.divider
            VARIANT -> IDNTheme.colors.dividerAlternative
        }
}
