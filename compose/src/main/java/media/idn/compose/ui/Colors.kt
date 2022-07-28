package media.idn.compose.ui

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

object Neutral {
    val DarkWillow = Color(0xFF141714)
    val Bastille = Color(0xFF2C2E31)
    val BlackLead = Color(0xFF484C4E)
    val TarnishedSilver = Color(0xFF797D7F)
    val SilverCharm = Color(0xFFADB1B4)
    val CallaLily = Color(0xFFE5E9EC)
    val FlashWhite = Color(0xFFF2F4F6)
    val DoctorWhite = Color(0xFFFAFAFA)
    val White = Color(0xFFFFFFFF)
}

object Green {
    val FicusElastica = Color(0xFF08612E)
    val JordanJazz = Color(0xFF0C7D3B)
    val GrassCourt = Color(0xFF0A8B41)
    val Greenish = Color(0xFF3DA267)
    val YoungBamboo = Color(0xFF6DB98D)
    val OttoIce = Color(0xFFCEE8D9)
}

object Blue {
    val MondrianBlue = Color(0xFF0C468D)
    val AmnesiaBlue = Color(0xFF1760BC)
    val DeepSkyBlue = Color(0xFF1B78EB)
    val SeljukBlue = Color(0xFF4893EF)
    val FrenchBlue = Color(0xFF75AFF3)
    val Cloudless = Color(0xFFD0E4FB)
}

object Orange {
    val EmbarassedFrog = Color(0xFF92630A)
    val OldTrail = Color(0xFFC3840D)
    val Squash = Color(0xFFF4A511)
    val DairyMade = Color(0xFFF6B741)
    val ConsilkYellow = Color(0xFFF8C970)
    val SleepLamp = Color(0xFFFDEDCF)
}

object Purple {
    val AmericanPurple = Color(0xFF3D3273)
    val Blueberry = Color(0xFF51439A)
    val Circumorbital = Color(0xFF6654C0)
    val ModdyPurple = Color(0xFF8476CD)
    val SimplyViolet = Color(0xFFA398D9)
    val ChineseSilver = Color(0xFFE0DDF2)
}

object IDNMedia {
    val Netherworld = Color(0xFF8E1317)
    val SunScarlet = Color(0xFFBE1B1F)
    val OttomanRed = Color(0xFFED2227)
    val KhmerCury = Color(0xFFF14E52)
    val MomoPeach = Color(0xFFF47A7D)
    val MaryRose = Color(0xFFFBD2D4)
}

@Stable
class IDNColors(
    accent: Color,
    onAccent: Color,
    surface: Color,
    onSurface: Color,
    onSurfaceAlternative: Color,
    divider: Color,
    dividerAlternative: Color,
    isLight: Boolean,
) {
    var accent by mutableStateOf(accent)
        private set
    var onAccent by mutableStateOf(onAccent)
        private set
    var surface by mutableStateOf(surface)
        private set
    var onSurface by mutableStateOf(onSurface)
        private set
    var onSurfaceAlternative by mutableStateOf(onSurfaceAlternative)
        private set
    var divider by mutableStateOf(divider)
        private set
    var dividerAlternative by mutableStateOf(dividerAlternative)
        private set
    var isLight by mutableStateOf(isLight)
        private set

    fun update(other: IDNColors) {
        accent = other.accent
        onAccent = other.onAccent
        surface = other.surface
        onSurface = other.onSurface
        onSurfaceAlternative = other.onSurfaceAlternative
        divider = other.divider
        dividerAlternative = other.dividerAlternative
        isLight = other.isLight
    }
}

val LightThemeColors by lazy {
    IDNColors(
        accent = IDNMedia.OttomanRed,
        onAccent = Neutral.White,
        surface = Neutral.DoctorWhite,
        onSurface = Neutral.DarkWillow,
        onSurfaceAlternative = Neutral.TarnishedSilver,
        divider = Neutral.CallaLily,
        dividerAlternative = Neutral.CallaLily,
        isLight = true,
    )
}

val DarkThemeColors by lazy {
    IDNColors(
        accent = IDNMedia.KhmerCury,
        onAccent = Neutral.White,
        surface = Neutral.DarkWillow,
        onSurface = Neutral.DoctorWhite,
        onSurfaceAlternative = Neutral.SilverCharm,
        divider = Neutral.Bastille,
        dividerAlternative = Neutral.BlackLead,
        isLight = false,
    )
}
