package com.example.jogodavelha.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.*
import kotlin.random.Random
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import com.example.jogodavelha.ui.theme.Background
import com.example.jogodavelha.ui.theme.Primary
import com.example.jogodavelha.ui.theme.White
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class GameViewModel : ViewModel(){
    var gameResult by mutableStateOf("")

}


@Composable
fun TelaDeJogoIa(navController: NavController, viewModel: GameViewModel = viewModel()) {
    var currentPlayer by remember { mutableStateOf("X") }
    var showDialog by remember { mutableStateOf(false) }
    val board = remember {
        mutableStateListOf(
            mutableStateListOf("", "", ""),
            mutableStateListOf("", "", ""),
            mutableStateListOf("", "", "")
        )
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Background)
            .fillMaxSize()
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.background(White)
            ) {
                for (i in 0 until 3) {
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        for (j in 0 until 3) {
                            Button(
                                onClick = {
                                    if (board[i][j].isEmpty()) {
                                        board[i][j] = currentPlayer
                                        currentPlayer = if (currentPlayer == "X") "O" else "X"
                                        if(currentPlayer == "O"){
                                            var x = Random.nextInt(0,3)
                                            var y = Random.nextInt(0,3)
                                            while(board[x][y].isNotEmpty()){
                                                x = Random.nextInt(0,3)
                                                y = Random.nextInt(0,3)
                                            }
                                            board[x][y] = currentPlayer
                                            currentPlayer = if (currentPlayer == "X") "O" else "X"
                                        }
                                        viewModel.gameResult = checkWinnerAndResetGame(board)
                                        if (viewModel.gameResult != "Jogo ainda em andamento") {
                                            showDialog = true
                                        }

                                    }
                                },
                                modifier = Modifier
                                    .width(80.dp)
                                    .height(80.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Background),
                                shape = RoundedCornerShape(0.dp)
                            ) {
                                Text(text = board[i][j], fontSize = 40.sp, color = White)
                            }
                        }
                    }
                }
                if (showDialog) {
                    GameResultDialog(
                        result = viewModel.gameResult,
                        onDismiss = {
                            showDialog = false
                            navController.popBackStack()
                        }
                    )
                }
            }

//            Button(
//                onClick = {
//                    currentPlayer = "X"
//                    for (i in 0 until 3) {
//                        for (j in 0 until 3) {
//                            board[i][j] = ""
//                        }
//                    }
//                },
//                modifier = Modifier
//                    .width(120.dp)
//                    .height(60.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = Primary),
//                shape = RoundedCornerShape(15.dp)
//            ) {
//                Row {
//                    Text(text = "Resetar", fontSize = 15.sp, color = White);
//                    Icon(
//                        imageVector = Icons.Default.Refresh,
//                        contentDescription = null,
//                        tint = White
//                    )
//                }
//            }
        }
    }
}
@Composable

fun GameResultDialog(result: String, onDismiss: () -> Unit) {
    val context = LocalContext.current
    AlertDialog(
        onDismissRequest = { onDismiss() }, title = {
            Text(text = "Resultado do Jogo:", fontSize = 20.sp, color = Color.White)
        } , text = {
            Text(text = result, fontSize = 20.sp, color = Color.White)
        },confirmButton = { /*TODO*/ }
    )
}


fun List<String>.allEqual(): Boolean {
    if (this.isEmpty()) return false
    val first = this[0]
    return all { it == first && it.isNotEmpty() }
}

fun checkWinnerAndResetGame(board: List<List<String>>): String {
    // Verificar linhas e colunas
    for (i in 0 until 3) {
        if (board[i].allEqual() && board[i][0].isNotEmpty()) {
            return "${board[i][0]} ganhou!"
        }
        if (board.all { it[i] == board[0][i] && it[i].isNotEmpty() }) {
            return "${board[0][i]} ganhou!"
        }
    }

    // Verificar diagonais
    val diagonal1 = List(3) { i -> board[i][i] }
    val diagonal2 = List(3) { i -> board[i][2 - i] }

    if (diagonal1.allEqual() && diagonal1[0].isNotEmpty()) {
        return "${diagonal1[0]} ganhou!"
    } else if (diagonal2.allEqual() && diagonal2[0].isNotEmpty()) {
        return "${diagonal2[0]} ganhou!"
    }

    // Verificar empate
    if (board.all { row -> row.all { it.isNotEmpty() } }) {
        return "Empate!"
    }

    // Nenhum vencedor ou empate
    return "Jogo ainda em andamento"
}

//fun checkForWinner(board: List<List<String>>): String {
//    // Verificar linhas
//    for (row in board) {
//        if (row.allEqual()) {
//            return row[0]
//        }
//    }
//
//    // Verificar colunas
//    for (col in 0 until 3) {
//        val columnValues = List(3) { row -> board[row][col] }
//        if (columnValues.allEqual()) {
//            return columnValues[0]
//        }
//    }
//
//    // Verificar diagonais
//    val diagonal1 = List(3) { i -> board[i][i] }
//    val diagonal2 = List(3) { i -> board[i][2 - i] }
//
//    if (diagonal1.allEqual() && diagonal1[0].isNotEmpty()) {
//        return diagonal1[0]
//    } else if (diagonal2.allEqual() && diagonal2[0].isNotEmpty()) {
//        return diagonal2[0]
//    }
//
//
//    // Verificar empate
//    if (board.all { row -> row.all { it.isNotEmpty() } }) {
//        return "Empate"
//    }
//
//    // Nenhum vencedor
//    return ""
//}

