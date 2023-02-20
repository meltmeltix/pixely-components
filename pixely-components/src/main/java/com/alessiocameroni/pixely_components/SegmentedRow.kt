package com.alessiocameroni.pixely_components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.alessiocameroni.pixely_components.tokens.SegmentedRowTokens

/**
 * ### Pixely Segmented Row
 * This is a simple Row which is meant to be used with [PixelySegmentedColumn].
 * In simple terms, it's a simple row styled to fit inside [PixelySegmentedColumn], allowing to
 * create a visually distinct list from the rest of the screen.
 * A similar behavior can be found in the Google App search view.
 *
 * @param modifier to be applied to the Row container
 * @param colors [PixelySegmentedRowColors] that will be used to resolve the background color
 * of the item
 * @param content content to be included inside the row
 */
@Composable
fun PixelySegmentedRow(
    modifier: Modifier = Modifier,
    colors: PixelySegmentedRowColors = PixelySegmentedRowDefaults.colors(),
    content: @Composable RowScope.() -> Unit
) {
    SegmentedRowContainer(
        modifier = modifier,
        containerColor = colors.containerColor().value,
        shape = SegmentedRowTokens.RowShape
    ) { content() }
}

@Composable
private fun SegmentedRowContainer(
    modifier: Modifier,
    containerColor: Color = PixelySegmentedRowDefaults.containerColor,
    shape: Shape = PixelySegmentedRowDefaults.Shape,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        modifier = modifier,
        color = containerColor
    ) {
        Row(
            modifier = Modifier.clip(shape)
        ) { content() }
    }

}

object PixelySegmentedRowDefaults {
    /**
     * The default container color value
     */
    val containerColor: Color @Composable get() = SegmentedRowTokens.RowColor

    /**
     * The default container shape
     */
    val Shape: Shape @Composable get() = SegmentedRowTokens.RowShape

    /**
     * ### Pixely Segmented Row Colors
     * @param containerColor the container color applied to the Segmented Row
     */
    @Composable
    fun colors(
        containerColor: Color = SegmentedRowTokens.RowColor
    ): PixelySegmentedRowColors = PixelySegmentedRowColors(
        containerColor
    )
}

class PixelySegmentedRowColors internal constructor(
    private val containerColor: Color
) {
    @Composable
    fun containerColor(): State<Color> {
        return rememberUpdatedState(containerColor)
    }
}