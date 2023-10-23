package com.example.jogodavelha.ui.screens.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Button(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Button(onClick = onClick, modifier = Modifier.fillMaxWidth().padding(20.dp), colors = ButtonDefaults.buttonColors(containerColor = com.example.jogodavelha.ui.theme.Primary )){
        Text(text = text, fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
    }
}



@Composable
@Preview
private fun ButtonPreview(){
    Button(
        onClick = {},
        text = "Login"
    )
}