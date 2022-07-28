package media.idn.compose.ui

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import media.idn.compose.R

object Lato {
    val Regular = Font(R.font.lato_regular)
    val Italic = Font(R.font.lato_italic, style = FontStyle.Italic)
    val Bold = Font(R.font.lato_bold, weight = FontWeight.Bold)
    val BoldItalic =
        Font(R.font.lato_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic)
    val Black = Font(R.font.lato_black, weight = FontWeight.Black)
    val BlackItalic =
        Font(R.font.lato_black_italic, weight = FontWeight.Black, style = FontStyle.Italic)
}

val LatoFontFamily = FontFamily(
    Lato.Regular, Lato.Italic,
    Lato.Bold, Lato.BoldItalic,
    Lato.Black, Lato.BlackItalic
)

@Stable
internal class TextSize(
    val body: TextUnit,
    val bodySmall: TextUnit,
    val headingSmall: TextUnit,
    val headingMedium: TextUnit,
    val headingLarge: TextUnit,
    val headingExtraLarge: TextUnit,
    val headingHuge: TextUnit,
    val headingExtraHuge: TextUnit,
    val paragraph: TextUnit,
    val paragraphSmall: TextUnit,
    val caption: TextUnit,
    val footnote: TextUnit,
    val button: TextUnit,
    val buttonSmall: TextUnit,
    val headline: TextUnit,
    val notification: TextUnit,
)

@Stable
internal class TextLineHeight(
    val body: TextUnit,
    val bodySmall: TextUnit,
    val headingSmall: TextUnit,
    val headingMedium: TextUnit,
    val headingLarge: TextUnit,
    val headingExtraLarge: TextUnit,
    val headingHuge: TextUnit,
    val headingExtraHuge: TextUnit,
    val paragraph: TextUnit,
    val paragraphSmall: TextUnit,
    val caption: TextUnit,
    val footnote: TextUnit,
    val button: TextUnit,
    val buttonSmall: TextUnit,
    val headline: TextUnit,
    val notification: TextUnit,
)

@Stable
class IDNTypography(
    body1: TextStyle,
    body1Small: TextStyle,
    body2: TextStyle,
    body2Small: TextStyle,
    headingSmall: TextStyle,
    headingMedium: TextStyle,
    headingLarge: TextStyle,
    headingExtraLarge: TextStyle,
    headingHuge: TextStyle,
    headingExtraHuge: TextStyle,
    paragraph: TextStyle,
    paragraphSmall: TextStyle,
    caption1: TextStyle,
    caption2: TextStyle,
    footnote1: TextStyle,
    footnote2: TextStyle,
    button: TextStyle,
    buttonSmall: TextStyle,
    headline: TextStyle,
    notification: TextStyle,
) {
    var body1 by mutableStateOf(body1)
        private set
    var bodySmall1 by mutableStateOf(body1Small)
        private set
    var body2 by mutableStateOf(body2)
        private set
    var bodySmall2 by mutableStateOf(body2Small)
        private set
    var headingSmall by mutableStateOf(headingSmall)
        private set
    var headingMedium by mutableStateOf(headingMedium)
        private set
    var headingLarge by mutableStateOf(headingLarge)
        private set
    var headingExtraLarge by mutableStateOf(headingExtraLarge)
        private set
    var headingHuge by mutableStateOf(headingHuge)
        private set
    var headingExtraHuge by mutableStateOf(headingExtraHuge)
        private set
    var paragraph by mutableStateOf(paragraph)
        private set
    var paragraphSmall by mutableStateOf(paragraphSmall)
        private set
    var caption1 by mutableStateOf(caption1)
        private set
    var caption2 by mutableStateOf(caption2)
        private set
    var footnote1 by mutableStateOf(footnote1)
        private set
    var footnote2 by mutableStateOf(footnote2)
        private set
    var button by mutableStateOf(button)
        private set
    var buttonSmall by mutableStateOf(buttonSmall)
        private set
    var headline by mutableStateOf(headline)
        private set
    var notification by mutableStateOf(notification)
        private set


    fun update(other: IDNTypography) {
        body1 = other.body1
        bodySmall1 = other.bodySmall1
        body2 = other.body2
        bodySmall2 = other.bodySmall2
        headingSmall = other.headingSmall
        headingMedium = other.headingMedium
        headingLarge = other.headingLarge
        headingExtraLarge = other.headingExtraLarge
        headingHuge = other.headingHuge
        headingExtraHuge = other.headingExtraHuge
        paragraph = other.paragraph
        paragraphSmall = other.paragraphSmall
        caption1 = other.caption1
        caption2 = other.caption2
        footnote1 = other.footnote1
        footnote2 = other.footnote2
        button = other.button
        buttonSmall = other.buttonSmall
        headline = other.headline
        notification = other.notification
    }
}

internal val IDNTextSize = TextSize(
    body = 16.sp,
    bodySmall = 14.sp,
    headingSmall = 14.sp,
    headingMedium = 16.sp,
    headingLarge = 18.sp,
    headingExtraLarge = 20.sp,
    headingHuge = 24.sp,
    headingExtraHuge = 28.sp,
    paragraph = 16.sp,
    paragraphSmall = 14.sp,
    caption = 14.sp,
    footnote = 11.sp,
    button = 14.sp,
    buttonSmall = 12.sp,
    headline = 11.sp,
    notification = 10.sp,
)

internal val IDNTextLineHeight = TextLineHeight(
    body = IDNTextSize.body.times(1.5.sp.value),
    bodySmall = IDNTextSize.bodySmall.times(1.6.sp.value),
    headingSmall = IDNTextSize.headingSmall.times(1.35.sp.value),
    headingMedium = IDNTextSize.headingMedium.times(1.3.sp.value),
    headingLarge = IDNTextSize.headingLarge.times(1.3.sp.value),
    headingExtraLarge = IDNTextSize.headingExtraLarge.times(1.3.sp.value),
    headingHuge = IDNTextSize.headingHuge.times(1.25.sp.value),
    headingExtraHuge = IDNTextSize.headingExtraHuge.times(1.25.sp.value),
    paragraph = IDNTextSize.paragraph.times(1.6.sp.value),
    paragraphSmall = IDNTextSize.paragraphSmall.times(1.6.sp.value),
    caption = IDNTextSize.caption.times(1.6.sp.value),
    footnote = IDNTextSize.footnote.times(1.4.sp.value),
    button = TextUnit.Unspecified,
    buttonSmall = TextUnit.Unspecified,
    headline = TextUnit.Unspecified,
    notification = TextUnit.Unspecified,
)

val DefaultTypography by lazy {
    IDNTypography(
        body1 = TextStyle(
            fontFamily = FontFamily(Lato.Regular),
            fontSize = IDNTextSize.body,
            lineHeight = IDNTextLineHeight.body,
        ),
        body1Small = TextStyle(
            fontFamily = FontFamily(Lato.Regular),
            fontSize = IDNTextSize.bodySmall,
            lineHeight = IDNTextLineHeight.bodySmall,
        ),
        body2 = TextStyle(
            fontFamily = FontFamily(Lato.Bold),
            fontSize = IDNTextSize.body,
            lineHeight = IDNTextLineHeight.body,
        ),
        body2Small = TextStyle(
            fontFamily = FontFamily(Lato.Bold),
            fontSize = IDNTextSize.bodySmall,
            lineHeight = IDNTextLineHeight.bodySmall,
        ),
        headingSmall = TextStyle(
            fontFamily = FontFamily(Lato.Black),
            fontSize = IDNTextSize.headingSmall,
            lineHeight = IDNTextLineHeight.headingSmall,
        ),
        headingMedium = TextStyle(
            fontFamily = FontFamily(Lato.Black),
            fontSize = IDNTextSize.headingMedium,
            lineHeight = IDNTextLineHeight.headingMedium,
        ),
        headingLarge = TextStyle(
            fontFamily = FontFamily(Lato.Black),
            fontSize = IDNTextSize.headingLarge,
            lineHeight = IDNTextLineHeight.headingLarge,
        ),
        headingExtraLarge = TextStyle(
            fontFamily = FontFamily(Lato.Black),
            fontSize = IDNTextSize.headingExtraLarge,
            lineHeight = IDNTextLineHeight.headingExtraLarge,
            letterSpacing = IDNTextSize.headingExtraLarge.times((-0.005).sp.value),
        ),
        headingHuge = TextStyle(
            fontFamily = FontFamily(Lato.Black),
            fontSize = IDNTextSize.headingHuge,
            lineHeight = IDNTextLineHeight.headingHuge,
            letterSpacing = IDNTextSize.headingHuge.times((-0.005).sp.value),
        ),
        headingExtraHuge = TextStyle(
            fontFamily = FontFamily(Lato.Black),
            fontSize = IDNTextSize.headingExtraHuge,
            lineHeight = IDNTextLineHeight.headingExtraHuge,
            letterSpacing = IDNTextSize.headingExtraHuge.times((-0.005).sp.value),
        ),
        paragraph = TextStyle(
            fontFamily = LatoFontFamily,
            fontSize = IDNTextSize.paragraph,
            lineHeight = IDNTextLineHeight.paragraph,
        ),
        paragraphSmall = TextStyle(
            fontFamily = LatoFontFamily,
            fontSize = IDNTextSize.paragraphSmall,
            lineHeight = IDNTextLineHeight.paragraphSmall,
        ),
        caption1 = TextStyle(
            fontFamily = FontFamily(Lato.Regular),
            fontSize = IDNTextSize.caption,
            lineHeight = IDNTextLineHeight.caption,
        ),
        caption2 = TextStyle(
            fontFamily = FontFamily(Lato.Bold),
            fontSize = IDNTextSize.caption,
            lineHeight = IDNTextLineHeight.caption,
        ),
        footnote1 = TextStyle(
            fontFamily = FontFamily(Lato.Regular),
            fontSize = IDNTextSize.footnote,
            lineHeight = IDNTextLineHeight.footnote,
        ),
        footnote2 = TextStyle(
            fontFamily = FontFamily(Lato.Bold),
            fontSize = IDNTextSize.footnote,
            lineHeight = IDNTextLineHeight.footnote,
        ),
        button = TextStyle(
            fontFamily = FontFamily(Lato.Bold),
            fontSize = IDNTextSize.button,
            lineHeight = IDNTextLineHeight.button,
        ),
        buttonSmall = TextStyle(
            fontFamily = FontFamily(Lato.Bold),
            fontSize = IDNTextSize.buttonSmall,
            lineHeight = IDNTextLineHeight.buttonSmall,
        ),
        headline = TextStyle(
            fontFamily = FontFamily(Lato.Bold),
            fontSize = IDNTextSize.headline,
            lineHeight = IDNTextLineHeight.headline,
            letterSpacing = IDNTextSize.headingExtraLarge.times(0.1.sp.value),
        ),
        notification = TextStyle(
            fontFamily = FontFamily(Lato.Black),
            fontSize = IDNTextSize.notification,
            lineHeight = IDNTextLineHeight.notification,
        ),
    )
}
