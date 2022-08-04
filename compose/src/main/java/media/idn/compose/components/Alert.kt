package media.idn.compose.components

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.animation.*
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import media.idn.compose.R
import media.idn.compose.ui.Green
import media.idn.compose.ui.IDNMedia
import media.idn.compose.ui.IDNTheme
import media.idn.compose.ui.Orange

const val EXPANSTION_TRANSITION_DURATION = 450

@Composable
fun IDNAlert(
    text: String,
    header: String = "",
    type: IDNAlert = IDNAlert.INFO,
    isExpandable: Boolean = false,
    content: @Composable () -> Unit,
) {
    var expandedState by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(IDNTheme.shapes.button)
            .background(type.backgroundColor)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            .clickable { expandedState = !expandedState }
            .padding(vertical = 16.dp, horizontal = 12.dp),
        verticalAlignment = if (expandedState)
            Alignment.Top
        else
            Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = type.id),
            contentDescription = null,
            tint = type.scrimColor,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f),
        ) {
            if (header.isNotEmpty()) {
                Text(
                    text = header,
                    style = IDNTheme.typography.caption2,
                    color = type.headerColor
                )
                Spacer(modifier = Modifier.height(4.dp))
            }
            Text(
                text = text,
                style = IDNTheme.typography.caption1,
                color = type.color,
                maxLines = if (expandedState) Int.MAX_VALUE else 2,
                overflow = TextOverflow.Ellipsis,
            )
        }
        if (isExpandable) {
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                painter = painterResource(
                    id =
                    if (expandedState)
                        R.drawable.ic_chevron_up
                    else
                        R.drawable.ic_chevron_down
                ),
                contentDescription = null,
                tint = type.scrimColor,
            )
        }
    }
}

enum class IDNAlert(@DrawableRes val id: Int) {
    INFO(R.drawable.ic_info_line),
    WARNING(R.drawable.ic_warning_line),
    SUCCESS(R.drawable.ic_success_line);

    val backgroundColor: Color
        @Composable
        get() = when (this) {
            INFO -> Orange.SleepLamp
            WARNING -> IDNMedia.MaryRose
            SUCCESS -> Green.OttoIce
        }

    val scrimColor: Color
        @Composable
        get() = when (this) {
            INFO -> Orange.Squash
            WARNING -> IDNMedia.OttomanRed
            SUCCESS -> Green.GrassCourt
        }

    val headerColor: Color
        @Composable
        get() = when (this) {
            INFO -> Orange.EmbarassedFrog
            WARNING -> IDNMedia.Netherworld
            SUCCESS -> Green.FicusElastica
        }

    val color: Color
        @Composable
        get() = when (this) {
            INFO -> Orange.OldTrail
            WARNING -> IDNMedia.SunScarlet
            SUCCESS -> Green.JordanJazz
        }
}

@Preview(
    name = "Regular Alert",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Regular Alert",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun IDNAlertPreview() {
    val lipsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
            " Quisque vitae odio vitae ligula iaculis convallis. " +
            "In tellus ligula, tincidunt vitae vestibulum eget, " +
            "sagittis id ante."
    IDNTheme {
        Surface(color = IDNTheme.colors.surface) {
            Column(modifier = Modifier.padding(16.dp)) {
                IDNAlert(
                    text = lipsum,
                    header = "This is a info header",
                    type = IDNAlert.INFO,
                    isExpandable = true,
                ) {

                }
                Spacer(modifier = Modifier.height(8.dp))
                IDNAlert(
                    text = lipsum,
                    header = "This is a warning header",
                    type = IDNAlert.WARNING,
                    isExpandable = true,
                ) {

                }
                Spacer(modifier = Modifier.height(8.dp))
                IDNAlert(
                    text = lipsum,
                    header = "This is a success header",
                    type = IDNAlert.SUCCESS,
                    isExpandable = true,
                ) {

                }
            }

        }
    }
}
