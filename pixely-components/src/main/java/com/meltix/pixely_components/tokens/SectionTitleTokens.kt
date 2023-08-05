package com.meltix.pixely_components.tokens

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object SectionTitleTokens {
    //Container related values
    val ContainerColor: Color @Composable get() = MaterialTheme.colorScheme.surface

    val HorizontalContainerPadding: Dp = 25.dp
    val TopContainerPadding: Dp = 25.dp
    val BottomContainerPadding: Dp = 5.dp
    val TopContainerUnitPadding: Dp = 2.dp
    val BottomContainerUnitPadding: Dp = 2.dp


    // Text related values
    val TextColor: Color @Composable get() = MaterialTheme.colorScheme.primary

    val TextEndPadding: Dp = 10.dp

    const val TextWeight: Float = 1f

    val TextStyle: TextStyle @Composable get() = MaterialTheme.typography.bodyMedium

    // Unit related values
    val UnitColor: Color @Composable get() = MaterialTheme.colorScheme.onSurfaceVariant
}