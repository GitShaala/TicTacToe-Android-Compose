package com.app.tictactoe

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.app.tictactoe.engine.PLAYER_O
import com.app.tictactoe.engine.PLAYER_X
import com.app.tictactoe.engine.computerPlay
import com.app.tictactoe.engine.gameResult
import com.app.tictactoe.engine.isBoardFull
import com.app.tictactoe.engine.isGameWon

class MainViewModel : ViewModel() {
    var singlePlayer by mutableStateOf(true)
        private set
    var isGameOver by mutableStateOf(false)
        private set
    private var currentPlayer = PLAYER_X

    var winner by mutableStateOf("")
        private set

    var board by mutableStateOf(arrayListOf<String>("", "", "", "", "", "", "", "", ""))
        private set

    fun play(move: Int) {
        if (isGameOver) return

        if (board[move] == "") {
            if (currentPlayer == PLAYER_X) {
                board = ArrayList(board.toMutableList().also {
                    it[move] = PLAYER_X
                })
                currentPlayer = PLAYER_O

                if (singlePlayer) {
                    if (!isBoardFull(board) && !isGameWon(board, PLAYER_X)) {
                        val nextMove = computerPlay(board)
                        board = ArrayList(board.toMutableList().also {
                            it[nextMove] = PLAYER_O
                        })
                        currentPlayer = PLAYER_X
                    }
                }
            } else {
                board = ArrayList(board.toMutableList().also {
                    it[move] = PLAYER_O
                })
                currentPlayer = PLAYER_X

                if (singlePlayer) {
                    if (!isBoardFull(board) && !isGameWon(board, PLAYER_O)) {
                        val nextMove = computerPlay(board)
                        board = ArrayList(board.toMutableList().also {
                            it[nextMove] = PLAYER_X
                        })
                        currentPlayer = PLAYER_O
                    }
                }
            }
        }

        isGameOver = isGameWon(board, PLAYER_X) || isGameWon(board, PLAYER_O)|| isBoardFull(board)
        winner = gameResult(board,singlePlayer)

        Log.i(TAG,"current board \n $board")

    }

    fun reset(){
       isGameOver = false
        board = arrayListOf("","","","","","","","","")
    }

    fun updatePlayerMode(singlePlayer:Boolean){
        this.singlePlayer = singlePlayer
        reset()
    }

    companion object {
        val TAG = MainViewModel::class.java.simpleName
    }
}