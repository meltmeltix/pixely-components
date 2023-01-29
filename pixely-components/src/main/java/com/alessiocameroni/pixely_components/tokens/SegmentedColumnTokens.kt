package com.alessiocameroni.pixely_components.tokens

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object SegmentedColumnTokens {
    // Column related values
    val ColumnColor: Color @Composable get() = MaterialTheme.colorScheme.surface

    val ColumnHorizontalPadding: Dp = 15.dp

    val ColumnShape: Shape @Composable get() = MaterialTheme.shapes.extraLarge
}