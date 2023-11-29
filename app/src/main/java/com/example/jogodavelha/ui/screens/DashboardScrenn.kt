package com.example.jogodavelha.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jogodavelha.ui.screens.components.Button
import com.example.jogodavelha.ui.screens.components.TopBar
import com.example.jogodavelha.ui.theme.Background


@Composable
fun DashboardScreen(username: String?, navController: NavController) {
    Box {
        Surface(color = Background, modifier = Modifier.fillMaxSize()) {
            TopBar(nome = username ?: "", action = { navController.popBackStack() })
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.weight(0.5f))
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                        Button(
                            onClick = {
                                navController.navigate("telaDeJogo")
                            }, text = "1v1", modifier = Modifier
                                .width(150.dp)
                                .height(50.dp)
                        )
                        Button(
                            onClick = { /*TODO*/ }, text = "vs IA", modifier = Modifier
                                .width(150.dp)
                                .height(50.dp)
                        )
                    }
                }
            }
        }
    }
}