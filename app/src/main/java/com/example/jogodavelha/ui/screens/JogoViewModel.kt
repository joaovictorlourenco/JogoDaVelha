package com.example.jogodavelha.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class JogoViewModel {
    var currentPlayer by mutableStateOf("X")
        private set

    var winner by mutableStateOf<String?>(null)
        private set

    val board = mutableStateListOf(
        mutableStateListOf("", "", ""),
        mutableStateListOf("", "", ""),
        mutableStateListOf("", "", "")
    )

    fun onCellClick(row: Int, col: Int) {
        if (board[row][col].isEmpty() && winner == null) {
            board[row][col] = currentPlayer
            currentPlayer = if (currentPlayer == "X") "O" else "X"
            checkForWinner()
        }
    }

    private fun List<String>.allEqual(): Boolean {
        return this.all { it.isNotEmpty() && it == this[0] }
    }

    private fun checkForWinner() {
        // Lógica para verificar o vencedor
        // ...
    }

    fun resetGame() {
        currentPlayer = "X"
        winner = null
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                board[i][j] = ""
            }
        }
    }
}