package com.michaelflisar.composecustomthemes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.michaelflisar.composecustomtheme.ComposeTheme
import com.michaelflisar.composecustomthemes.themes.themes.ThemeAmberBlue
import com.michaelflisar.composecustomthemes.themes.themes.ThemeAquaBlue
import com.michaelflisar.composecustomthemes.themes.themes.ThemeBahamaAndTrinidad
import com.michaelflisar.composecustomthemes.themes.themes.ThemeBarossa
import com.michaelflisar.composecustomthemes.themes.themes.ThemeBigStoneTulip
import com.michaelflisar.composecustomthemes.themes.themes.ThemeBlueDelight
import com.michaelflisar.composecustomthemes.themes.themes.ThemeBlueStoneTeal
import com.michaelflisar.composecustomthemes.themes.themes.ThemeBlueWhale
import com.michaelflisar.composecustomthemes.themes.themes.ThemeBlumine
import com.michaelflisar.composecustomthemes.themes.themes.ThemeBrandBlues
import com.michaelflisar.composecustomthemes.themes.themes.ThemeBrownOrange
import com.michaelflisar.composecustomthemes.themes.themes.ThemeCamaroneGreen
import com.michaelflisar.composecustomthemes.themes.themes.ThemeDamaskAndLunar
import com.michaelflisar.composecustomthemes.themes.themes.ThemeDeepBlueSea
import com.michaelflisar.composecustomthemes.themes.themes.ThemeDeepPurple
import com.michaelflisar.composecustomthemes.themes.themes.ThemeDellGenoaGreen
import com.michaelflisar.composecustomthemes.themes.themes.ThemeEbonyClay
import com.michaelflisar.composecustomthemes.themes.themes.ThemeEggplantPurple
import com.michaelflisar.composecustomthemes.themes.themes.ThemeEndeavourBlue
import com.michaelflisar.composecustomthemes.themes.themes.ThemeEspressoAndCrema
import com.michaelflisar.composecustomthemes.themes.themes.ThemeFlutterDash
import com.michaelflisar.composecustomthemes.themes.themes.ThemeGoldSunset
import com.michaelflisar.composecustomthemes.themes.themes.ThemeGreens
import com.michaelflisar.composecustomthemes.themes.themes.ThemeGreenForest
import com.michaelflisar.composecustomthemes.themes.themes.ThemeGreenJungle
import com.michaelflisar.composecustomthemes.themes.themes.ThemeGreenMoney
import com.michaelflisar.composecustomthemes.themes.themes.ThemeGreyLaw
import com.michaelflisar.composecustomthemes.themes.themes.ThemeHippieBlue
import com.michaelflisar.composecustomthemes.themes.themes.ThemeIndigoNights
import com.michaelflisar.composecustomthemes.themes.themes.ThemeIndigoSanMarino
import com.michaelflisar.composecustomthemes.themes.themes.ThemeLipstickPink
import com.michaelflisar.composecustomthemes.themes.themes.ThemeMallardAndValencia
import com.michaelflisar.composecustomthemes.themes.themes.ThemeMangoMojito
import com.michaelflisar.composecustomthemes.themes.themes.ThemeMaterial3Purple
import com.michaelflisar.composecustomthemes.themes.themes.ThemeMaterialDefault
import com.michaelflisar.composecustomthemes.themes.themes.ThemeMaterialHighContrast
import com.michaelflisar.composecustomthemes.themes.themes.ThemeMidnight
import com.michaelflisar.composecustomthemes.themes.themes.ThemeMosqueCyan
import com.michaelflisar.composecustomthemes.themes.themes.ThemeOhMandyRed
import com.michaelflisar.composecustomthemes.themes.themes.ThemeOuterSpaceStage
import com.michaelflisar.composecustomthemes.themes.themes.ThemePinkSakura
import com.michaelflisar.composecustomthemes.themes.themes.ThemePurpleBrown
import com.michaelflisar.composecustomthemes.themes.themes.ThemeRedAndBlue
import com.michaelflisar.composecustomthemes.themes.themes.ThemeRedRedWine
import com.michaelflisar.composecustomthemes.themes.themes.ThemeRedTornado
import com.michaelflisar.composecustomthemes.themes.themes.ThemeRosewood
import com.michaelflisar.composecustomthemes.themes.themes.ThemeRustDeepOrange
import com.michaelflisar.composecustomthemes.themes.themes.ThemeSanJuanBlue
import com.michaelflisar.composecustomthemes.themes.themes.ThemeSharkAndOrange
import com.michaelflisar.composecustomthemes.themes.themes.ThemeThunderbirdRed
import com.michaelflisar.composecustomthemes.themes.themes.ThemeVerdunGreen
import com.michaelflisar.composecustomthemes.themes.themes.ThemeVerdunLime
import com.michaelflisar.composecustomthemes.themes.themes.ThemeVesuviusBurned
import com.michaelflisar.composecustomthemes.themes.themes.ThemeWillowAndWasabi
import com.michaelflisar.composecustomthemes.themes.themes.ThemeYukonGoldYellow

object ComposeThemes {

    fun list(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = listOf(
        // default m3 theme
        defaultTheme(statusBarColor, navigationBarColor),
        // custom themes
        ThemeAmberBlue.get(statusBarColor, navigationBarColor),
        ThemeAquaBlue.get(statusBarColor, navigationBarColor),
        ThemeBahamaAndTrinidad.get(statusBarColor, navigationBarColor),
        ThemeBarossa.get(statusBarColor, navigationBarColor),
        ThemeBigStoneTulip.get(statusBarColor, navigationBarColor),
        ThemeBlueDelight.get(statusBarColor, navigationBarColor),
        ThemeBlueStoneTeal.get(statusBarColor, navigationBarColor),
        ThemeBlueWhale.get(statusBarColor, navigationBarColor),
        ThemeBlumine.get(statusBarColor, navigationBarColor),
        ThemeBrandBlues.get(statusBarColor, navigationBarColor),
        ThemeBrownOrange.get(statusBarColor, navigationBarColor),
        ThemeCamaroneGreen.get(statusBarColor, navigationBarColor),
        ThemeDamaskAndLunar.get(statusBarColor, navigationBarColor),
        ThemeDeepBlueSea.get(statusBarColor, navigationBarColor),
        ThemeDeepPurple.get(statusBarColor, navigationBarColor),
        ThemeDellGenoaGreen.get(statusBarColor, navigationBarColor),
        ThemeEbonyClay.get(statusBarColor, navigationBarColor),
        ThemeEggplantPurple.get(statusBarColor, navigationBarColor),
        ThemeEndeavourBlue.get(statusBarColor, navigationBarColor),
        ThemeEspressoAndCrema.get(statusBarColor, navigationBarColor),
        ThemeFlutterDash.get(statusBarColor, navigationBarColor),
        ThemeGoldSunset.get(statusBarColor, navigationBarColor),
        ThemeGreens.get(statusBarColor, navigationBarColor),
        ThemeGreenForest.get(statusBarColor, navigationBarColor),
        ThemeGreenJungle.get(statusBarColor, navigationBarColor),
        ThemeGreenMoney.get(statusBarColor, navigationBarColor),
        ThemeGreyLaw.get(statusBarColor, navigationBarColor),
        ThemeHippieBlue.get(statusBarColor, navigationBarColor),
        ThemeIndigoNights.get(statusBarColor, navigationBarColor),
        ThemeIndigoSanMarino.get(statusBarColor, navigationBarColor),
        ThemeLipstickPink.get(statusBarColor, navigationBarColor),
        ThemeMallardAndValencia.get(statusBarColor, navigationBarColor),
        ThemeMangoMojito.get(statusBarColor, navigationBarColor),
        ThemeMaterial3Purple.get(statusBarColor, navigationBarColor),
        ThemeMaterialDefault.get(statusBarColor, navigationBarColor),
        ThemeMaterialHighContrast.get(statusBarColor, navigationBarColor),
        ThemeMidnight.get(statusBarColor, navigationBarColor),
        ThemeMosqueCyan.get(statusBarColor, navigationBarColor),
        ThemeOhMandyRed.get(statusBarColor, navigationBarColor),
        ThemeOuterSpaceStage.get(statusBarColor, navigationBarColor),
        ThemePinkSakura.get(statusBarColor, navigationBarColor),
        ThemePurpleBrown.get(statusBarColor, navigationBarColor),
        ThemeRedAndBlue.get(statusBarColor, navigationBarColor),
        ThemeRedRedWine.get(statusBarColor, navigationBarColor),
        ThemeRedTornado.get(statusBarColor, navigationBarColor),
        ThemeRosewood.get(statusBarColor, navigationBarColor),
        ThemeRustDeepOrange.get(statusBarColor, navigationBarColor),
        ThemeSanJuanBlue.get(statusBarColor, navigationBarColor),
        ThemeSharkAndOrange.get(statusBarColor, navigationBarColor),
        ThemeThunderbirdRed.get(statusBarColor, navigationBarColor),
        ThemeVerdunGreen.get(statusBarColor, navigationBarColor),
        ThemeVerdunLime.get(statusBarColor, navigationBarColor),
        ThemeVesuviusBurned.get(statusBarColor, navigationBarColor),
        ThemeWillowAndWasabi.get(statusBarColor, navigationBarColor),
        ThemeYukonGoldYellow.get(statusBarColor, navigationBarColor),
    )

    fun defaultTheme(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default,
        key: String = "Default"
    ) = ComposeTheme.Theme(
        key = key,
        colorSchemeLight = lightColorScheme(),
        colorSchemeDark = darkColorScheme(),
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )
}