package com.example.jogodavelha.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.jogodavelha.R


@Composable
fun DashboardScreen( username: String? ) {
    Column {
        Row {
            Icon(painter = painterResource(R.drawable.icon), contentDescription = "Icone de usuario" )
            Text(text = "Bem Vindo $username")
        }
    }
}