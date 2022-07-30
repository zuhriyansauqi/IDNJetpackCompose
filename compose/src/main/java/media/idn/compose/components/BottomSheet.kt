package media.idn.compose.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
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
    contentPadding: PaddingValues = PaddingValues(horizontal = 24.dp),
    type: IDNBottomSheet = IDNBottomSheet.NoButton,
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

        when (type) {
            IDNBottomSheet.NoButton -> Unit
            is IDNBottomSheet.SingleButton ->
                SingleButton(
                    buttonText = type.text,
                    onButtonClick = type.onClick,
                )
            is IDNBottomSheet.SingleVariantButton ->
                SingleAlternativeButton(
                    buttonText = type.text,
                    onButtonClick = type.onClick,
                )
            is IDNBottomSheet.PositiveStartButton ->
                PositiveRightButton(
                    positiveText = type.positiveText,
                    negativeText = type.negativeText,
                    onNegativeButtonClick = type.onPositiveClick,
                    onPositiveButtonClick = type.onNegativeButtonClick,
                )
            is IDNBottomSheet.PositiveEndButton ->
                PositiveLeftButton(
                    positiveText = type.positiveText,
                    negativeText = type.negativeText,
                    onNegativeButtonClick = type.onPositiveClick,
                    onPositiveButtonClick = type.onNegativeButtonClick,
                )
        }
    }
}

@Composable
private fun PositiveLeftButton(
    positiveText: String,
    negativeText: String,
    onPositiveButtonClick: () -> Unit,
    onNegativeButtonClick: () -> Unit
) {
    Spacer(modifier = Modifier.height(24.dp))
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        PositiveButton(
            buttonText = positiveText,
            onButtonClick = onPositiveButtonClick
        )
        NegativeButton(
            buttonText = negativeText,
            onButtonClick = onNegativeButtonClick
        )
    }
}

@Composable
private fun PositiveRightButton(
    positiveText: String,
    negativeText: String,
    onNegativeButtonClick: () -> Unit,
    onPositiveButtonClick: () -> Unit
) {
    Spacer(modifier = Modifier.height(24.dp))
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        NegativeButton(
            buttonText = negativeText,
            onButtonClick = onNegativeButtonClick
        )
        PositiveButton(
            buttonText = positiveText,
            onButtonClick = onPositiveButtonClick
        )
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
    buttonText: String,
    onButtonClick: () -> Unit
) {
    Spacer(modifier = Modifier.height(24.dp))
    NegativeButton(
        buttonText = buttonText,
        onButtonClick = onButtonClick,
        isMaxWidth = true,
        modifier = Modifier.padding(horizontal = 24.dp)
    )
}

@Composable
private fun SingleButton(
    buttonText: String,
    onButtonClick: () -> Unit
) {
    Spacer(modifier = Modifier.height(24.dp))
    PositiveButton(
        buttonText = buttonText,
        onButtonClick = onButtonClick,
        isMaxWidth = true,
        modifier = Modifier.padding(horizontal = 24.dp)
    )
}

sealed class IDNBottomSheet {
    object NoButton : IDNBottomSheet()
    data class SingleButton(
        val text: String,
        val onClick: () -> Unit,
    ) : IDNBottomSheet()

    data class SingleVariantButton(
        val text: String,
        val onClick: () -> Unit,
    ) : IDNBottomSheet()

    data class PositiveStartButton(
        val positiveText: String,
        val negativeText: String,
        val onPositiveClick: () -> Unit,
        val onNegativeButtonClick: () -> Unit,
    ) : IDNBottomSheet()

    data class PositiveEndButton(
        val positiveText: String,
        val negativeText: String,
        val onPositiveClick: () -> Unit,
        val onNegativeButtonClick: () -> Unit,
    ) : IDNBottomSheet()
}

@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun IDNBottomSheetPreview() {
    IDNTheme {
        Surface(color = IDNTheme.colors.surface) {
            IDNBottomSheet(
                type = IDNBottomSheet.SingleVariantButton(
                    text = "Kembali",
                    onClick = { }
                ),
            ) {
                IDNIllustrationInfo(
                    title = "Kode referral sudah berhasil digunakan",
                    subtitle = "Yuk selesaikan misi dan dapatkan reward lebih",
                    cover = IDNIllustrations.Referral.emptyMissions
                )
            }
        }
    }
}