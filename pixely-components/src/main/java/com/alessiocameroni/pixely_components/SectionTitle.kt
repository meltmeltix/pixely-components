package com.alessiocameroni.pixely_components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import com.alessiocameroni.pixely_components.tokens.SectionTitleTokens

/**
 * ### Pixely Section Title
 * This component allows you to add a little title in your screen.
 * This is often used in Android's Settings as some sections are
 * addressed through a simple short title.
 *
 * @param modifier to be applied to the Section Title container
 * @param stringTitle the title text of the Section Title
 * @param colors [PixelySectionTitleColors] that will be used to resolve the background and
 * content color of the item in different states
 */
@Composable
fun PixelySectionTitle(
    modifier: Modifier = Modifier,
    stringTitle: String,
    trailingUnit: @Composable (() -> Unit)? = null,
    horizontalContentPadding: Dp = SectionTitleTokens.HorizontalContainerPadding,
    colors: PixelySectionTitleColors = PixelySectionTitleDefaults.colors()
) {
    if (trailingUnit != null) {
        SectionTitleContainer(
            modifier = modifier,
            containerColor = colors.containerColor().value,
            contentColor = colors.textColor().value,
            centerAlign = true,
            paddingValues = PaddingValues(
                start = horizontalContentPadding,
                top = SectionTitleTokens.TopContainerUnitPadding,
                end = horizontalContentPadding,
                bottom = SectionTitleTokens.BottomContainerUnitPadding
            )
        ) {
            Text(
                modifier = Modifier
                    .padding(end = SectionTitleTokens.TextEndPadding)
                    .weight(SectionTitleTokens.TextWeight),
                color = colors.textColor().value,
                text = stringTitle,
                style = SectionTitleTokens.TextStyle,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            trailingUnit()
        }
    } else {
        SectionTitleContainer(
            modifier = modifier,
            containerColor = colors.containerColor().value,
            contentColor = colors.textColor().value,
            centerAlign = false,
            paddingValues = PaddingValues(
                start = horizontalContentPadding,
                top = SectionTitleTokens.TopContainerPadding,
                end = horizontalContentPadding,
                bottom = SectionTitleTokens.BottomContainerPadding
            ),
        ) {
            Text(
                modifier = Modifier.weight(SectionTitleTokens.TextWeight),
                color = colors.textColor().value,
                text = stringTitle,
                style = SectionTitleTokens.TextStyle,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun SectionTitleContainer(
    modifier: Modifier,
    containerColor: Color = PixelySectionTitleDefaults.containerColor,
    contentColor: Color = PixelySectionTitleDefaults.contentColor,
    paddingValues: PaddingValues,
    centerAlign: Boolean,
    content: @Composable (RowScope.() -> Unit),
) {
    Surface(
        modifier = modifier,
        color = containerColor,
        contentColor = contentColor
    ) {
        if (centerAlign) {
            Row (
                modifier = Modifier.padding(paddingValues),
                verticalAlignment = Alignment.CenterVertically
            ) { content() }
        } else {
            Row (modifier = Modifier.padding(paddingValues)) { content() }
        }
    }
}

object PixelySectionTitleDefaults {
    /**
     * The default container color value
     */
    val containerColor: Color @Composable get() = SectionTitleTokens.ContainerColor

    /**
     * The default content color value
     */
    val contentColor: Color @Composable get() = SectionTitleTokens.TextColor

    /**
     * ### Pixely Section Title Colors
     * @param containerColor the container color applied to the Section title
     * @param textColor the text color applied to the Section title
     */
    @Composable
    fun colors(
        containerColor: Color = SectionTitleTokens.ContainerColor,
        textColor: Color = SectionTitleTokens.TextColor,
    ): PixelySectionTitleColors = PixelySectionTitleColors(
        containerColor = containerColor,
        textColor = textColor
    )
}

class PixelySectionTitleColors internal constructor(
    private val containerColor: Color,
    private val textColor: Color,
) {
    @Composable
    internal fun containerColor(): State<Color> {
        return rememberUpdatedState(containerColor)
    }

    @Composable
    internal fun textColor(): State<Color> {
        return rememberUpdatedState(textColor)
    }
}