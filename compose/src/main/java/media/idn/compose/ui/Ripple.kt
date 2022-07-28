package media.idn.compose.ui

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

@Stable
object IDNRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor(): Color = IDNTheme.colors.onSurface

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(
        contentColor = IDNTheme.colors.onSurface,
        lightTheme = IDNTheme.colors.isLight
    )
}
