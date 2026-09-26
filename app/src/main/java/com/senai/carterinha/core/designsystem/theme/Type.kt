package com.senai.carterinha.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.senai.carterinha.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

// Fonte monoespaçada nativa: garante o visual "terminal" mesmo sem
// Google Play Services / internet para baixar fontes.
val terminalFontFamily = FontFamily.Monospace

val baseline = Typography()

val AppTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = terminalFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = terminalFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = terminalFontFamily),

    headlineLarge = baseline.headlineLarge.copy(fontFamily = terminalFontFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = terminalFontFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = terminalFontFamily),

    titleLarge = baseline.titleLarge.copy(fontFamily = terminalFontFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = terminalFontFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = terminalFontFamily),

    bodyLarge = baseline.bodyLarge.copy(fontFamily = terminalFontFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = terminalFontFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = terminalFontFamily),

    labelLarge = baseline.labelLarge.copy(fontFamily = terminalFontFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = terminalFontFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = terminalFontFamily),
)
