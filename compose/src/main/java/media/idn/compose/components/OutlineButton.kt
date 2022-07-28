package media.idn.compose.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import media.idn.compose.ui.IDNTheme

val outlinedButtonColors
    @Composable get() = ButtonDefaults.buttonColors(
        backgroundColor = Color.Transparent,
        contentColor = IDNTheme.colors.accent,
        disabledBackgroundColor = Color.Transparent,
        disabledContentColor = IDNTheme.colors.accent.copy(alpha = 0.3f),
    )

@Composable
fun IDNOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    large: Boolean = false,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(if (large) 48.dp else 32.dp),
        enabled = enabled,
        interactionSource = interactionSource,
        elevation = elevation,
        shape = IDNTheme.shapes.button,
        border = BorderStroke(1.dp, IDNTheme.colors.accent),
        colors = outlinedButtonColors,
        contentPadding = contentPadding,
        content = content,
    )
}

@Preview
@Composable
private fun IDNOutlinedButtonPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth(),
    ) {
        IDNTheme(darkTheme = false) {
            Surface(color = IDNTheme.colors.surface) {
                IDNOutlinedButton(onClick = {}, modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                    Text(text = "Day", style = IDNTheme.typography.buttonSmall)
                }
            }
        }
        IDNTheme(darkTheme = true) {
            Surface(color = IDNTheme.colors.surface) {
                IDNOutlinedButton(onClick = {}, large = true, modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                    Text(text = "Night", style = IDNTheme.typography.button)
                }
            }
        }
    }
}
