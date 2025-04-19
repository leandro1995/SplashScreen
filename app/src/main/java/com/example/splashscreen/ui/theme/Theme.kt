package com.example.splashscreen.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

private val LightColorScheme = lightColorScheme(
    primary = Purple40, secondary = PurpleGrey40, tertiary = Pink40
)

@Composable
fun SplashScreenTheme(content: @Composable (padding: PaddingValues) -> Unit) {

    MaterialTheme(
        colorScheme = LightColorScheme, typography = Typography, content = {
            Scaffold(modifier = Modifier.fillMaxHeight()) { padding ->
                content(padding)
            }
        })
}