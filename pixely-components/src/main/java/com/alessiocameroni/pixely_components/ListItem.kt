package com.alessiocameroni.pixely_components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import com.alessiocameroni.pixely_components.tokens.ListTokens

/**
 * ### Pixely List Item
 * This is structurally similar to the Material3 ListItem component.
 * This component layout has been tweaked so that it fits Material
 * You overall style, with more spaced out elements.
 *
 * @param modifier to be applied to the List Item container
 * @param enabled toggles enabled and disabled state
 * @param headlineTextString the Headline text of the List Item
 * @param largeHeadline toggles large or medium text style applied to the Headline text
 * @param maxHeadlineLines number of maximum lines applied to the Headline text
 * @param supportingTextString the Supporting text of the list item, below the Headline text
 * @param maxSupportingLines number of maximum lines applied to the Supporting text
 * @param leadingContent leading content on the left of the text column
 * @param trailingContent trailing content on the right of the text column
 * @param colors [PixelyListItemColors] that will be used to resolve the background and content color
 * of the item in different states
 */
@Composable
fun PixelyListItem(
    modifier: Modifier,
    enabled: Boolean = true,
    headlineTextString: String,
    largeHeadline: Boolean = true,
    maxHeadlineLines: Int = 1,
    supportingTextString: String? = null,
    maxSupportingLines: Int = 0,
    leadingContent: @Composable (() -> Unit)? = null,
    trailingContent: @Composable (() -> Unit)? = null,
    colors: PixelyListItemColors = PixelyListItemDefaults.colors()
) {
    if (supportingTextString == null) {
        // One-Line List Item
        ListItemContainer(
            modifier = modifier,
            containerColor = colors.containerColor().value,
            contentColor = colors.headlineColor(enabled = enabled).value,
            minHeight = ListTokens.OneLineMinHeight,
            paddingValues = PaddingValues(horizontal = ListTokens.ComponentPadding)
        ) {
            if (leadingContent != null && trailingContent != null) {
                // Headline Text, Leading and Trailing Content
                SideContent(
                    endPadding = ListTokens.ComponentPadding,
                    topAlign = true,
                    content = { leadingContent() },
                    color = colors.leadingContentColor(enabled = enabled).value
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = ListTokens.OneLineMinHeight),
                    verticalArrangement = Arrangement.Center
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        verticalPaddingEnabled = true,
                        color = colors.headlineColor(enabled = enabled).value,
                        maxLines = maxHeadlineLines
                    )
                }

                SideContent(
                    startPadding = ListTokens.ComponentPadding,
                    topAlign = true,
                    content = { trailingContent() },
                    color = colors.trailingContentColor(enabled = enabled).value
                )
            }
            else if (leadingContent != null) {
                // Headline Text and Leading Content only
                SideContent(
                    endPadding = ListTokens.ComponentPadding,
                    topAlign = true,
                    content = { leadingContent() },
                    color = colors.leadingContentColor(enabled = enabled).value
                )

                Column(
                    modifier = Modifier
                        .padding(end = ListTokens.OnlyTextHorizontalPadding)
                        .weight(1f)
                        .heightIn(min = ListTokens.OneLineMinHeight),
                    verticalArrangement = Arrangement.Center
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        verticalPaddingEnabled = true,
                        color = colors.headlineColor(enabled = enabled).value,
                        maxLines = maxHeadlineLines
                    )
                }
            }
            else if (trailingContent != null) {
                // Headline Text and Trailing Content only
                Column(
                    modifier = Modifier
                        .padding(start = ListTokens.OnlyTextHorizontalPadding)
                        .weight(1f)
                        .heightIn(min = ListTokens.OneLineMinHeight),
                    verticalArrangement = Arrangement.Center
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        verticalPaddingEnabled = true,
                        color = colors.headlineColor(enabled = enabled).value,
                        maxLines = maxHeadlineLines
                    )
                }

                SideContent(
                    startPadding = ListTokens.ComponentPadding,
                    topAlign = true,
                    content = { trailingContent() },
                    color = colors.trailingContentColor(enabled = enabled).value
                )
            }
            else {
                // Headline Text only
                Column(
                    modifier = Modifier
                        .padding(horizontal = ListTokens.OnlyTextHorizontalPadding)
                        .weight(1f)
                        .heightIn(min = ListTokens.OneLineMinHeight),
                    verticalArrangement = Arrangement.Center
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        verticalPaddingEnabled = true,
                        color = colors.headlineColor(enabled = enabled).value,
                        maxLines = maxHeadlineLines
                    )
                }
            }
        }
    } else {
        // Two-Line List Item
        ListItemContainer(
            modifier = modifier,
            containerColor = colors.containerColor().value,
            contentColor = colors.headlineColor(enabled = enabled).value,
            minHeight = ListTokens.TwoLineMinHeight,
            paddingValues = PaddingValues(ListTokens.ComponentPadding)
        ) {
            if (leadingContent != null && trailingContent != null) {
                // Headline and Supporting Text, Leading and Trailing Content
                SideContent(
                    endPadding = ListTokens.ComponentPadding,
                    topAlign = true,
                    content = { leadingContent() },
                    color = colors.leadingContentColor(enabled = enabled).value
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = ListTokens.OneLineMinHeight)
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        verticalPaddingEnabled = false,
                        color = colors.headlineColor(enabled = enabled).value,
                        maxLines = maxHeadlineLines
                    )

                    SupportingText(
                        text = supportingTextString,
                        color = colors.supportingTextColor().value,
                        maxLines = maxSupportingLines
                    )
                }

                SideContent(
                    startPadding = ListTokens.ComponentPadding,
                    topAlign = true,
                    content = { trailingContent() },
                    color = colors.trailingContentColor(enabled = enabled).value
                )
            }
            else if (leadingContent != null) {
                // Headline and Supporting Text, Leading Content only
                SideContent(
                    endPadding = ListTokens.ComponentPadding,
                    topAlign = true,
                    content = { leadingContent() },
                    color = colors.leadingContentColor(enabled = enabled).value
                )

                Column(
                    modifier = Modifier
                        .padding(end = ListTokens.OnlyTextHorizontalPadding)
                        .weight(1f)
                        .heightIn(min = ListTokens.OneLineMinHeight)
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        verticalPaddingEnabled = false,
                        color = colors.headlineColor(enabled = enabled).value,
                        maxLines = maxHeadlineLines
                    )

                    SupportingText(
                        text = supportingTextString,
                        color = colors.supportingTextColor().value,
                        maxLines = maxSupportingLines
                    )
                }
            }
            else if (trailingContent != null) {
                // Headline and Supporting Text, Trailing Content only
                Column(
                    modifier = Modifier
                        .padding(start = ListTokens.OnlyTextHorizontalPadding)
                        .weight(1f)
                        .heightIn(min = ListTokens.OneLineMinHeight)
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        verticalPaddingEnabled = false,
                        color = colors.headlineColor(enabled = enabled).value,
                        maxLines = maxHeadlineLines
                    )

                    SupportingText(
                        text = supportingTextString,
                        color = colors.supportingTextColor().value,
                        maxLines = maxSupportingLines
                    )
                }

                SideContent(
                    startPadding = ListTokens.ComponentPadding,
                    topAlign = true,
                    content = { trailingContent() },
                    color = colors.trailingContentColor(enabled = enabled).value
                )
            }
            else {
                // Headline and Supporting Text only
                Column(
                    modifier = Modifier
                        .padding(horizontal = ListTokens.OnlyTextHorizontalPadding)
                        .weight(1f)
                        .heightIn(min = ListTokens.OneLineMinHeight)
                ) {
                    HeadlineText(
                        largeText = largeHeadline,
                        text = headlineTextString,
                        verticalPaddingEnabled = false,
                        color = colors.headlineColor(enabled = enabled).value,
                        maxLines = maxHeadlineLines
                    )

                    SupportingText(
                        text = supportingTextString,
                        color = colors.supportingTextColor().value,
                        maxLines = maxSupportingLines
                    )
                }
            }
        }
    }
}

@Composable
private fun ListItemContainer(
    modifier: Modifier,
    containerColor: Color = PixelyListItemDefaults.containerColor,
    contentColor: Color = PixelyListItemDefaults.contentColor,
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
    color: Color = PixelyListItemDefaults.contentColor,
    maxLines: Int
) {
    val paddingModifier: Modifier =
        if (verticalPaddingEnabled) {
            Modifier.padding(vertical = ListTokens.OneLineTextVerticalPadding)
        } else {
            if (largeText) {
                Modifier.padding(top = ListTokens.LargeHeadlineTopPadding)
            } else {
                Modifier.padding(top = ListTokens.MediumHeadlineTopPadding)
            }
        }

    if (largeText) {
        Text(
            text = text,
            modifier = paddingModifier,
            style = ListTokens.LargeHeadlineTextStyle,
            fontSize = ListTokens.LargeHeadlineTextSize,
            color = color,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis
        )
    } else {
        Text(
            text = text,
            modifier = paddingModifier,
            style = ListTokens.MediumHeadlineTextStyle,
            color = color,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun SupportingText(
    text: String,
    color: Color = PixelyListItemDefaults.contentSecondaryColor,
    maxLines: Int
) {
    if(maxLines > 0) {
        Text(
            text = text,
            modifier = Modifier.padding(bottom = ListTokens.SupportingTextBottomPadding),
            style = ListTokens.SupportingTextStyle,
            fontSize = ListTokens.SupportingTextSize,
            color = color,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis
        )
    } else {
        Text(
            text = text,
            modifier = Modifier.padding(bottom = ListTokens.SupportingTextBottomPadding),
            style = ListTokens.SupportingTextStyle,
            fontSize = ListTokens.SupportingTextSize,
            color = color
        )
    }
}

@Composable
private fun SideContent(
    startPadding: Dp = ListTokens.ContentNoPadding,
    endPadding: Dp = ListTokens.ContentNoPadding,
    topAlign: Boolean,
    content: @Composable (() -> Unit),
    color: Color = PixelyListItemDefaults.contentColor
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
        CompositionLocalProvider(LocalContentColor provides color) {
            Box(
                modifier = Modifier
                    .heightIn(
                        min = ListTokens.ContentMinHeight,
                        max = ListTokens.ContentMaxHeight
                    )
                    .widthIn(
                        min = ListTokens.ContentMinWidth,
                        max = ListTokens.ContentMaxWidth
                    ),
                contentAlignment = Alignment.Center
            ) { content() }
        }
    }
}

object PixelyListItemDefaults {
    /**
     * The default container color value
     */
    val containerColor: Color @Composable get() = MaterialTheme.colorScheme.surface

    /**
     * The default content color value
     */
    val contentColor: Color @Composable get() = MaterialTheme.colorScheme.onSurface

    /**
     * The default secondary content color value
     */
    val contentSecondaryColor: Color @Composable get() = MaterialTheme.colorScheme.onSurfaceVariant

    /**
     * ### Pixely List Item Colors
     *
     * @param containerColor the container color applied to the List Item
     * @param leadingContentColor the color applied to the Leading Content
     * @param headlineColor the color applied to the Headline Text
     * @param supportingTextColor the color applied to the Supporting Text
     * @param trailingContentColor the color applied to the Trailing Content
     * @param disabledLeadingContentColor the color applied to the Leading Content when the List Item
     * is disabled
     * @param disabledHeadlineColor the color applied to the Headline Text when the List Item is
     * disabled
     * @param disabledTrailingContentColor the color applied to the Trailing Content when the List
     * Item is disabled
     */
    @Composable
    fun colors(
        containerColor: Color = ListTokens.ContainerColor,
        leadingContentColor: Color = ListTokens.LeadingContentColor,
        headlineColor: Color = ListTokens.HeadlineColor,
        supportingTextColor: Color = ListTokens.SupportingTextColor,
        trailingContentColor: Color = ListTokens.TrailingContentColor,
        disabledLeadingContentColor: Color = ListTokens.DisabledLeadingContentColor,
        disabledHeadlineColor: Color = ListTokens.DisabledHeadlineColor,
        disabledTrailingContentColor: Color = ListTokens.DisabledTrailingContentColor
    ): PixelyListItemColors = PixelyListItemColors(
            containerColor,
            leadingContentColor,
            headlineColor,
            supportingTextColor,
            trailingContentColor,
            disabledHeadlineColor,
            disabledLeadingContentColor,
            disabledTrailingContentColor
        )
}

@Immutable
class PixelyListItemColors internal constructor(
    private val containerColor: Color,
    private val leadingContentColor: Color,
    private val headlineColor: Color,
    private val supportingTextColor: Color,
    private val trailingContentColor: Color,
    private val disabledHeadlineColor: Color,
    private val disabledLeadingContentColor: Color,
    private val disabledTrailingContentColor: Color
) {
    @Composable
    internal fun containerColor(): State<Color> {
        return rememberUpdatedState(containerColor)
    }

    @Composable
    internal fun leadingContentColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(
            if (enabled) leadingContentColor else disabledLeadingContentColor
        )
    }

    @Composable
    internal fun headlineColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(
            if (enabled) headlineColor else disabledHeadlineColor
        )
    }

    @Composable
    internal fun supportingTextColor(): State<Color> {
        return rememberUpdatedState(supportingTextColor)
    }

    @Composable
    internal fun trailingContentColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(
            if (enabled) trailingContentColor else disabledTrailingContentColor
        )
    }
}