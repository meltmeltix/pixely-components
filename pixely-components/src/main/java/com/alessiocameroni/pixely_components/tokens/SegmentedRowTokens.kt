package com.alessiocameroni.pixely_components.tokens

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

object SegmentedRowTokens {
    // Row related values
    val RowColor: Color @Composable get() = MaterialTheme.colorScheme.surfaceColorAtElevation(2.dp)

    val RowShape: Shape @Composable get() = MaterialTheme.shapes.extraSmall
}