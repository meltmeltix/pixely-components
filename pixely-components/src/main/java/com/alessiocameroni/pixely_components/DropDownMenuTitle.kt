package com.alessiocameroni.pixely_components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * ### Pixely DropDown Menu Title
 * This is a component to compensate the absence of a title in
 * the DropDown Menu components. This serves as a title of a
 * category, or a submenu for DropDown Menus.
 *
 * @param stringTitle the title text of the Menu Title
 */
@Composable
fun PixelyDropdownMenuTitle(
    stringTitle: String
) {
    Text(
        modifier = Modifier
            .padding(
                horizontal = TextHorizontalPadding,
                vertical = TextVerticalPadding
            ),
        text = stringTitle,
        style = MaterialTheme.typography.labelLarge
    )
}

// Text related values
private val TextHorizontalPadding: Dp = 12.dp
private val TextVerticalPadding: Dp = 8.dp