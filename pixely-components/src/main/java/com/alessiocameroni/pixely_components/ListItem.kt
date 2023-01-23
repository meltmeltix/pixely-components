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
 * @param trailingContent the trailing unit on the right of the text
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
            minHeight = TwoLinesMinHeight,
            paddingValues = PaddingValues(
                horizontal = HorizontalPadding,
                vertical = VerticalPadding
            ),
            maxHeadlineLines = maxHeadlineLines,
            maxSupportingLines = maxSupportingLines
        ) {
            if (leadingContent != null && trailingContent != null) {
                LeadingUnit(
                    leadingContent = { leadingContent() }
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .defaultMinSize(minHeight = ColumnMinHeight)
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
            else if (leadingContent != null) {
                LeadingUnit(
                    leadingContent = { leadingContent() }
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .defaultMinSize(minHeight = ColumnMinHeight)
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
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .defaultMinSize(minHeight = ColumnMinHeight)
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
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .defaultMinSize(minHeight = ColumnMinHeight)
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
        }
    } else {
        // Only Headline text
        ContainerListItem(
            modifier = modifier,
            minHeight = OneLineMinHeight,
            paddingValues = PaddingValues(
                horizontal = HorizontalPadding,
                vertical = 0.dp
            ),
            maxHeadlineLines = maxHeadlineLines,
            maxSupportingLines = maxSupportingLines
        ) {
            if (leadingContent != null && trailingContent != null) {
                LeadingUnit(
                    leadingContent = { leadingContent() }
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .defaultMinSize(minHeight = ColumnMinHeight)
                ) {
                    HeadlineText(
                        largeHeadline = largeHeadline,
                        paddingEnabled = false,
                        text = stringHeadlineText,
                        maxLines = maxHeadlineLines
                    )
                }

                TrailingUnit (
                    trailingContent = { trailingContent() }
                )
            }
            else if (leadingContent != null) {
                LeadingUnit(
                    leadingContent = { leadingContent() }
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .defaultMinSize(minHeight = ColumnMinHeight)
                ) {
                    HeadlineText(
                        largeHeadline = largeHeadline,
                        paddingEnabled = false,
                        text = stringHeadlineText,
                        maxLines = maxHeadlineLines
                    )
                }
            }
            else if (trailingContent != null) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .defaultMinSize(minHeight = ColumnMinHeight)
                ) {
                    HeadlineText(
                        largeHeadline = largeHeadline,
                        paddingEnabled = false,
                        text = stringHeadlineText,
                        maxLines = maxHeadlineLines
                    )
                }

                TrailingUnit (
                    trailingContent = { trailingContent() }
                )
            }
            else {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .defaultMinSize(minHeight = ColumnMinHeight)
                ) {
                    HeadlineText(
                        largeHeadline = largeHeadline,
                        paddingEnabled = false,
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
        if (maxSupportingLines == 1) {
            Row(
                modifier = Modifier
                    .defaultMinSize(minHeight = minHeight)
                    .padding(paddingValues),
                content = content,
                verticalAlignment = Alignment.CenterVertically
            )
        } else {
            Row(
                modifier = Modifier
                    .defaultMinSize(minHeight = minHeight)
                    .padding(paddingValues),
                content = content
            )
        }
    }
}

@Composable
private fun HeadlineText (
    largeHeadline: Boolean,
    paddingEnabled: Boolean = true,
    text: String,
    maxLines: Int
) {
    val topPadding: Dp =
        if (paddingEnabled) {
            LargeHeadlineTopPadding
        } else {
            2.dp
        }

    if (largeHeadline) {
        Text(
            text = text,
            modifier = Modifier.padding(top = topPadding),
            style = MaterialTheme.typography.titleLarge,
            fontSize = 20.sp,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis
        )
    } else {
        Text(
            text = text,
            modifier = Modifier.padding(top = topPadding),
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
            modifier = Modifier.padding(bottom = SupportingBottomPadding),
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 14.sp,
            maxLines = maxLines
        )
    } else {
        Text(
            text = text,
            modifier = Modifier.padding(bottom = SupportingBottomPadding),
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 14.sp,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun LeadingUnit (
    leadingContent: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(end = HorizontalPadding)
            .widthIn(
                min = ContentMinWidth,
                max = ContentMaxWidth
            )
            .heightIn(
                min = ContentMinHeight,
                max = ContentMaxHeight
            ),
        contentAlignment = Alignment.Center,
    ) { leadingContent() }
}

@Composable
private fun TrailingUnit (
    trailingContent: @Composable (() -> Unit)
) {
    Box(
        modifier = Modifier
            .padding(start = HorizontalPadding)
            .widthIn(
                min = ContentMinWidth,
                max = ContentMaxWidth
            )
            .heightIn(
                min = ContentMinHeight,
                max = ContentMaxHeight
            ),
        contentAlignment = Alignment.Center,
    ) { trailingContent() }
}

object PixelyListItemDefaults {
    val ContainerColor: Color @Composable get() = MaterialTheme.colorScheme.surface
    val ContentColor: Color @Composable get() = MaterialTheme.colorScheme.onSurface
}

private val OneLineMinHeight: Dp = 60.dp
private val TwoLinesMinHeight: Dp = 80.dp

private val ContentMinHeight: Dp = 52.dp
private val ContentMinWidth: Dp = 52.dp
private val ContentMaxHeight: Dp = 60.dp
private val ContentMaxWidth: Dp = 110.dp

private val ColumnMinHeight: Dp = 60.dp

private val LargeHeadlineTopPadding: Dp = 7.dp
private val MediumHeadlineTopPadding: Dp = 10.dp
private val SupportingBottomPadding: Dp = 4.dp

private val HorizontalPadding: Dp = 10.dp
private val VerticalPadding: Dp = 10.dp