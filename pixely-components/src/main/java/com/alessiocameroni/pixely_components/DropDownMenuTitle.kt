package com.alessiocameroni.pixely_components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.alessiocameroni.pixely_components.tokens.DropDownMenuTitleTokens

/**
 * ### Pixely DropDown Menu Title
 * This is a component to compensate the absence of a title in
 * the DropDown Menu components. This serves as a title of a
 * category, or a submenu for DropDown Menus.
 *
 * @param modifier to be applied to the Drop Down Menu Title container
 * @param stringTitle the title text of the Menu Title
 * @param colors that will be used to resolve the background and content color
 * of the item in different states
 */
@Composable
fun PixelyDropdownMenuTitle(
    modifier: Modifier = Modifier,
    stringTitle: String,
    colors: PixelyDropDownMenuTitleColors = PixelyDropDownMenuTitleDefaults.colors()
) {
    DropDownMenuTitleContainer(
        modifier = modifier,
        containerColor = colors.containerColor().value,
        contentColor = colors.textColor().value,
        stringTitle = stringTitle
    )
}

@Composable
private fun DropDownMenuTitleContainer(
    modifier: Modifier,
    containerColor: Color = PixelyDropDownMenuTitleDefaults.containerColor,
    contentColor: Color = PixelyDropDownMenuTitleDefaults.contentColor,
    stringTitle: String
) {
    Surface(
        modifier = modifier,
        color = containerColor,
        contentColor = contentColor
    ) {
        Text(
            modifier = Modifier
                .padding(
                    horizontal = DropDownMenuTitleTokens.TextHorizontalPadding,
                    vertical = DropDownMenuTitleTokens.TextVerticalPadding
                ),
            text = stringTitle,
            style = DropDownMenuTitleTokens.TextStyle
        )
    }
}

object PixelyDropDownMenuTitleDefaults {
    /**
     * The default container color value
     */
    val containerColor: Color @Composable get() = DropDownMenuTitleTokens.ContainerColor

    /**
     * The default content color value
     */
    val contentColor: Color @Composable get() = DropDownMenuTitleTokens.TextColor

    /**
     * ### Pixely Drop Down Menu Title Colors
     *
     * @param containerColor the container color applied to the Drop Down Menu title
     * @param textColor the text color applied to the Drop Down Menu title
     */
    @Composable
    fun colors (
        containerColor: Color = DropDownMenuTitleTokens.ContainerColor,
        textColor: Color = DropDownMenuTitleTokens.TextColor
    ): PixelyDropDownMenuTitleColors = PixelyDropDownMenuTitleColors(
        containerColor,
        textColor
    )
}

class PixelyDropDownMenuTitleColors internal constructor(
    private val containerColor: Color,
    private val textColor: Color
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