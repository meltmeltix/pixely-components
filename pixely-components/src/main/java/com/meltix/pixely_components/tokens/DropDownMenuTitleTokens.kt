package com.meltix.pixely_components.tokens

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object DropDownMenuTitleTokens {
    // Container related values
    val ContainerColor: Color @Composable get() = MaterialTheme.colorScheme.surface


    // Text related values
    val TextColor: Color @Composable get() = MaterialTheme.colorScheme.onSurface

    val TextHorizontalPadding: Dp = 12.dp
    val TextTopPadding: Dp = 13.dp
    val TextVerticalPadding: Dp = 8.dp

    val TextStyle: TextStyle @Composable get() = MaterialTheme.typography.labelLarge
}