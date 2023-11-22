package com.example.jogodavelha.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jogodavelha.R
import com.example.jogodavelha.ui.screens.components.Button
import com.example.jogodavelha.ui.screens.components.IconButton
import com.example.jogodavelha.ui.theme.Background
import com.example.jogodavelha.ui.theme.White


@Composable
fun DashboardScreen(username: String?, navController: NavController) {
    Box {
        Surface(color = Background, modifier = Modifier.fillMaxSize()) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(start = 16.dp, end = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .padding(end = 16.dp),
                        onClick = { navController.popBackStack() },
                        icon = Icons.Filled.ArrowBack
                    )

                    Image(
                        painter = painterResource(R.drawable.icon),
                        contentDescription = "Icone de usuario",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)

                    )
                    Text(
                        text = "Bem Vindo $username",
                        modifier = Modifier.padding(start = 16.dp),
                        color = White
                    )
                }
                Spacer(modifier = Modifier.weight(0.5f))
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                        Button(
                            onClick = {
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