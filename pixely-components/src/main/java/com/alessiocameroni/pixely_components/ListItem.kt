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
 * @param modifier to be applied to the List Item container
 * @param headlineTextString the Headline text of the List Item
 * @param largeHeadline toggles large or medium text style applied to the Headline text
 * @param maxHeadlineLines number of maximum lines applied to the Headline text
 * @param supportingTextString the Supporting text of the list item, below the Headline text
 * @param maxSupportingTextLines number of maximum lines applied to the Supporting text
 * @param leadingContent leading content on the left of the text column
 * @param trailingContent trailing content on the right of the text column
 */
@Composable
fun PixelyListItem(
    modifier: Modifier,
    headlineTextString: String,
    largeHeadline: Boolean = true,
    maxHeadlineLines: Int = 1,
    supportingTextString: String? = null,
    maxSupportingTextLines: Int = 0,
    leadingContent: @Composable (() -> Unit)? = null,
    trailingContent: @Composable (() -> Unit)? = null
) {
    if (supportingTextString == null) {
        // One-Line List Item
        ListItemContainer(
            modifier = modifier,
            containerColor = PixelyListItemDefaults.ContainerColor,
            contentColor = PixelyListItemDefaults.ContentColor,
            minHeight = OneLineMinHeight,
            paddingValues = PaddingValues(horizontal = ComponentPadding)
        ) {
            if (leadingContent != null && trailingContent != null) {
                // Headline Text, Leading and Trailing Content
                SideContent(
                    endPadding = ComponentPadding,
                    topAlign = true,
                    content = { leadingContent() }
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = OneLineMinHeight),
                    verticalArrangement = Arrangement.Center
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        verticalPaddingEnabled = true,
                        color = PixelyListItemDefaults.ContentColor,
                        maxLines = maxHeadlineLines
                    )
                }

                SideContent(
                    startPadding = ComponentPadding,
                    topAlign = true,
                    content = { trailingContent() }
                )
            }
            else if (leadingContent != null) {
                // Headline Text and Leading Content only
                SideContent(
                    endPadding = ComponentPadding,
                    topAlign = true,
                    content = { leadingContent() }
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = OneLineMinHeight),
                    verticalArrangement = Arrangement.Center
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        verticalPaddingEnabled = true,
                        color = PixelyListItemDefaults.ContentColor,
                        maxLines = maxHeadlineLines
                    )
                }
            }
            else if (trailingContent != null) {
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
                        verticalPaddingEnabled = true,
                        color = PixelyListItemDefaults.ContentColor,
                        maxLines = maxHeadlineLines
                    )
                }

                SideContent(
                    startPadding = ComponentPadding,
                    topAlign = true,
                    content = { trailingContent() }
                )
            }
            else {
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
                        verticalPaddingEnabled = true,
                        color = PixelyListItemDefaults.ContentColor,
                        maxLines = maxHeadlineLines
                    )
                }
            }
        }
    } else {
        // Two-Line List Item
        ListItemContainer(
            modifier = modifier,
            containerColor = PixelyListItemDefaults.ContainerColor,
            contentColor = PixelyListItemDefaults.ContentColor,
            minHeight = TwoLineMinHeight,
            paddingValues = PaddingValues(ComponentPadding)
        ) {
            if (leadingContent != null && trailingContent != null) {
                // Headline and Supporting Text, Leading and Trailing Content
                SideContent(
                    endPadding = ComponentPadding,
                    topAlign = true,
                    content = { leadingContent() }
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = OneLineMinHeight)
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        verticalPaddingEnabled = false,
                        color = PixelyListItemDefaults.ContentColor,
                        maxLines = maxHeadlineLines
                    )

                    SupportingText(
                        text = supportingTextString,
                        color = PixelyListItemDefaults.ContentSecondaryColor,
                        maxLines = maxSupportingTextLines
                    )
                }

                SideContent(
                    startPadding = ComponentPadding,
                    topAlign = true,
                    content = { trailingContent() }
                )
            }
            else if (leadingContent != null) {
                // Headline and Supporting Text, Leading Content only
                SideContent(
                    endPadding = ComponentPadding,
                    topAlign = true,
                    content = { leadingContent() }
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = OneLineMinHeight)
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        verticalPaddingEnabled = false,
                        color = PixelyListItemDefaults.ContentColor,
                        maxLines = maxHeadlineLines
                    )

                    SupportingText(
                        text = supportingTextString,
                        color = PixelyListItemDefaults.ContentSecondaryColor,
                        maxLines = maxSupportingTextLines
                    )
                }
            }
            else if (trailingContent != null) {
                // Headline and Supporting Text, Trailing Content only
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = OneLineMinHeight)
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        verticalPaddingEnabled = false,
                        color = PixelyListItemDefaults.ContentColor,
                        maxLines = maxHeadlineLines
                    )

                    SupportingText(
                        text = supportingTextString,
                        color = PixelyListItemDefaults.ContentSecondaryColor,
                        maxLines = maxSupportingTextLines
                    )
                }

                SideContent(
                    startPadding = ComponentPadding,
                    topAlign = true,
                    content = { trailingContent() }
                )
            }
            else {
                // Headline and Supporting Text only
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = OneLineMinHeight)
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        verticalPaddingEnabled = false,
                        color = PixelyListItemDefaults.ContentColor,
                        maxLines = maxHeadlineLines
                    )

                    SupportingText(
                        text = supportingTextString,
                        color = PixelyListItemDefaults.ContentSecondaryColor,
                        maxLines = maxSupportingTextLines
                    )
                }
            }
        }
    }
}

@Composable
private fun ListItemContainer(
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
                .height(IntrinsicSize.Min)
                .heightIn(min = minHeight)
                .padding(paddingValues),
            content = content,
            verticalAlignment = Alignment.CenterVertically
        )
    }
}

@Composable
private fun HeadlineText(
    largeText: Boolean,
    text: String,
    verticalPaddingEnabled: Boolean = false,
    color: Color,
    maxLines: Int
) {
    val paddingModifier: Modifier =
        if (verticalPaddingEnabled) {
            Modifier.padding(vertical = OneLineTextVerticalPadding)
        } else {
            if (largeText) {
                Modifier.padding(top = LargeHeadlineTopPadding)
            } else {
                Modifier.padding(top = MediumHeadlineTopPadding)
            }
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
    if(maxLines > 0) {
        Text(
            text = text,
            modifier = Modifier.padding(bottom = SupportingTextBottomPadding),
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 14.sp,
            color = color,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis
        )
    } else {
        Text(
            text = text,
            modifier = Modifier.padding(bottom = SupportingTextBottomPadding),
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 14.sp,
            color = color
        )
    }
}

@Composable
private fun SideContent(
    startPadding: Dp = 0.dp,
    endPadding: Dp = 0.dp,
    topAlign: Boolean,
    content: @Composable (() -> Unit)
) {
    val alignmentMode: Alignment =
        if (topAlign) {
            Alignment.TopCenter
        } else {
            Alignment.Center
        }

    Box(
        modifier = Modifier
            .padding(
                start = startPadding,
                end = endPadding
            )
            .fillMaxHeight(),
        contentAlignment = alignmentMode
    ) {
        Box(
            modifier = Modifier
                .heightIn(
                    min = ContentMinHeight,
                    max = ContentMaxHeight
                )
                .widthIn(
                    min = ContentMinWidth,
                    max = ContentMaxWidth
                ),
            contentAlignment = Alignment.Center
        ) { content() }
    }
}

object PixelyListItemDefaults {
    val ContainerColor: Color @Composable get() = MaterialTheme.colorScheme.surface
    val ContentColor: Color @Composable get() = MaterialTheme.colorScheme.onSurface
    val ContentSecondaryColor: Color @Composable get() = MaterialTheme.colorScheme.onSurfaceVariant
}

// Component related values
private val ComponentPadding: Dp = 10.dp

// Container/Row related values
private val OneLineMinHeight: Dp = 60.dp
private val TwoLineMinHeight: Dp = 80.dp

// Text related values
private val LargeHeadlineTopPadding: Dp = 6.dp
private val MediumHeadlineTopPadding: Dp = 9.dp
private val SupportingTextBottomPadding: Dp = 5.dp

private val OneLineTextVerticalPadding: Dp = 10.dp

// Leading and trailing content related values
private val ContentMinHeight: Dp = 60.dp
private val ContentMinWidth: Dp = 52.dp

private val ContentMaxHeight: Dp = 60.dp
private val ContentMaxWidth: Dp = 110.dp