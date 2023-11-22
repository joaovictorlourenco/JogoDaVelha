package com.example.jogodavelha.ui.screens.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: ImageVector,
    color: Color = Color.White,
    description: String? = null
) {
    Icon(
        imageVector = icon,
        contentDescription = description,
        modifier = modifier.clickable { onClick() },
        tint = color,
    )
}


@Preview
@Composable
private fun IconButtonPreview() {
    IconButton(
        onClick = { Log.d("Click", "IconExample") },
        icon = Icons.Filled.ArrowBack,
        description = "Voltar",
        modifier = Modifier
            .fillMaxWidth()
    )
}

