package com.michaelflisar.composethemer.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.michaelflisar.composethemer.themes.themes.ThemeAmberBlue
import com.michaelflisar.composethemer.themes.themes.ThemeAquaBlue
import com.michaelflisar.composethemer.themes.themes.ThemeBahamaAndTrinidad
import com.michaelflisar.composethemer.themes.themes.ThemeBarossa
import com.michaelflisar.composethemer.themes.themes.ThemeBigStoneTulip
import com.michaelflisar.composethemer.themes.themes.ThemeBlueDelight
import com.michaelflisar.composethemer.themes.themes.ThemeBlueStoneTeal
import com.michaelflisar.composethemer.themes.themes.ThemeBlueWhale
import com.michaelflisar.composethemer.themes.themes.ThemeBlumine
import com.michaelflisar.composethemer.themes.themes.ThemeBrandBlues
import com.michaelflisar.composethemer.themes.themes.ThemeBrownOrange
import com.michaelflisar.composethemer.themes.themes.ThemeCamaroneGreen
import com.michaelflisar.composethemer.themes.themes.ThemeDamaskAndLunar
import com.michaelflisar.composethemer.themes.themes.ThemeDeepBlueSea
import com.michaelflisar.composethemer.themes.themes.ThemeDeepPurple
import com.michaelflisar.composethemer.themes.themes.ThemeDellGenoaGreen
import com.michaelflisar.composethemer.themes.themes.ThemeEbonyClay
import com.michaelflisar.composethemer.themes.themes.ThemeEggplantPurple
import com.michaelflisar.composethemer.themes.themes.ThemeEndeavourBlue
import com.michaelflisar.composethemer.themes.themes.ThemeEspressoAndCrema
import com.michaelflisar.composethemer.themes.themes.ThemeFlutterDash
import com.michaelflisar.composethemer.themes.themes.ThemeGoldSunset
import com.michaelflisar.composethemer.themes.themes.ThemeGreens
import com.michaelflisar.composethemer.themes.themes.ThemeGreenForest
import com.michaelflisar.composethemer.themes.themes.ThemeGreenJungle
import com.michaelflisar.composethemer.themes.themes.ThemeGreenMoney
import com.michaelflisar.composethemer.themes.themes.ThemeGreyLaw
import com.michaelflisar.composethemer.themes.themes.ThemeHippieBlue
import com.michaelflisar.composethemer.themes.themes.ThemeIndigoNights
import com.michaelflisar.composethemer.themes.themes.ThemeIndigoSanMarino
import com.michaelflisar.composethemer.themes.themes.ThemeLipstickPink
import com.michaelflisar.composethemer.themes.themes.ThemeMallardAndValencia
import com.michaelflisar.composethemer.themes.themes.ThemeMangoMojito
import com.michaelflisar.composethemer.themes.themes.ThemeMaterial3Purple
import com.michaelflisar.composethemer.themes.themes.ThemeMaterialDefault
import com.michaelflisar.composethemer.themes.themes.ThemeMaterialHighContrast
import com.michaelflisar.composethemer.themes.themes.ThemeMidnight
import com.michaelflisar.composethemer.themes.themes.ThemeMosqueCyan
import com.michaelflisar.composethemer.themes.themes.ThemeOhMandyRed
import com.michaelflisar.composethemer.themes.themes.ThemeOuterSpaceStage
import com.michaelflisar.composethemer.themes.themes.ThemePinkSakura
import com.michaelflisar.composethemer.themes.themes.ThemePurpleBrown
import com.michaelflisar.composethemer.themes.themes.ThemeRedAndBlue
import com.michaelflisar.composethemer.themes.themes.ThemeRedRedWine
import com.michaelflisar.composethemer.themes.themes.ThemeRedTornado
import com.michaelflisar.composethemer.themes.themes.ThemeRosewood
import com.michaelflisar.composethemer.themes.themes.ThemeRustDeepOrange
import com.michaelflisar.composethemer.themes.themes.ThemeSanJuanBlue
import com.michaelflisar.composethemer.themes.themes.ThemeSharkAndOrange
import com.michaelflisar.composethemer.themes.themes.ThemeThunderbirdRed
import com.michaelflisar.composethemer.themes.themes.ThemeVerdunGreen
import com.michaelflisar.composethemer.themes.themes.ThemeVerdunLime
import com.michaelflisar.composethemer.themes.themes.ThemeVesuviusBurned
import com.michaelflisar.composethemer.themes.themes.ThemeWillowAndWasabi
import com.michaelflisar.composethemer.themes.themes.ThemeYukonGoldYellow
import com.michaelflisar.composethemer.ComposeTheme

object ComposeThemes {

    fun getAll(
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