package com.example.jogodavelha.ui.screens.components

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jogodavelha.ui.theme.Background
import com.example.jogodavelha.ui.theme.TopBarColor
import com.example.jogodavelha.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(nome: String, action:() -> Unit) {
    Scaffold(
        backgroundColor = Background,
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = TopBarColor
                ),

                title = {
                    Text(fontSize = 20.sp ,text = "Bem Vindo $nome", color = White)
                },

                navigationIcon = {
                    IconButton(modifier = Modifier.width(26.dp), onClick = { action() }, icon = Icons.Filled.ArrowBack)
                },
            )
        }

    ) {
        it.calculateTopPadding()
    }

}

@Composable
@Preview
private fun TopBarPreview() {
    TopBar("Teste", action = { Log.i(TAG, "TopBarPreview: Teste") })
}