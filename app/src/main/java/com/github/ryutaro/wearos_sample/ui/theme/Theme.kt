package com.github.ryutaro.wearos_sample.ui.theme

import androidx.compose.runtime.Composable
import androidx.wear.compose.material.MaterialTheme

@Composable
fun WearossampleTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colors = WearOsSampleColorPalette,
        typography = Typography,
        content = content
    )
}