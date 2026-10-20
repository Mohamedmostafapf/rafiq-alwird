package com.rafiq.alwird.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object Brand {
    val Gold = Color(0xFFC9A24B)
    val GoldDeep = Color(0xFF8A6A1F)   // ذهبي غامق للنص على الخلفية الفاتحة
    val Petrol = Color(0xFF0F5C66)
    val PetrolLight = Color(0xFF1B8794)
    val Black = Color(0xFF0B0D0E)
    val Surface = Color(0xFF15191B)
    val Gray = Color(0xFF9AA0A3)
    val GrayDark = Color(0xFF5F666A)
    val Line = Color(0xFF2A2F32)
}

private val Dark = darkColorScheme(
    primary = Brand.PetrolLight, onPrimary = Color.White,
    secondary = Brand.Gold, onSecondary = Brand.Black,
    background = Brand.Black, onBackground = Color.White,
    surface = Brand.Surface, onSurface = Color.White,
    onSurfaceVariant = Brand.Gray, outline = Brand.Line,
)
private val Light = lightColorScheme(
    primary = Brand.Petrol, onPrimary = Color.White,
    secondary = Brand.GoldDeep, onSecondary = Color.White,
    background = Color.White, onBackground = Brand.Black,
    surface = Color(0xFFF3F4F4), onSurface = Brand.Black,
    onSurfaceVariant = Brand.GrayDark, outline = Color(0xFFC9CDCF),
)

@Composable
fun RafiqTheme(dark: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = if (dark) Dark else Light, content = content)
}
