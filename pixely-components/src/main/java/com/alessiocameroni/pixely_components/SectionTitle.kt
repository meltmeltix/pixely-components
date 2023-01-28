package com.alessiocameroni.pixely_components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
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
    modifier: Modifier,
    stringTitle: String,
    colors: PixelySectionTitleColors = PixelySectionTitleDefaults.colors()
) {
    SectionTitleContainer(
        modifier = modifier,
        containerColor = colors.containerColor().value,
        contentColor = colors.textColor().value,
        paddingValues = PaddingValues(
            start = SectionTitleTokens.HorizontalContainerPadding,
            top = SectionTitleTokens.TopContainerPadding,
            end = SectionTitleTokens.HorizontalContainerPadding,
            bottom = SectionTitleTokens.BottomContainerPadding
        )
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

@Composable
fun SectionTitleContainer(
    modifier: Modifier,
    containerColor: Color = PixelySectionTitleDefaults.containerColor,
    contentColor: Color = PixelySectionTitleDefaults.contentColor,
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
                .padding(paddingValues)
        ) { content() }
    }
}

object PixelySectionTitleDefaults {
    /**
     * The default container color value
     */
    val containerColor: Color @Composable get() = MaterialTheme.colorScheme.surface

    /**
     * The default content color value
     */
    val contentColor: Color @Composable get() = MaterialTheme.colorScheme.onSurface

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