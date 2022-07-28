package media.idn.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import media.idn.compose.resources.IDNIllustrations
import media.idn.compose.ui.IDNTheme

@Composable
fun IDNBottomSheet(
    title: String? = null,
    isMenu: Boolean = false,
    contentPadding: PaddingValues = PaddingValues(horizontal = if (isMenu) 0.dp else 24.dp),
    buttons: IDNBottomSheet = IDNBottomSheet.NO_BUTTON,
    buttonText: IDNBottomSheet.ButtonText = IDNBottomSheet.ButtonText(),
    onButtonClick: () -> Unit = { },
    onPositiveButtonClick: () -> Unit = { },
    onNegativeButtonClick: () -> Unit = { },
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 32.dp),
    ) {
        Box(
            modifier = Modifier
                .width(32.dp)
                .height(4.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(IDNTheme.colors.onSurface)
                .align(Alignment.CenterHorizontally)
        )

        title?.let {
            Text(
                text = it,
                style = IDNTheme.typography.headingMedium,
                color = IDNTheme.colors.onSurface,
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp),
            )
            IDNDivider()
        }

        Spacer(modifier = Modifier.height(24.dp))

        Box(Modifier.padding(contentPadding)) {
            content()
        }

        when (buttons) {
            IDNBottomSheet.NO_BUTTON -> Unit
            IDNBottomSheet.SINGLE_BUTTON ->
                SingleButton(
                    buttonText = buttonText,
                    onButtonClick = onButtonClick,
                )
            IDNBottomSheet.SINGLE_BUTTON_ALT ->
                SingleAlternativeButton(
                    buttonText = buttonText,
                    onButtonClick = onButtonClick,
                )
            IDNBottomSheet.POSITIVE_RIGHT ->
                PositiveRightButton(
                    buttonText = buttonText,
                    onNegativeButtonClick = onNegativeButtonClick,
                    onPositiveButtonClick = onPositiveButtonClick,
                )
            IDNBottomSheet.POSITIVE_LEFT ->
                PositiveLeftButton(
                    buttonText = buttonText,
                    onNegativeButtonClick = onNegativeButtonClick,
                    onPositiveButtonClick = onPositiveButtonClick,
                )
        }
    }
}

@Composable
private fun PositiveLeftButton(
    buttonText: IDNBottomSheet.ButtonText,
    onPositiveButtonClick: () -> Unit,
    onNegativeButtonClick: () -> Unit
) {
    Spacer(modifier = Modifier.height(24.dp))
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        PositiveButton(buttonText = buttonText.PositiveButton, onButtonClick = onPositiveButtonClick)
        NegativeButton(buttonText = buttonText.NegativeButton, onButtonClick = onNegativeButtonClick)
    }
}

@Composable
private fun PositiveRightButton(
    buttonText: IDNBottomSheet.ButtonText,
    onNegativeButtonClick: () -> Unit,
    onPositiveButtonClick: () -> Unit
) {
    Spacer(modifier = Modifier.height(24.dp))
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        NegativeButton(buttonText = buttonText.NegativeButton, onButtonClick = onNegativeButtonClick)
        PositiveButton(buttonText = buttonText.PositiveButton, onButtonClick = onPositiveButtonClick)
    }
}

@Composable
private fun NegativeButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    isMaxWidth: Boolean = false,
    onButtonClick: () -> Unit
) {
    IDNOutlinedButton(
        onClick = onButtonClick,
        large = true,
        modifier = if (isMaxWidth) modifier.fillMaxWidth() else modifier
    ) {
        Text(
            text = buttonText,
            style = IDNTheme.typography.button
        )
    }
}

@Composable
private fun PositiveButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    isMaxWidth: Boolean = false,
    onButtonClick: () -> Unit,
) {
    IDNButton(
        onClick = onButtonClick,
        large = true,
        modifier = if (isMaxWidth) modifier.fillMaxWidth() else modifier
    ) {
        Text(
            text = buttonText,
            style = IDNTheme.typography.button
        )
    }
}

@Composable
private fun SingleAlternativeButton(
    buttonText: IDNBottomSheet.ButtonText,
    onButtonClick: () -> Unit
) {
    Spacer(modifier = Modifier.height(24.dp))
    NegativeButton(
        buttonText = buttonText.SingleButton,
        onButtonClick = onButtonClick,
        isMaxWidth = true,
        modifier = Modifier.padding(horizontal = 24.dp)
    )
}

@Composable
private fun SingleButton(
    buttonText: IDNBottomSheet.ButtonText,
    onButtonClick: () -> Unit
) {
    Spacer(modifier = Modifier.height(24.dp))
    PositiveButton(
        buttonText = buttonText.SingleButton,
        onButtonClick = onButtonClick,
        isMaxWidth = true,
        modifier = Modifier.padding(horizontal = 24.dp)
    )
}

enum class IDNBottomSheet {
    NO_BUTTON,
    SINGLE_BUTTON,
    SINGLE_BUTTON_ALT,
    POSITIVE_RIGHT,
    POSITIVE_LEFT;

    data class ButtonText(
        val SingleButton: String = "",
        val PositiveButton: String = "",
        val NegativeButton: String = "",
    )
}

@Preview(showBackground = true)
@Composable
private fun IDNBottomSheetPreview() {
    IDNTheme {
        IDNBottomSheet(
            buttons = IDNBottomSheet.SINGLE_BUTTON_ALT,
            buttonText = IDNBottomSheet.ButtonText(SingleButton = "Kembali"),
        ) {
            IDNMessageInfo(
                title = "Kode referral sudah berhasil digunakan",
                subtitle = "Yuk selesaikan misi dan dapatkan reward lebih",
                cover = IDNIllustrations.Referral.emptyMissions
            )
        }
    }
}