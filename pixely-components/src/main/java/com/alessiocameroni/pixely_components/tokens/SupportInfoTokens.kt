package com.alessiocameroni.pixely_components.tokens

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object SupportInfoTokens {
    // Column related values
    val ContainerColor: Color @Composable get() = MaterialTheme.colorScheme.surface

    val HorizontalColumnPadding: Dp = 20.dp
    val VerticalColumnPadding: Dp = 10.dp


    // Text related values
    val TextColor: Color @Composable get() = MaterialTheme.colorScheme.onSurface

    const val TextColumnWeight: Float = 1f

    val TextStyle: TextStyle @Composable get() = MaterialTheme.typography.bodyMedium
    val TextSize: TextUnit = 14.sp


    // Icon related values
    val OverlineIconColor: Color @Composable get() = MaterialTheme.colorScheme.onSurface

    val BottomIconPadding: Dp = 20.dp
}