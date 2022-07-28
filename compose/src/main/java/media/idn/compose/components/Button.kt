package media.idn.compose.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import media.idn.compose.ui.IDNTheme

val buttonColors
    @Composable get() = ButtonDefaults.buttonColors(
        backgroundColor = IDNTheme.colors.accent,
        contentColor = IDNTheme.colors.onAccent,
        disabledBackgroundColor = IDNTheme.colors.accent.copy(alpha = 0.3f),
        disabledContentColor = IDNTheme.colors.onAccent,
    )

@Composable
fun IDNButton(
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
        border = null,
        colors = buttonColors,
        contentPadding = contentPadding,
        content = content,
    )
}

@Preview(showBackground = true)
@Composable
private fun IDNButtonPreview() {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        IDNTheme(darkTheme = false) {
            IDNButtonExample(text = "Day")
        }
        IDNTheme(darkTheme = true) {
            IDNButtonExample(text = "Night")
        }
    }
}

@Composable
private fun IDNButtonExample(text: String) {
    IDNButton(
        onClick = {},
        large = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = text, style = IDNTheme.typography.button)
    }
}
