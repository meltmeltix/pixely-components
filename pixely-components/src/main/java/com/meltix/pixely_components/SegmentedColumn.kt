package com.meltix.pixely_components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.meltix.pixely_components.tokens.SegmentedColumnTokens

/**
 * ### Pixely Segmented Column
 * This is a simple Column which is meant to be used with [PixelySegmentedRow].
 * In simple terms, it's a column styled so that with [PixelySegmentedRow] it's possible to create
 * a list with a Level 2 surface color and a rounded shape.
 * A similar behavior can be found in the Google App search view.
 *
 * @param modifier to be applied to the Column container surface
 * @param colors [PixelySegmentedColumnColors] that will be used to resolve the background color
 * of the item
 * @param content content to be included inside the column
 */
@Composable
fun PixelySegmentedColumn(
    modifier: Modifier = Modifier,
    colors: PixelySegmentedColumnColors = PixelySegmentedColumnDefaults.colors(),
    content: @Composable ColumnScope.() -> Unit,
) {
    SegmentedColumnContainer(
        modifier = modifier,
        containerColor = colors.containerColor().value,
        paddingValues = PaddingValues(
            horizontal = SegmentedColumnTokens.ColumnHorizontalPadding
        )
    ) { content() }
}

@Composable
private fun SegmentedColumnContainer(
    modifier: Modifier,
    containerColor: Color = PixelySegmentedColumnDefaults.containerColor,
    paddingValues: PaddingValues,
    shape: Shape = PixelySegmentedColumnDefaults.Shape,
    content: @Composable ColumnScope.() -> Unit
) {
    Surface(
        modifier = modifier,
        color = containerColor,
    ) {
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .clip(shape),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) { content() }
    }
}

object PixelySegmentedColumnDefaults {
    /**
     * The default container color value
     */
    val containerColor: Color @Composable get() = SegmentedColumnTokens.ColumnColor

    /**
     * The default container shape
     */
    val Shape: Shape @Composable get() = SegmentedColumnTokens.ColumnShape

    /**
     * ### Pixely Segmented Column Colors
     *
     * @param containerColor the container color applied to the Segmented Column
     */
    @Composable
    fun colors(
        containerColor: Color = SegmentedColumnTokens.ColumnColor
    ): PixelySegmentedColumnColors = PixelySegmentedColumnColors(
        containerColor
    )
}

class PixelySegmentedColumnColors internal constructor(
    private val containerColor: Color
) {
    @Composable
    fun containerColor(): State<Color> {
        return rememberUpdatedState(containerColor)
    }
}