package com.github.ryutaro.wearos_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*
import com.github.ryutaro.wearos_sample.ui.components.*
import com.github.ryutaro.wearos_sample.ui.theme.WearossampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearApp()
        }
    }
}

@Composable
fun WearApp() {
    WearossampleTheme {
        val listState = rememberScalingLazyListState()

        Scaffold(
            timeText = {
                       if (!listState.isScrollInProgress) {
                           TimeText()
                       }
            },
            vignette = {
                       Vignette(vignettePosition = VignettePosition.TopAndBottom)
            },
            positionIndicator = {
                PositionIndicator(
                    scalingLazyListState = listState
                )
            }
        ) {
            val contentModifier = Modifier
                .fillMaxSize()
                .padding(bottom = 8.dp)
            val iconModifier = Modifier
                .size(24.dp)
                .wrapContentSize(align = Alignment.Center)

            ScalingLazyColumn(
                modifier = Modifier.fillMaxSize(),
                state = listState,
                autoCentering = AutoCenteringParams(itemIndex = 0)
            ) {
                item { ButtonExample(contentModifier, iconModifier) }
                item { TextExample(contentModifier) }
                item { CardExample(contentModifier, iconModifier) }
                item { ChipExample(contentModifier, iconModifier) }
                item { ToggleChipExample(contentModifier) }
            }
        }
    }
}

@Preview(
    widthDp = WEAR_PREVIEW_DEVICE_WIDTH_DP,
    heightDp = WEAR_PREVIEW_DEVICE_HEIGHT_DP,
    apiLevel = WEAR_PREVIEW_API_LEVEL,
    uiMode = WEAR_PREVIEW_UI_MODE,
    backgroundColor = WEAR_PREVIEW_BACKGROUND_COLOR_BLACK,
    showBackground = WEAR_PREVIEW_SHOW_BACKGROUND
)
@Composable
fun WearAppPreview() {
    WearApp()
}
