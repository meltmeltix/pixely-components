package com.alessiocameroni.pixely_components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
 *
 * @param modifier to be applied to the list item surface
 * @param stringHeadlineText the headline text of the list item
 * @param largeHeadline toggle to make the headline large if true, medium if false
 * @param maxHeadlineLines maximum lines allowed for the headline text
 * @param stringSupportingText the supporting text of the list item
 * @param maxSupportingLines maximum lines allowed for the supporting text
 * @param leadingContent the leading unit on the left of the text
 * @param trailingContent the trasiling unit on the right of the text
 */
@Composable
fun PixelyListItem(
    modifier: Modifier,
    stringHeadlineText: String,
    largeHeadline: Boolean = true,
    maxHeadlineLines: Int = 1,
    stringSupportingText: String? = null,
    maxSupportingLines: Int = 1,
    leadingContent: @Composable (() -> Unit?)? = null,
    trailingContent: @Composable (() -> Unit?)? = null
) {
    if (stringSupportingText != null) {
        // Headline and Supporting text
        ContainerListItem(
            modifier = modifier,
            minHeight = PixelyListItemDefaults.TwoLinesMinHeight,
            paddingValues = PaddingValues(
                horizontal = PixelyListItemDefaults.HorizontalMinPadding
            ),
            maxHeadlineLines = maxHeadlineLines,
            maxSupportingLines = maxSupportingLines
        ) {
            if (leadingContent != null && trailingContent != null) {
                // Leading and Trailing units
                LeadingUnit (
                    leadingContent = { leadingContent() }
                )

                Column(modifier = Modifier.weight(1f)) {
                    HeadlineText(
                        largeHeadline = largeHeadline,
                        text = stringHeadlineText,
                        maxLines = maxHeadlineLines
                    )

                    SupportingText(
                        text = stringSupportingText,
                        maxLines = maxSupportingLines
                    )
                }

                TrailingUnit (
                    trailingContent = { trailingContent() }
                )
            }
            else if (leadingContent != null) {
                // Only Leading unit
                LeadingUnit (
                    leadingContent = { leadingContent() }
                )

                Column(
                    modifier = Modifier
                        .padding(end = PixelyListItemDefaults.HorizontalMaxPadding)
                        .weight(1f)
                ) {
                    HeadlineText(
                        largeHeadline = largeHeadline,
                        text = stringHeadlineText,
                        maxLines = maxHeadlineLines
                    )

                    SupportingText(
                        text = stringSupportingText,
                        maxLines = maxSupportingLines
                    )
                }
            }
            else if (trailingContent != null) {
                // Only Trailing unit
                Column(
                    modifier = Modifier
                        .padding(start = PixelyListItemDefaults.HorizontalMaxPadding)
                        .weight(1f)
                ) {
                    HeadlineText(
                        largeHeadline = largeHeadline,
                        text = stringHeadlineText,
                        maxLines = maxHeadlineLines
                    )

                    SupportingText(
                        text = stringSupportingText,
                        maxLines = maxSupportingLines
                    )
                }

                TrailingUnit (
                    trailingContent = { trailingContent() }
                )
            }
            else {
                // Only text
                Column(
                    modifier = Modifier
                        .padding(horizontal = PixelyListItemDefaults.HorizontalMaxPadding)
                        .weight(1f)
                ) {
                    HeadlineText(
                        largeHeadline = largeHeadline,
                        text = stringHeadlineText,
                        maxLines = maxHeadlineLines
                    )

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringSupportingText,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 14.sp
                    )
                }
            }
        }
    } else {
        // Only Headline text
        ContainerListItem(
            modifier = modifier,
            minHeight = PixelyListItemDefaults.OneLineMinHeight,
            paddingValues = PaddingValues(
                horizontal = PixelyListItemDefaults.HorizontalMinPadding
            ),
            maxHeadlineLines = maxHeadlineLines,
            maxSupportingLines = maxSupportingLines
        ) {
            if (leadingContent != null && trailingContent != null) {
                // Leading and Trailing units
                LeadingUnit (
                    leadingContent = { leadingContent() }
                )

                Column(modifier = Modifier.weight(1f)) {
                    HeadlineText(
                        largeHeadline = largeHeadline,
                        text = stringHeadlineText,
                        maxLines = maxHeadlineLines
                    )
                }

                TrailingUnit (
                    trailingContent = { trailingContent() }
                )
            }
            else if (leadingContent != null) {
                // Only Leading unit
                LeadingUnit (
                    leadingContent = { leadingContent() }
                )

                Column(
                    modifier = Modifier
                        .padding(end = PixelyListItemDefaults.HorizontalMaxPadding)
                        .weight(1f)
                ) {
                    HeadlineText(
                        largeHeadline = largeHeadline,
                        text = stringHeadlineText,
                        maxLines = maxHeadlineLines
                    )
                }
            }
            else if (trailingContent != null) {
                // Only Trailing unit
                Column(
                    modifier = Modifier
                        .padding(start = PixelyListItemDefaults.HorizontalMaxPadding)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    HeadlineText(
                        largeHeadline = largeHeadline,
                        text = stringHeadlineText,
                        maxLines = maxHeadlineLines
                    )
                }

                TrailingUnit (
                    trailingContent = { trailingContent() }
                )
            }
            else {
                // Only text
                Column(
                    modifier = Modifier
                        .padding(horizontal = PixelyListItemDefaults.HorizontalMaxPadding)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    HeadlineText(
                        largeHeadline = largeHeadline,
                        text = stringHeadlineText,
                        maxLines = maxHeadlineLines
                    )
                }
            }
        }
    }
}

@Composable
private fun ContainerListItem(
    modifier: Modifier,
    containerColor: Color = PixelyListItemDefaults.ContainerColor,
    contentColor: Color = PixelyListItemDefaults.ContentColor,
    minHeight: Dp,
    paddingValues: PaddingValues,
    maxHeadlineLines: Int,
    maxSupportingLines: Int,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        modifier = modifier,
        color = containerColor,
        contentColor = contentColor
    ) {
        if (maxHeadlineLines == 1 && maxSupportingLines == 1) {
            Row(
                modifier = Modifier
                    .padding(paddingValues)
                    .defaultMinSize(minHeight = minHeight),
                content = content,
                verticalAlignment = Alignment.CenterVertically
            )
        } else {
            Row(
                modifier = Modifier
                    .padding(paddingValues)
                    .defaultMinSize(minHeight = minHeight),
                content = content
            )
        }
    }
}

@Composable
private fun HeadlineText (
    largeHeadline: Boolean,
    text: String,
    maxLines: Int
) {
    if (largeHeadline) {
        Text(
            text = text,
            modifier = Modifier.padding(top = PixelyListItemDefaults.TextLargeTopPadding),
            style = MaterialTheme.typography.titleLarge,
            fontSize = 20.sp,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis
        )
    } else {
        Text(
            text = text,
            modifier = Modifier.padding(top = PixelyListItemDefaults.TextMediumTopPadding),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun SupportingText (
    text: String,
    maxLines: Int
) {
    if(maxLines != 1) {
        Text(
            text = text,
            modifier = Modifier.padding(bottom = PixelyListItemDefaults.TextBottomPadding),
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 14.sp,
            maxLines = maxLines
        )
    } else {
        Text(
            text = text,
            modifier = Modifier.padding(bottom = PixelyListItemDefaults.TextBottomPadding),
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 14.sp,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun LeadingUnit (
    leadingContent: @Composable (() -> Unit)
) {
    Box(
        modifier = Modifier
            .padding(end = PixelyListItemDefaults.HorizontalMinPadding)
            .padding(vertical = PixelyListItemDefaults.UnitVerticalPadding)
            .defaultMinSize(minWidth = PixelyListItemDefaults.UnitSize)
            .height(PixelyListItemDefaults.UnitSize),
        contentAlignment = Alignment.Center,
    ) { leadingContent() }
}

@Composable
private fun TrailingUnit (
    trailingContent: @Composable (() -> Unit)
) {
    Box(
        modifier = Modifier
            .padding(start = PixelyListItemDefaults.HorizontalMinPadding)
            .padding(vertical = PixelyListItemDefaults.UnitVerticalPadding)
            .defaultMinSize(minWidth = PixelyListItemDefaults.UnitSize)
            .height(PixelyListItemDefaults.UnitSize),
        contentAlignment = Alignment.Center
    ) { trailingContent() }
}

object PixelyListItemDefaults {
    val OneLineMinHeight: Dp = 60.dp
    val TwoLinesMinHeight: Dp = 80.dp

    val ContainerColor: Color @Composable get() = MaterialTheme.colorScheme.surface
    val ContentColor: Color @Composable get() = MaterialTheme.colorScheme.onSurface

    val HorizontalMinPadding: Dp = 5.dp
    val HorizontalMaxPadding: Dp = 20.dp

    val UnitSize: Dp = 60.dp
    val UnitVerticalPadding: Dp = 10.dp

    val TextMediumTopPadding: Dp = 18.dp
    val TextLargeTopPadding: Dp = 16.dp
    val TextBottomPadding: Dp = 14.dp
}