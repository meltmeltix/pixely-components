package com.alessiocameroni.pixely_components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
 */
@Composable
fun PixelySupportInfoText(
    modifier: Modifier,
    stringText: String,
    painterInfoIcon: Painter? = null,
    descriptionInfoIcon: String? = null
) {
    SupportInfoTextContainer(
        modifier = modifier,
        containerColor = PixelySupportInfoTextDefaults.ContainerColor,
        contentColor = PixelySupportInfoTextDefaults.ContentColor,
        paddingValues = PaddingValues(
            horizontal = HorizontalColumnPadding,
            vertical = VerticalColumnPadding
        )
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            if (painterInfoIcon != null) {
                Icon(
                    modifier = Modifier
                        .padding(bottom = BottomIconPadding),
                    painter = painterInfoIcon,
                    contentDescription = descriptionInfoIcon
                )
            }

            Text(
                text = stringText,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
private fun SupportInfoTextContainer(
    modifier: Modifier,
    containerColor: Color,
    contentColor: Color,
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
    val ContainerColor: Color @Composable get() = MaterialTheme.colorScheme.surface
    val ContentColor: Color @Composable get() = MaterialTheme.colorScheme.onSurface
    val ContentSecondaryColor: Color @Composable get() = MaterialTheme.colorScheme.onSurfaceVariant
}

// Column related values
private val HorizontalColumnPadding: Dp = 20.dp
private val VerticalColumnPadding: Dp = 10.dp

// Icon related values
private val BottomIconPadding: Dp = 20.dp