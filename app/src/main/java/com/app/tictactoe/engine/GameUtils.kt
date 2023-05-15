package com.app.tictactoe.engine

import kotlin.random.Random

const val PLAYER_X = "X"
const val PLAYER_O = "O" //Computer or Player 2

/**
 * determine if board is full
 **/

fun isBoardFull(board: ArrayList<String>): Boolean {
    for (item in board) {
        if (item != PLAYER_X && item != PLAYER_O) return false
    }
    return true
}

/**
 * make a copy of the board
 **/

fun copyBoard(board: ArrayList<String>): ArrayList<String> {
    return ArrayList(board)
}

/** choose a random move
 * if board has space to move
 **/

fun chooseRandomMove(board: ArrayList<String>, moves: ArrayList<Int>): Int {
    val possibleMoves = ArrayList<Int>()
    for (i in moves) {
        if (board[i] == "") possibleMoves.add(i)
    }

    return if (possibleMoves.isEmpty()) {
        -1
    } else {
        val index = Random.nextInt(possibleMoves.size)
        possibleMoves[index]
    }
}

/**
 * play from computer side
 **/

fun computerPlay(board: ArrayList<String>): Int {
    for (i in 0 until board.size) {
        val copy = copyBoard(board)
        if (copy[i] == "") {
            copy[i] = PLAYER_O
        }

        //check for win
        if (isGameWon(copy, PLAYER_O)) return i
    }

    //check if player can move in next move

    for (i in 0 until board.size) {
        val copy = copyBoard(board)
        if (copy[i] == "") {
            copy[i] = PLAYER_X
        }

        //check if player won
        if (isGameWon(copy, PLAYER_X)) return i
    }

    //get random moves

    /**try corner positions**/
    val cornerMove = chooseRandomMove(board, arrayListOf(0, 2, 6, 8))
    if (cornerMove != -1) return cornerMove

    /**center**/
    if (board[4] == "") return 4

    /**try side positions**/
    val centerPosition = chooseRandomMove(board, arrayListOf(1, 3, 4, 5, 7))
    if (centerPosition != -1) return centerPosition

    return -1
}

fun isGameWon(board: ArrayList<String>, player: String): Boolean {

    //rows
    if (board[0] == player && board[1] == player && board[2] == player) return true
    if (board[3] == player && board[4] == player && board[5] == player) return true
    if (board[6] == player && board[7] == player && board[8] == player) return true

    //columns
    if (board[0] == player && board[3] == player && board[6] == player) return true
    if (board[1] == player && board[4] == player && board[7] == player) return true
    if (board[2] == player && board[5] == player && board[8] == player) return true

    //diagonal
    if (board[0] == player && board[4] == player && board[8] == player) return true
    if (board[2] == player && board[4] == player && board[6] == player) return true

    return false
}

fun gameResult(board: ArrayList<String>, singlePlayer: Boolean): String {
    return if (isGameWon(board, PLAYER_X)) "${if (singlePlayer) "YOU" else "PLAYER X"} won"
    else if (isGameWon(board, PLAYER_O)) "${if (singlePlayer) "COMPUTER" else "PLAYER O"} won"
    else "its a Tie"
}