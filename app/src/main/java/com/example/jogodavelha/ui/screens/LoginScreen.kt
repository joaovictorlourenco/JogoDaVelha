package com.example.jogodavelha.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jogodavelha.ui.screens.components.Button
import com.example.jogodavelha.ui.theme.Background
import com.example.jogodavelha.ui.theme.Primary
import com.example.jogodavelha.ui.theme.White


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen( navController : NavController) {
    var username by remember { mutableStateOf("") }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ){
        Surface(color = Background, modifier = Modifier.fillMaxWidth()) {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Login",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Black,
                    color = Primary,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                
                Spacer(modifier = Modifier.height(30.dp))

                Column {
                    Text(
                        text = "Coloque seu nick para começar a jogar",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )


                    OutlinedTextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text(text = "Nome", color = Color.LightGray) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        textStyle = TextStyle(fontSize = 16.sp, color = Color.White),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = White,
                            unfocusedBorderColor = White,
                            cursorColor = White
                        ),
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(onClick = {
                    val route = "dashboard/$username"
                    navController.navigate(route)
                }, text = "Login")

            }
        }
    }

}