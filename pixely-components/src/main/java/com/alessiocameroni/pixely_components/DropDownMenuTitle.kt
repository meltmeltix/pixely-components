package com.alessiocameroni.pixely_components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PixelyDropdownMenuTitle(
    text: String
) {
    Text(
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 8.dp),
        text = text,
        style = MaterialTheme.typography.labelLarge
    )
}