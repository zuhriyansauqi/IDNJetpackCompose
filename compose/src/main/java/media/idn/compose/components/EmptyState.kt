package media.idn.compose.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import media.idn.compose.ui.IDNTheme

@Composable
fun IDNEmptyState(
    title: String,
    subtitle: String? = null,
    @DrawableRes cover: Int? = null,
    type: IDNEmptyState = IDNEmptyState.NoButton,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        IDNIllustrationInfo(
            title = title,
            subtitle = subtitle,
            cover = cover,
            isCenterGravity = true,
        )
        if (type is IDNEmptyState.SingleButton) {
            Spacer(modifier = Modifier.height(type.distance))
            IDNButton(
                onClick = type.onClick,
                large = true,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = type.text,
                    style = IDNTheme.typography.button,
                )
            }
        }
    }
}

sealed class IDNEmptyState {
    object NoButton : IDNEmptyState()
    data class SingleButton(
        val text: String,
        val onClick: () -> Unit,
        val distance: Dp = 46.dp,
    ) : IDNEmptyState()
}

@Preview(showBackground = true)
@Composable
private fun IDNEmptyStatePreview() {
    IDNTheme {
        IDNEmptyState(
            title = "Halo boleh minta kontak kamu?",
            cover = IDNTheme.illustrations.left,
            type = IDNEmptyState.SingleButton(
                text = "Yuk ijinkan",
                onClick = { }
            ),
        )
    }
}