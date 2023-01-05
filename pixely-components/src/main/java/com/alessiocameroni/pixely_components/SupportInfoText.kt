package com.alessiocameroni.pixely_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PixelySupportInfoText(
    modifier: Modifier,
    stringText: String
) {
    Text(
        modifier = modifier
            .padding(horizontal = 25.dp, vertical = 10.dp)
            .fillMaxWidth(),
        text = stringText,
        style = MaterialTheme.typography.bodyMedium,
        fontSize = 14.sp
    )
}