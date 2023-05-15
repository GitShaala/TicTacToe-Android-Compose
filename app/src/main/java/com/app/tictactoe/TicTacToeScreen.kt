package com.app.tictactoe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.tictactoe.engine.PLAYER_X
import com.app.tictactoe.ui.theme.colorArray


@Composable
fun ResetButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        Modifier
            .offset(y = 50.dp)
            .padding(16.dp)
            .fillMaxWidth(0.7f)
            .height(50.dp)
    ) {
        Text(
            text = "Restart",
            style = TextStyle(textAlign = TextAlign.Center),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun TicTacToeButton(text: String, onClick: () -> Unit) {
    val textColor = if (text == PLAYER_X) Color.Yellow else Color.Red
    Box(modifier = Modifier.padding(8.dp)) {
        TextButton(
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.background(colorArray[2], shape = MaterialTheme.shapes.medium),
            enabled = text.isEmpty(),
            onClick = onClick
        ) {
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 35.sp,
                    textAlign = TextAlign.Center,
                    color = textColor,
                    fontWeight = FontWeight.ExtraBold
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .requiredSize(50.dp)
            )
        }
    }
}

@Composable
fun ButtonGrid(board: ArrayList<String>, onClick: (Int) -> Unit) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth(0.82f)
            .background(colorArray[1], shape = MaterialTheme.shapes.medium)
            .aspectRatio(1.0f)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            TicTacToeButton(board[0]) { onClick(0) }
            TicTacToeButton(board[1]) { onClick(1) }
            TicTacToeButton(board[2]) { onClick(2) }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            TicTacToeButton(board[3]) { onClick(3) }
            TicTacToeButton(board[4]) { onClick(4) }
            TicTacToeButton(board[5]) { onClick(5) }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            TicTacToeButton(board[6]) { onClick(6) }
            TicTacToeButton(board[7]) { onClick(7) }
            TicTacToeButton(board[8]) { onClick(8) }
        }
    }
}