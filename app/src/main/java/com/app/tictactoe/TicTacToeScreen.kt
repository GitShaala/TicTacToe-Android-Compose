package com.app.tictactoe

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.tictactoe.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicTacToeAppBar(singlePlayer: Boolean, onCheckChanged: (Boolean) -> Unit) {
    val checkedState = remember {
        mutableStateOf(singlePlayer)
    }
    TopAppBar(title = {
        Text(text = "Tic Tac Toe", color = Color.White)
    }, actions = {
        Row(modifier = Modifier.padding(16.dp)) {
            Text(text = if (checkedState.value) "Single Player" else "Multi Player")
            Spacer(modifier = Modifier.width(16.dp))
            Switch(checked = checkedState.value, onCheckedChange = {
                checkedState.value = it
                onCheckChanged(it)
            })
        }
    })
}

    @Composable
    fun ResetButton(onClick: () -> Unit) {
        Button(
            onClick = onClick,
            Modifier
                .offset(y = 50.dp)
                .padding(16.dp)
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
        Box(modifier = Modifier.padding(8.dp)) {
            TextButton(
                shape = MaterialTheme.shapes.medium,
                border = BorderStroke(1.dp, Purple40),
                enabled = text.isEmpty(),
                onClick = onClick
            ) {
                Text(
                    text = text,
                    style = TextStyle(fontSize = 35.sp, textAlign = TextAlign.Center),
                    modifier = Modifier
                        .padding(16.dp)
                        .requiredSize(40.dp).fillMaxHeight()
                )
            }
        }
    }

    @Composable
    fun ButtonGrid(board: ArrayList<String>, onClick: (Int) -> Unit) {

        Column(verticalArrangement = Arrangement.SpaceEvenly) {
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
              TicTacToeButton(board[0]){onClick(0)}
                TicTacToeButton(board[1]){onClick(1)}
                TicTacToeButton(board[2]){onClick(2)}

            }
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                TicTacToeButton(board[3]){onClick(3)}
                TicTacToeButton(board[4]){onClick(4)}
                TicTacToeButton(board[5]){onClick(5)}

            }
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                TicTacToeButton(board[6]){onClick(6)}
                TicTacToeButton(board[7]){onClick(7)}
                TicTacToeButton(board[8]){onClick(8)}

            }
        }
    }