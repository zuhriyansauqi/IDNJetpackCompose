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
    buttonText: String? = null,
    onButtonClick: () -> Unit = { },
    buttonDistance: Dp = 46.dp,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        IDNMessageInfo(
            title = title,
            subtitle = subtitle,
            cover = cover,
            isCenterGravity = true,
        )
        buttonText?.let {
            Spacer(modifier = Modifier.height(buttonDistance))
            IDNButton(
                onClick = onButtonClick,
                large = true,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = it,
                    style = IDNTheme.typography.button,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun IDNEmptyStatePreview() {
    IDNTheme {
        IDNEmptyState(
            title = "Halo boleh minta kontak kamu?",
            cover = IDNTheme.illustrations.left,
            buttonText = "Yuk ijinkan",
        )
    }
}