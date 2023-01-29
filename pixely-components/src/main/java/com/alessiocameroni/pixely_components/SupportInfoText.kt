package com.alessiocameroni.pixely_components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import com.alessiocameroni.pixely_components.tokens.SupportInfoTokens

/**
 * ### Pixely Support Info Text
 * This component allows to write a paragraph, meant to give information
 * about a specific action or purpose in the screen. This is often used
 * in Android's Settings as different actions need complementary information.
 *
 * @param modifier to be applied to the Support Info Text container
 * @param stringText the body text of the Support Info Text
 * @param painterInfoIcon the painter of the Info Icon
 * @param descriptionInfoIcon the accessibility description of the Info Icon
 * @param colors [PixelySupportInfoTextColors] that will be used to resolve the background and
 * content color of the item in different states
 */
@Composable
fun PixelySupportInfoText(
    modifier: Modifier,
    stringText: String,
    painterInfoIcon: Painter? = null,
    descriptionInfoIcon: String? = null,
    colors: PixelySupportInfoTextColors = PixelySupportInfoTextDefaults.colors()
) {
    SupportInfoTextContainer(
        modifier = modifier,
        containerColor = colors.containerColor().value,
        contentColor = colors.textColor().value,
        paddingValues = PaddingValues(
            horizontal = SupportInfoTokens.HorizontalColumnPadding,
            vertical = SupportInfoTokens.VerticalColumnPadding
        )
    ) {
        Column(modifier = Modifier.weight(SupportInfoTokens.TextColumnWeight)) {
            if (painterInfoIcon != null) {
                Icon(
                    modifier = Modifier.padding(bottom = SupportInfoTokens.BottomIconPadding),
                    painter = painterInfoIcon,
                    contentDescription = descriptionInfoIcon,
                    tint = colors.overlineIconColor().value
                )
            }

            Text(
                text = stringText,
                color = colors.textColor().value,
                style = SupportInfoTokens.TextStyle,
                fontSize = SupportInfoTokens.TextSize
            )
        }
    }
}

@Composable
private fun SupportInfoTextContainer(
    modifier: Modifier,
    containerColor: Color = PixelySupportInfoTextDefaults.containerColor,
    contentColor: Color = PixelySupportInfoTextDefaults.contentColor,
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
                .padding(paddingValues),
            content = { content() }
        )
    }
}

object PixelySupportInfoTextDefaults {
    /**
     * The default container color value
     */
    val containerColor: Color @Composable get() = SupportInfoTokens.ContainerColor

    /**
     * The default content color value
     */
    val contentColor: Color @Composable get() = SupportInfoTokens.TextColor

    /**
     * ## Pixely Support Info Text colors
     *
     * @param containerColor the container color applied to the Support Info Text
     * @param overlineIconColor the color applied to the Icon over the text
     * @param textColor the color applied to the Text
     */
    @Composable
    fun colors(
        containerColor: Color = SupportInfoTokens.ContainerColor,
        overlineIconColor: Color = SupportInfoTokens.OverlineIconColor,
        textColor: Color = SupportInfoTokens.TextColor
    ): PixelySupportInfoTextColors = PixelySupportInfoTextColors(
        containerColor,
        overlineIconColor,
        textColor,
    )
}

class PixelySupportInfoTextColors internal constructor(
    private val containerColor: Color,
    private val overlineIconColor: Color,
    private val textColor: Color,
) {
    @Composable
    internal fun containerColor(): State<Color> {
        return rememberUpdatedState(containerColor)
    }

    @Composable
    internal fun overlineIconColor(): State<Color> {
        return rememberUpdatedState(overlineIconColor)
    }

    @Composable
    internal fun textColor(): State<Color> {
        return rememberUpdatedState(textColor)
    }
}