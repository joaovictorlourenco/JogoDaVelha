package com.example.jogodavelha.ui.screens.components

import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable

fun ComposableErro() {
    AlertDialog(onDismissRequest = { setShowDialog(false) }, confirmButton = { TextButton(onClick = { onConfirmButton() }) {

    }} ) {

    }
}

@Preview
@Composable
fun PreviewComposableErro() {
    ComposableErro()
}