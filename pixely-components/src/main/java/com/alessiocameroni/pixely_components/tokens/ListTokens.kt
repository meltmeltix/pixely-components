package com.alessiocameroni.pixely_components.tokens

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal object ListTokens {
    // Component related values
    val ComponentPadding: Dp = 10.dp


    // Container/Row related values
    val ContainerColor: Color @Composable get() = MaterialTheme.colorScheme.surface

    val OneLineMinHeight: Dp = 60.dp
    val TwoLineMinHeight: Dp = 80.dp


    // Text related values
    val HeadlineColor: Color @Composable get() = MaterialTheme.colorScheme.onSurface
    val DisabledHeadlineColor: Color @Composable get() = MaterialTheme.colorScheme.onSurfaceVariant
    val SupportingTextColor: Color @Composable get() = MaterialTheme.colorScheme.onSurfaceVariant

    val LargeHeadlineTopPadding: Dp = 6.dp
    val MediumHeadlineTopPadding: Dp = 9.dp
    val SupportingTextBottomPadding: Dp = 5.dp
    val OneLineTextVerticalPadding: Dp = 10.dp
    val OnlyTextHorizontalPadding: Dp = 15.dp


    // Leading and trailing content related values
    val LeadingContentColor: Color @Composable get() = MaterialTheme.colorScheme.onSurface
    val DisabledLeadingContentColor: Color @Composable get() = MaterialTheme.colorScheme.onSurface
    val TrailingContentColor: Color @Composable get() = MaterialTheme.colorScheme.onSurface
    val DisabledTrailingContentColor: Color @Composable get() = MaterialTheme.colorScheme.onSurface

    val ContentMinHeight: Dp = 60.dp
    val ContentMinWidth: Dp = 52.dp
    val ContentMaxHeight: Dp = 60.dp
    val ContentMaxWidth: Dp = 110.dp
}