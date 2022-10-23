package com.covate.praiseandworship.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    background = secondaryDarkColor,
    surface = primaryTextColor,
    onSurface = secondaryTextColor,
    primary = primaryColor,
    onPrimary = primaryTextColor,
    secondary = secondaryColor,
    onSecondary = secondaryTextColor
)

private val LightColorPalette = lightColors(
    background = primaryLightColor,
    surface = secondaryTextColor,
    onSurface = primaryTextColor,
    primary = primaryColor,
    onPrimary = primaryTextColor,
    secondary = secondaryColor,
    onSecondary = secondaryTextColor
)

@Composable
fun PraiseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}