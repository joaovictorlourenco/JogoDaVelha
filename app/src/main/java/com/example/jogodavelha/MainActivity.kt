package com.example.jogodavelha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jogodavelha.ui.screens.DashboardScreen
import com.example.jogodavelha.ui.screens.LoginScreen
import com.example.jogodavelha.ui.theme.JogoDaVelhaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            JogoDaVelhaTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    NavHost(navController, "login", builder = {
                        composable("login") {
                            LoginScreen(navController)
                        }
                        composable("dashboard/{username}") { backStackEntry ->
                            val username = backStackEntry.arguments?.getString("username")
                            DashboardScreen(username)
                        }
                    })
                }
            }
        }
    }
}
