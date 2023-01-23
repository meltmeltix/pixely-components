package com.alessiocameroni.pixely_components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * ### Pixely List Item
 * This is structurally similar to the Material3 ListItem component.
 * This component layout has been tweaked so that it fits Material
 * You overall style, with more spaced out elements.
 */
@Composable
fun PixelyListItem(
    modifier: Modifier,
    headlineTextString: String,
    largeHeadline: Boolean = true,
    maxHeadlineLines: Int = 1,
    supportingTextString: String? = null,
    maxSupportingTextLines: Int = 1,
    leadingContent: @Composable (() -> Unit)? = null,
    trailingContent: @Composable (() -> Unit)? = null
) {
    if (supportingTextString == null) {
        // One-Line List Item
        ContentContainer(
            modifier = modifier,
            containerColor = PixelyListItemDefaults.ContainerColor,
            contentColor = PixelyListItemDefaults.ContentColor,
            minHeight = OneLineMinHeight,
            paddingValues = PaddingValues(horizontal = ContainerPadding)
        ) {
            if (leadingContent == null && trailingContent == null) {
                // Headline Text only
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = OneLineMinHeight),
                    verticalArrangement = Arrangement.Center
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        paddingEnabled = false,
                        color = PixelyListItemDefaults.ContentColor,
                        maxLines = maxHeadlineLines
                    )
                }
            }
            else if (trailingContent == null) {
                // Headline Text and Leading Content only
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = OneLineMinHeight),
                    verticalArrangement = Arrangement.Center
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        paddingEnabled = false,
                        color = PixelyListItemDefaults.ContentColor,
                        maxLines = maxHeadlineLines
                    )
                }
            }
            else if (leadingContent == null) {
                // Headline Text and Trailing Content only
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = OneLineMinHeight),
                    verticalArrangement = Arrangement.Center
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        paddingEnabled = false,
                        color = PixelyListItemDefaults.ContentColor,
                        maxLines = maxHeadlineLines
                    )
                }
            }
            else {
                // Headline Text, Leading and Trailing Content
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = OneLineMinHeight),
                    verticalArrangement = Arrangement.Center
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        paddingEnabled = false,
                        color = PixelyListItemDefaults.ContentColor,
                        maxLines = maxHeadlineLines
                    )
                }
            }
        }
    } else {
        // Two-Line List Item
        ContentContainer(
            modifier = modifier,
            containerColor = PixelyListItemDefaults.ContainerColor,
            contentColor = PixelyListItemDefaults.ContentColor,
            minHeight = TwoLineMinHeight,
            paddingValues = PaddingValues(ContainerPadding)
        ) {
            if (leadingContent == null && trailingContent == null) {
                // Headline Text only
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = OneLineMinHeight),
                    verticalArrangement = Arrangement.Center
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        paddingEnabled = true,
                        color = PixelyListItemDefaults.ContentColor,
                        maxLines = maxHeadlineLines
                    )

                    SupportingText(
                        text = supportingTextString,
                        color = PixelyListItemDefaults.SecondaryContentColor,
                        maxLines = maxSupportingTextLines
                    )
                }
            }
            else if (trailingContent == null) {
                // Headline Text and Leading Content only
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = OneLineMinHeight),
                    verticalArrangement = Arrangement.Center
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        paddingEnabled = true,
                        color = PixelyListItemDefaults.ContentColor,
                        maxLines = maxHeadlineLines
                    )

                    SupportingText(
                        text = supportingTextString,
                        color = PixelyListItemDefaults.SecondaryContentColor,
                        maxLines = maxSupportingTextLines
                    )
                }
            }
            else if (leadingContent == null) {
                // Headline Text and Trailing Content only
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = OneLineMinHeight),
                    verticalArrangement = Arrangement.Center
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        paddingEnabled = true,
                        color = PixelyListItemDefaults.ContentColor,
                        maxLines = maxHeadlineLines
                    )

                    SupportingText(
                        text = supportingTextString,
                        color = PixelyListItemDefaults.SecondaryContentColor,
                        maxLines = maxSupportingTextLines
                    )
                }
            }
            else {
                // Headline Text, Leading and Trailing Content
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = OneLineMinHeight),
                    verticalArrangement = Arrangement.Center
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        paddingEnabled = true,
                        color = PixelyListItemDefaults.ContentColor,
                        maxLines = maxHeadlineLines
                    )

                    SupportingText(
                        text = supportingTextString,
                        color = PixelyListItemDefaults.SecondaryContentColor,
                        maxLines = maxSupportingTextLines
                    )
                }
            }
        }
    }
}

@Composable
private fun ContentContainer(
    modifier: Modifier,
    containerColor: Color,
    contentColor: Color,
    minHeight: Dp,
    paddingValues: PaddingValues,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        modifier = modifier,
        color = containerColor,
        contentColor = contentColor
    ) {
        Row(
            modifier = Modifier
                .heightIn(min = minHeight)
                .padding(paddingValues),
            content = content
        )
    }
}

@Composable
private fun HeadlineText(
    largeText: Boolean,
    text: String,
    paddingEnabled: Boolean = false,
    color: Color,
    maxLines: Int
) {
    val paddingModifier: Modifier =
        if (paddingEnabled) {
            if (largeText) {
                Modifier.padding(top = LargeHeadlineTopPadding)
            } else {
                Modifier.padding(top = MediumHeadlineTopPadding)
            }
        } else {
            Modifier.padding(vertical = OneLineTextVerticalPadding)
        }

    if (largeText) {
        Text(
            text = text,
            modifier = paddingModifier,
            style = MaterialTheme.typography.titleLarge,
            fontSize = 20.sp,
            color = color,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis
        )
    } else {
        Text(
            text = text,
            modifier = paddingModifier,
            style = MaterialTheme.typography.titleMedium,
            color = color,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun SupportingText(
    text: String,
    color: Color,
    maxLines: Int
) {
    Text(
        text = text,
        modifier = Modifier,
        style = MaterialTheme.typography.bodyMedium,
        fontSize = 14.sp,
        color = color,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis
    )
}

object PixelyListItemDefaults {
    val ContainerColor: Color @Composable get() = MaterialTheme.colorScheme.surface
    val ContentColor: Color @Composable get() = MaterialTheme.colorScheme.onSurface
    val SecondaryContentColor: Color @Composable get() = MaterialTheme.colorScheme.onSurfaceVariant
}

// Container/Row related values
private val OneLineMinHeight: Dp = 60.dp
private val TwoLineMinHeight: Dp = 80.dp

private val ContainerPadding: Dp = 10.dp

// Text related values
private val LargeHeadlineTopPadding: Dp = 7.dp
private val MediumHeadlineTopPadding: Dp = 10.dp

private val OneLineTextVerticalPadding: Dp = 10.dp