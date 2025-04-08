package com.dkels_investment.barcode

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    var buffer by remember { mutableStateOf("") }
    val focusRequester = remember(::FocusRequester)

    Box(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .alpha(0f)
                .focusable()
                .focusRequester(focusRequester)
                .onPreviewKeyEvent { event ->
                    if (event.type == KeyEventType.KeyDown) {
                        val char = event.key.nativeKeyCode.toChar()  // Get the character

                        if (char.isDigit() || char.isLetter()) {
                            buffer += char  // Append character
                        }

                        true
                    } else {
                        false
                    }
                },
            readOnly = true,
            shape = CircleShape
        )

        Text(text = buffer.ifBlank { "No Barcode" }, textAlign = TextAlign.Center)
    }

    LaunchedEffect(Unit) {
        val requestedFocus = focusRequester.requestFocus()
        println("RequestedFocus: $requestedFocus")
    }
}