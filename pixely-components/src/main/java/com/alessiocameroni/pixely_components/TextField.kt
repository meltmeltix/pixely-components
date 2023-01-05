package com.alessiocameroni.pixely_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.ImeAction

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PixelyTextField (
    valueText: String,
    placeHolderString: String,
    clearTrailingIcon: Painter,
    descriptionTrailingIcon: String,
    onSearch: (KeyboardActionScope.() -> Unit)?
) {
    var text by rememberSaveable { mutableStateOf(valueText) }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = { text = it },
        placeholder = { Text(text = placeHolderString) },
        textStyle = MaterialTheme.typography.titleMedium,
        singleLine = true,
        trailingIcon = {
            IconButton(onClick = { text = "" }) {
                Icon(
                    painter = clearTrailingIcon,
                    contentDescription = descriptionTrailingIcon,
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = onSearch),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.background,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.background,
            focusedIndicatorColor = MaterialTheme.colorScheme.background
        )
    )
}