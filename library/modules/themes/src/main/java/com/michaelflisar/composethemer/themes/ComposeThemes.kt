package com.michaelflisar.composethemer.themes

import com.michaelflisar.composethemer.ComposeTheme
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
import com.michaelflisar.composethemer.themes.themes.ThemeDefault
import com.michaelflisar.composethemer.themes.themes.ThemeDellGenoaGreen
import com.michaelflisar.composethemer.themes.themes.ThemeEbonyClay
import com.michaelflisar.composethemer.themes.themes.ThemeEggplantPurple
import com.michaelflisar.composethemer.themes.themes.ThemeEndeavourBlue
import com.michaelflisar.composethemer.themes.themes.ThemeEspressoAndCrema
import com.michaelflisar.composethemer.themes.themes.ThemeFlutterDash
import com.michaelflisar.composethemer.themes.themes.ThemeGoldSunset
import com.michaelflisar.composethemer.themes.themes.ThemeGreenForest
import com.michaelflisar.composethemer.themes.themes.ThemeGreenJungle
import com.michaelflisar.composethemer.themes.themes.ThemeGreenMoney
import com.michaelflisar.composethemer.themes.themes.ThemeGreens
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

object ComposeThemes {

    val ALL: List<ComposeTheme.Theme>
        get() = listOf(
            // default m3 theme
            ThemeDefault.get(),
            // custom themes
            ThemeAmberBlue.get(),
            ThemeAquaBlue.get(),
            ThemeBahamaAndTrinidad.get(),
            ThemeBarossa.get(),
            ThemeBigStoneTulip.get(),
            ThemeBlueDelight.get(),
            ThemeBlueStoneTeal.get(),
            ThemeBlueWhale.get(),
            ThemeBlumine.get(),
            ThemeBrandBlues.get(),
            ThemeBrownOrange.get(),
            ThemeCamaroneGreen.get(),
            ThemeDamaskAndLunar.get(),
            ThemeDeepBlueSea.get(),
            ThemeDeepPurple.get(),
            ThemeDellGenoaGreen.get(),
            ThemeEbonyClay.get(),
            ThemeEggplantPurple.get(),
            ThemeEndeavourBlue.get(),
            ThemeEspressoAndCrema.get(),
            ThemeFlutterDash.get(),
            ThemeGoldSunset.get(),
            ThemeGreens.get(),
            ThemeGreenForest.get(),
            ThemeGreenJungle.get(),
            ThemeGreenMoney.get(),
            ThemeGreyLaw.get(),
            ThemeHippieBlue.get(),
            ThemeIndigoNights.get(),
            ThemeIndigoSanMarino.get(),
            ThemeLipstickPink.get(),
            ThemeMallardAndValencia.get(),
            ThemeMangoMojito.get(),
            ThemeMaterial3Purple.get(),
            ThemeMaterialDefault.get(),
            ThemeMaterialHighContrast.get(),
            ThemeMidnight.get(),
            ThemeMosqueCyan.get(),
            ThemeOhMandyRed.get(),
            ThemeOuterSpaceStage.get(),
            ThemePinkSakura.get(),
            ThemePurpleBrown.get(),
            ThemeRedAndBlue.get(),
            ThemeRedRedWine.get(),
            ThemeRedTornado.get(),
            ThemeRosewood.get(),
            ThemeRustDeepOrange.get(),
            ThemeSanJuanBlue.get(),
            ThemeSharkAndOrange.get(),
            ThemeThunderbirdRed.get(),
            ThemeVerdunGreen.get(),
            ThemeVerdunLime.get(),
            ThemeVesuviusBurned.get(),
            ThemeWillowAndWasabi.get(),
            ThemeYukonGoldYellow.get(),
        )
}