package com.alessiocameroni.pixely_components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * ### Pixely Section Title
 * This component allows you to add a little title in your screen.
 * This is often used in Android's Settings as some sections are
 * addressed through a simple short title.
 *
 * @param modifier to be applied to the Section Title container
 * @param stringTitle the title text of the Section Title
 */
@Composable
fun PixelySectionTitle(
    modifier: Modifier,
    stringTitle: String,
) {
    Row(modifier = modifier) {
        Text(
            modifier = Modifier
                .padding(horizontal = UpperTextPadding)
                .padding(
                    top = UpperTextPadding,
                    bottom = BottomTextPadding
                )
                .weight(1f),
            color = MaterialTheme.colorScheme.primary,
            text = stringTitle,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

// Text related values
private val UpperTextPadding: Dp = 25.dp
private val BottomTextPadding: Dp = 5.dp