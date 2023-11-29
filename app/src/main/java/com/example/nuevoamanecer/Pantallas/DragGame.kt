package com.example.nuevoamanecer.Pantallas

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.math.abs
import kotlinx.coroutines.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.nuevoamanecer.R


private const val DELAY_BETWEEN_HIGHLIGHTS = 500L // Adjust this delay as needed

private var job: Job? = null

@Composable
fun GameScreen(level: Int, navController: NavHostController) {
    when (level) {
        1 -> LevelOneContent(navController)
        2 -> SimonSaysGameContent()
        // Add more levels as needed
    }
}

@Composable
fun DragGameScreen(navController: NavHostController){
    var level by remember { mutableStateOf(0) }

    if (level == 0) {
        Box(
            modifier = with(Modifier) {
                fillMaxSize()
                    .background(Color(0xFF4BADE9))
                // Replace with your image id


            }) {


        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            FloatingActionButton(

                onClick = {
                    // navController.navigate("Juegos")
                },
                modifier = Modifier
                    .align(Alignment.End)

            ) {
                Icon(Icons.Filled.Close, "Back")
            }

            Row {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(20.dp),
                    onClick = { level = 1  },
                    modifier = Modifier
                        .height(300.dp)
                        .width(600.dp)
                        .padding(
                            vertical = 20.dp,
                            horizontal = 20.dp
                        )


                ) {
                    Text(text = "Subnivel 1", fontSize = 60.sp)
                }
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(20.dp),
                    onClick = { level = 2 },
                    modifier = Modifier
                        .height(300.dp)
                        .width(600.dp)
                        .padding(
                            vertical = 20.dp,
                            horizontal = 20.dp
                        )
                ) {
                    Text(text = "Subnivel  2", fontSize = 60.sp)
                }
            }
        }

    } else {
        GameScreen(level,navController)
    }
}



@Composable
fun ColorButton(color: Color, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .background(color)
            .clickable(onClick = onClick)
    )
}


@Composable
fun SimonSaysGameContent() {
    var playerTurn by remember { mutableStateOf(false) }
    val colorList = listOf(Color.Blue, Color.Red, Color.Green, Color.Yellow)
    val simonSequence = remember { mutableListOf<Color>() }

    // States to keep track of button colors
    var blueButtonColor by remember { mutableStateOf(Color.Blue) }
    var redButtonColor by remember { mutableStateOf(Color.Red) }
    var greenButtonColor by remember { mutableStateOf(Color.Green) }
    var yellowButtonColor by remember { mutableStateOf(Color.Yellow) }

    var sequenceIndex by remember { mutableStateOf(0) }
    var userSequenceIndex by remember { mutableStateOf(0) }

    fun generateSimonSequence() {
        val random = Random
        for (i in 0 until sequenceIndex + 1) {
            val randomIndex = random.nextInt(4)
            simonSequence.add(colorList[randomIndex])
        }
    }

    fun showSimonSequence() {
        val delayMillis: Long = 1000 // Adjust the delay between colors
        val sequenceHandler = Handler(Looper.getMainLooper())

        fun resetColor(color: Color) {
            when (color) {
                Color.Blue -> blueButtonColor = Color.Blue
                Color.Red -> redButtonColor = Color.Red
                Color.Green -> greenButtonColor = Color.Green
                Color.Yellow -> yellowButtonColor = Color.Yellow
            }
        }

        fun highlightColor(color: Color) {
            when (color) {
                Color.Blue -> blueButtonColor = Color.LightGray
                Color.Red -> redButtonColor = Color.LightGray
                Color.Green -> greenButtonColor = Color.LightGray
                Color.Yellow -> yellowButtonColor = Color.LightGray
            }
        }

        sequenceHandler.postDelayed(object : Runnable {
            var currentColorIndex = 0
            var repeatCount = 0
            var userIndex = 0
            override fun run() {
                if (currentColorIndex < simonSequence.size) {
                    val color = simonSequence[currentColorIndex]
                    highlightColor(color)
                    sequenceHandler.postDelayed({
                        resetColor(color)
                        repeatCount++
                        if (repeatCount == userIndex + 1) {
                            repeatCount = 0
                            currentColorIndex++
                        }
                        if (currentColorIndex < simonSequence.size) {
                            showSimonSequence()
                        } else {
                            playerTurn = true
                            sequenceIndex = 0
                        }
                    }, delayMillis)
                }
            }
        }, delayMillis)
    }


    // Handle user input
    fun handleUserInput(color: Color) {
        if (playerTurn) {
            val expectedColor = simonSequence[userSequenceIndex]
            if (color == expectedColor) {
                userSequenceIndex++
                if (userSequenceIndex == simonSequence.size) {
                    playerTurn = false
                    userSequenceIndex = 0
                    sequenceIndex = 0 // Reset sequence for the next round
                    simonSequence.clear()
                    generateSimonSequence() // Generate a new sequence for the next round
                    showSimonSequence() // Show the new sequence
                }
            } else {
                // Handle wrong input (e.g., game over or reset)
                // For now, resetting the game
                playerTurn = false
                userSequenceIndex = 0
                sequenceIndex = 0
                simonSequence.clear()
                generateSimonSequence() // Generate a new sequence for the next round
                showSimonSequence() // Show the new sequence
            }
        }
    }

    // UI elements using the button colors...
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                generateSimonSequence()
                showSimonSequence()
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Start Simon Says Game")
        }

        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Replace these placeholders with your ColorButton components
            ColorButton(color = blueButtonColor) {
                handleUserInput(Color.Blue)
            }
            ColorButton(color = redButtonColor) {
                handleUserInput(Color.Red)
            }
            ColorButton(color = greenButtonColor) {
                handleUserInput(Color.Green)
            }
            ColorButton(color = yellowButtonColor) {
                handleUserInput(Color.Yellow)
            }
        }
    }
}



@Composable
fun SimonButton(color: Color, onClick: () -> Unit, isHighlighted: Boolean) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .size(100.dp)
            .padding(8.dp),
        colors = ButtonDefaults.buttonColors(
            if (isHighlighted) color.copy(alpha = 0.5f) else color
        )
    ) {}
}



private fun addRandomColorToSequence(simonSequence: MutableState<List<Int>>) {
    val randomColorIndex = (0..3).random()
    simonSequence.value = simonSequence.value + randomColorIndex
}



@Composable
fun LevelOneContent(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        val d = LocalDensity.current
        val maxX = LocalConfiguration.current.screenWidthDp.dp
        val maxY = LocalConfiguration.current.screenHeightDp.dp
        var offsetX1 by remember { mutableStateOf(Random.nextFloat() * maxX.value) }
        var offsetY1 by remember { mutableStateOf(Random.nextFloat() * maxY.value) }
        var offsetX2 by remember { mutableStateOf(Random.nextFloat() * maxX.value) }
        var offsetY2 by remember { mutableStateOf(Random.nextFloat() * maxY.value) }
        var offsetX3 by remember { mutableStateOf(Random.nextFloat() * maxX.value) }
        var offsetY3 by remember { mutableStateOf(Random.nextFloat() * maxY.value) }
        var offsetX4 by remember { mutableStateOf(Random.nextFloat() * maxX.value) }
        var offsetY4 by remember { mutableStateOf(Random.nextFloat() * maxY.value) }
        var offsetX5 by remember { mutableStateOf(Random.nextFloat() * maxX.value) }
        var offsetY5 by remember { mutableStateOf(Random.nextFloat() * maxY.value) }
        var offsetX6 by remember { mutableStateOf(Random.nextFloat() * maxX.value) }
        var offsetY6 by remember { mutableStateOf(Random.nextFloat() * maxY.value) }
        var offsetX7 by remember { mutableStateOf(Random.nextFloat() * maxX.value) }
        var offsetY7 by remember { mutableStateOf(Random.nextFloat() * maxY.value) }
        var offsetX8 by remember { mutableStateOf(Random.nextFloat() * maxX.value) }
        var offsetY8 by remember { mutableStateOf(Random.nextFloat() * maxY.value) }
        val image1: Painter = painterResource(id = R.drawable.cuadro_relleno)
        val image2: Painter = painterResource(id = R.drawable.cuadro_contorno)
        val image3: Painter = painterResource(id = R.drawable.circulo_relleno)
        val image4: Painter = painterResource(id = R.drawable.circulo_contorno)
        val image5: Painter = painterResource(id = R.drawable.pentagono_relleno)
        val image6: Painter = painterResource(id = R.drawable.pentagono_contorno)
        val image7: Painter = painterResource(id = R.drawable.tirangulo_relleno)
        val image8: Painter = painterResource(id = R.drawable.triangulo_contorno)
        var snapped1to2 by remember { mutableStateOf(false) }
        var snapped3to4 by remember { mutableStateOf(false) }
        var snapped5to6 by remember { mutableStateOf(false) }
        var snapped7to8 by remember { mutableStateOf(false) }
        var showWinMessage by remember { mutableStateOf(false) }
        val snapDistance = 50f

        Box(
            modifier = with (Modifier){
                fillMaxWidth()
                    .paint(
                        // Replace with your image id
                        painterResource(id = R.drawable.blackboard_background),
                        contentScale = ContentScale.Crop)

            })



        Image(
            painter = image1,
            contentDescription = null,
            modifier = Modifier
                .offset((offsetX1 / d.density).dp, (offsetY1 / d.density).dp)
                .size(200.dp)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consumeAllChanges()
                        offsetX1 += dragAmount.x
                        offsetY1 += dragAmount.y
                        if (abs(offsetX1 - offsetX2) < snapDistance && abs(offsetY1 - offsetY2) < snapDistance) {
                            offsetX1 = offsetX2
                            offsetY1 = offsetY2
                            snapped1to2 = true
                        }
                    }
                }
        )

        Image(
            painter = image2,
            contentDescription = null,
            modifier = Modifier
                .offset((offsetX2 / d.density).dp, (offsetY2 / d.density).dp)
                .size(200.dp)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consumeAllChanges()
                        offsetX2 += dragAmount.x
                        offsetY2 += dragAmount.y
                        if (abs(offsetX2 - offsetX1) < snapDistance && abs(offsetY2 - offsetY1) < snapDistance) {
                            offsetX2 = offsetX1
                            offsetY2 = offsetY1
                            snapped1to2 = true
                        }
                    }
                }
        )

        Image(
            painter = image3,
            contentDescription = null,
            modifier = Modifier
                .offset((offsetX3 / d.density).dp, (offsetY3 / d.density).dp)
                .size(200.dp)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consumeAllChanges()
                        offsetX3 += dragAmount.x
                        offsetY3 += dragAmount.y
                        if (abs(offsetX3 - offsetX4) < snapDistance && abs(offsetY3 - offsetY4) < snapDistance) {
                            offsetX3 = offsetX4
                            offsetY3 = offsetY4
                            snapped3to4 = true
                        }
                    }
                }
        )

        Image(
            painter = image4,
            contentDescription = null,
            modifier = Modifier
                .offset((offsetX4 / d.density).dp, (offsetY4 / d.density).dp)
                .size(200.dp)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consumeAllChanges()
                        offsetX4 += dragAmount.x
                        offsetY4 += dragAmount.y
                        if (abs(offsetX4 - offsetX3) < snapDistance && abs(offsetY4 - offsetY3) < snapDistance) {
                            offsetX4 = offsetX3
                            offsetY4 = offsetY3
                            snapped3to4 = true
                        }
                    }
                }
        )
        Image(
            painter = image5,
            contentDescription = null,
            modifier = Modifier
                .offset((offsetX5 / d.density).dp, (offsetY5 / d.density).dp)
                .size(200.dp)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consumeAllChanges()
                        offsetX5 += dragAmount.x
                        offsetY5 += dragAmount.y
                        if (abs(offsetX5 - offsetX6) < snapDistance && abs(offsetY5 - offsetY6) < snapDistance) {
                            offsetX5 = offsetX6
                            offsetY5 = offsetY6
                            snapped5to6 = true
                        }
                    }
                }
        )
        Image(
            painter = image6,
            contentDescription = null,
            modifier = Modifier
                .offset((offsetX6 / d.density).dp, (offsetY6 / d.density).dp)
                .size(200.dp)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consumeAllChanges()
                        offsetX6 += dragAmount.x
                        offsetY6 += dragAmount.y
                        if (abs(offsetX6 - offsetX5) < snapDistance && abs(offsetY6 - offsetY5) < snapDistance) {
                            offsetX6 = offsetX5
                            offsetY6 = offsetY5
                            snapped5to6 = true
                        }
                    }
                }
        )
        Image(
            painter = image7,
            contentDescription = null,
            modifier = Modifier
                .offset((offsetX7 / d.density).dp, (offsetY7 / d.density).dp)
                .size(200.dp)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consumeAllChanges()
                        offsetX7 += dragAmount.x
                        offsetY7 += dragAmount.y
                        if (abs(offsetX7 - offsetX8) < snapDistance && abs(offsetY7 - offsetY8) < snapDistance) {
                            offsetX7 = offsetX8
                            offsetY7 = offsetY8
                            snapped7to8 = true
                        }
                    }
                }
        )
        Image(
            painter = image8,
            contentDescription = null,
            modifier = Modifier
                .offset((offsetX8 / d.density).dp, (offsetY8 / d.density).dp)
                .size(200.dp)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consumeAllChanges()
                        offsetX8 += dragAmount.x
                        offsetY8 += dragAmount.y
                        if (abs(offsetX8 - offsetX7) < snapDistance && abs(offsetY8 - offsetY7) < snapDistance) {
                            offsetX8 = offsetX7
                            offsetY8 = offsetY7
                            snapped7to8 = true
                        }
                    }
                }
        )
        if (snapped1to2 && snapped3to4 && snapped5to6 && snapped7to8) {
            showWinMessage = true
            LaunchedEffect(Unit) {
                delay(2000L) // Show message for 2 seconds
                showWinMessage = false
            }
        }

        if (showWinMessage) {
            WinMessage(navController)
        }
    }
}

@Composable
fun WinMessage(navController: NavHostController) {
    val backgroundPainter = painterResource(id = R.drawable.ganaste)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        FloatingActionButton(
            shape = RectangleShape,
            onClick = {
                navController.navigate("Juegos")
            },
            modifier = Modifier
                .align(Alignment.Start)
        ) {
            Icon(Icons.Filled.ArrowBack, "Regresar")
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = backgroundPainter,
                contentDescription = null,
                modifier = Modifier
                    .size(600.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}



