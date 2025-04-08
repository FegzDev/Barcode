package com.dkels_investment.barcode

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Barcode",
    ) {
        App()
    }
}