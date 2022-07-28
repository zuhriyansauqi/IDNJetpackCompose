package media.idn.compose.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp

internal object RoundedCornerSize {
    val none = 0.dp
    val small = 8.dp
    val medium = 16.dp
    val large = 24.dp
}

@Stable
class IDNShapes(
    button: RoundedCornerShape,
    bottomSheet: RoundedCornerShape,
    chip: RoundedCornerShape,
) {
    var button by mutableStateOf(button)
        private set
    var bottomSheet by mutableStateOf(bottomSheet)
        private set
    var chip by mutableStateOf(chip)
        private set

    fun update(other: IDNShapes) {
        button = other.button
        bottomSheet = other.bottomSheet
        chip = other.chip
    }
}

val DefaultShapes by lazy {
    IDNShapes(
        button = RoundedCornerShape(RoundedCornerSize.small),
        bottomSheet = RoundedCornerShape(
            topStart = RoundedCornerSize.medium,
            topEnd = RoundedCornerSize.medium
        ),
        chip = RoundedCornerShape(RoundedCornerSize.large),
    )
}
