package com.app.tictactoe

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.tictactoe.ui.theme.TicTacToeTheme
import com.app.tictactoe.ui.theme.gradiantColorArray

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeTheme {
                Scaffold() {
                    Surface() {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize().background(Brush.verticalGradient(gradiantColorArray, startY = 0.0f, endY = Float.POSITIVE_INFINITY, tileMode = TileMode.Repeated))
                        ) {
                            ButtonGrid(board = viewModel.board, onClick = viewModel::play)
                            if (viewModel.isGameOver) {
                                Box(modifier = Modifier.padding(top = 30.dp)) {
                                    Text(text = "Game Over : ${viewModel.winner}", fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold)
                                }
                            }

                            ResetButton(viewModel::reset)
                        }
                    }
                }
            }
            // A surface container using the 'background' color from the theme
        }
    }

//    @Composable
//    @Preview()
//    fun DefaultPreview() {
//        TicTacToeTheme() {
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceAround,
//                modifier = Modifier.fillMaxHeight()
//            ) {
//                ButtonGrid(
//                    board = arrayListOf<String>(
//                        "X",
//                        "O",
//                        "X",
//                        "O",
//                        "O",
//                        "X",
//                        "X",
//                        "X",
//                        "O"
//                    )
//                ) {}
//                ResetButton() {}
//            }
//        }
//    }
}
