package com.github.ryutaro.wearos_sample.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Message
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.SelfImprovement
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.wear.compose.material.*

@Composable
fun ButtonExample(
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier.size(ButtonDefaults.LargeButtonSize),
            onClick = {  }
        ) {
            Icon(
                imageVector = Icons.Rounded.Phone,
                contentDescription = "triggers phone action",
                modifier = iconModifier
            )
        }
    }
}

@Composable
fun TextExample(modifier: Modifier = Modifier) {
    Text(
        text = "Round Device",
        modifier = modifier,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.primary
    )
}

@Composable
fun CardExample(
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier
) {
    AppCard(
        modifier = modifier,
        appImage = {
                   Icon(
                       imageVector = Icons.Rounded.Message,
                       contentDescription = "triggers open message action",
                       modifier = iconModifier
                   )
        },
        onClick = { /*TODO*/ },
        appName = { Text(text = "Message") },
        time = { Text(text = "12m") },
        title = { Text(text = "Kim Green") }
    ) {
        Text(text = "Oh my way!")
    }
}

@Composable
fun ChipExample(
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier
) {
    Chip(
        modifier = modifier,
        onClick = { /*TODO*/ },
        label = {
            Text(
                text = "5 minute Meditation",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        icon = {
            Icon(
                imageVector = Icons.Rounded.SelfImprovement,
                contentDescription = "triggers meditation action",
                modifier = iconModifier
            )
        }
    )
}

@Composable
fun ToggleChipExample(modifier: Modifier = Modifier) {
    var checked by remember { mutableStateOf(true) }
    ToggleChip(
        modifier = modifier,
        checked = checked,
        toggleControl = {
                        Icon(
                            imageVector = ToggleChipDefaults.switchIcon(checked = checked),
                            contentDescription = if (checked) "On" else "off"
                        )
        },
        onCheckedChange = { checked = it },
        label = {
            Text(
                text = "Sound",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    )
}

@Composable
fun StartOnlyTextComposables() {
    Text(
        text = "Hello, Compose World",
        modifier = Modifier.fillMaxSize(),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.primary
    )
}
