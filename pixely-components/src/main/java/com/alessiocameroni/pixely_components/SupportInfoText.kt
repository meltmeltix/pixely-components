package com.alessiocameroni.pixely_components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PixelySupportInfoText(
    modifier: Modifier,
    stringText: String,
    painterInfoIcon: Painter? = null,
    descriptionInfoIcon: String? = null
) {
    Column(
        modifier = modifier
            .padding(horizontal = 25.dp, vertical = 10.dp)
            .fillMaxWidth(),
    ) {
        if (painterInfoIcon != null) {
            Icon(
                modifier = Modifier
                    .padding(bottom = 20.dp),
                painter = painterInfoIcon,
                contentDescription = descriptionInfoIcon
            )
        }

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringText,
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 14.sp
        )
    }
}