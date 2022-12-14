package media.idn.compose.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import media.idn.compose.ui.IDNTheme

@Composable
fun IDNIllustrationInfo(
    title: String,
    subtitle: String? = null,
    @DrawableRes cover: Int? = null,
    isCenterGravity: Boolean = false,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (isCenterGravity) Alignment.CenterHorizontally else Alignment.Start
    ) {
        cover?.let {
            Image(
                painter = painterResource(id = it),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
        Text(
            text = title,
            style = IDNTheme.typography.headingMedium,
            color = IDNTheme.colors.onSurface,
        )
        subtitle?.let {
            Text(
                text = it,
                style = IDNTheme.typography.caption1,
                color = IDNTheme.colors.onSurfaceAlternative,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Preview(
    name = "Day Mode",
    uiMode = UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night Mode",
    uiMode = UI_MODE_NIGHT_YES,
)
@Composable
fun IDNMessageInfoPreview() {
    IDNTheme {
        Surface(color = IDNTheme.colors.surface) {
            IDNIllustrationInfo(
                title = "Kode referral sudah berhasil digunakan",
                subtitle = "Yuk selesaikan misi dan dapatkan reward lebih",
                cover = IDNTheme.illustrations.point
            )
        }
    }
}