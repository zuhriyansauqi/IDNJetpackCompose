package media.idn.compose.components

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import media.idn.compose.ui.IDNTheme

@Composable
fun IDNDivider(
    isAlternative: Boolean = false
) {
    Divider(
        color = if (isAlternative) IDNTheme.colors.dividerAlternative else IDNTheme.colors.divider,
        thickness = 1.dp,
    )
}
