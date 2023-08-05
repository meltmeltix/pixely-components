package com.meltix.pixely_components

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

/**
 * ### Pixely Text Field
 * This component is a normal TextField without decorations or borders.
 * This component is meant to be included with other components such
 * as a TopAppBar.
 *
 * @param stringText the text written inside the Text Field
 * @param stringPlaceHolder the text of the placeholder of the Text Field
 * @param clearTrailingIcon the Icon displayed on the right of the Text Field
 * @param descriptionTrailingIcon the accessibility description of the Trailing Icon
 * @param onSearch the action performed when pressing Submit on the keyboard
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PixelyTextField (
    stringText: String,
    stringPlaceHolder: String,
    clearTrailingIcon: Painter,
    descriptionTrailingIcon: String,
    onSearch: (KeyboardActionScope.() -> Unit)?
) {
    var text by rememberSaveable { mutableStateOf(stringText) }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = { text = it },
        placeholder = { Text(text = stringPlaceHolder) },
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
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.background,
            unfocusedContainerColor = MaterialTheme.colorScheme.background,
            disabledContainerColor = MaterialTheme.colorScheme.background,
            focusedIndicatorColor = MaterialTheme.colorScheme.background,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.background,
        )
    )
}