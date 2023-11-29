    package com.example.dragtest

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
    import androidx.compose.foundation.layout.offset
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.size
    import androidx.compose.foundation.layout.wrapContentSize
    import androidx.compose.material3.Button
    import androidx.compose.material3.ButtonDefaults
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
    import com.example.dragtest.ui.theme.DragTestTheme
    import kotlinx.coroutines.delay
    import kotlin.random.Random
    import kotlin.math.abs
    import kotlinx.coroutines.*
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.rememberCoroutineScope
    import androidx.compose.runtime.rememberUpdatedState



    private const val DELAY_BETWEEN_HIGHLIGHTS = 500L // Adjust this delay as needed

    private var job: Job? = null

    @Composable
    fun LevelSelectionScreen(startGame: (Int) -> Unit) {
        // UI for level selection, similar to your original buttons
        Column {
            Button(onClick = { startGame(1) }) {
                Text("Start Level 1")
            }

            Button(onClick = { startGame(2) }) {
                Text("Start Level 2")
            }
        }
    }

    @Composable
    fun GameScreen(level: Int) {
        when (level) {
            1 -> LevelOneContent()
            2 -> LevelTwoContent()
            // Add more levels as needed
        }
    }

    @Composable
    fun LevelOneContent() {
        Box(modifier = Modifier.fillMaxSize()) {
            val d = LocalDensity.current
            val maxX = LocalConfiguration.current.screenWidthDp.dp
            val maxY = LocalConfiguration.current.screenHeightDp.dp
            var offsetX1 by remember { mutableStateOf(50f) }
            var offsetY1 by remember { mutableStateOf(75f) }
            var offsetX2 by remember { mutableStateOf(1900f) }
            var offsetY2 by remember { mutableStateOf(900f) }
            var offsetX3 by remember { mutableStateOf(1300f) }
            var offsetY3 by remember { mutableStateOf(75f) }
            var offsetX4 by remember { mutableStateOf(50f) }
            var offsetY4 by remember { mutableStateOf(900f) }
            var offsetX5 by remember { mutableStateOf(700f) }
            var offsetY5 by remember { mutableStateOf(75f) }
            var offsetX6 by remember { mutableStateOf(1300f) }
            var offsetY6 by remember { mutableStateOf(900f) }
            var offsetX7 by remember { mutableStateOf(1900f) }
            var offsetY7 by remember { mutableStateOf(75f) }
            var offsetX8 by remember { mutableStateOf(650f) }
            var offsetY8 by remember { mutableStateOf(900f) }
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

            Image(
                painter = image1,
                contentDescription = null,
                modifier = Modifier
                    .offset((offsetX1 / d.density).dp, (offsetY1 / d.density).dp)
                    .size(300.dp)
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
                    .size(300.dp)
            )

            Image(
                painter = image3,
                contentDescription = null,
                modifier = Modifier
                    .offset((offsetX3 / d.density).dp, (offsetY3 / d.density).dp)
                    .size(300.dp)
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
                    .size(300.dp)
            )
            Image(
                painter = image5,
                contentDescription = null,
                modifier = Modifier
                    .offset((offsetX5 / d.density).dp, (offsetY5 / d.density).dp)
                    .size(300.dp)
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
                    .size(300.dp)
            )
            Image(
                painter = image7,
                contentDescription = null,
                modifier = Modifier
                    .offset((offsetX7 / d.density).dp, (offsetY7 / d.density).dp)
                    .size(300.dp)
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
                    .size(300.dp)
            )
            if (snapped1to2 && snapped3to4 && snapped5to6 && snapped7to8) {
                showWinMessage = true
                LaunchedEffect(Unit) {
                    delay(2000L) // Show message for 2 seconds
                    showWinMessage = false
                }
            }

            if (showWinMessage) {
                WinMessage()
            }
        }
    }

    @Composable
    fun WinMessage() {
        val backgroundPainter = painterResource(id = R.drawable.ganaste)
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
    @Composable
    fun LevelTwoContent() {
        Box(modifier = Modifier.fillMaxSize()) {
            val d = LocalDensity.current
            val maxX = LocalConfiguration.current.screenWidthDp.dp
            val maxY = LocalConfiguration.current.screenHeightDp.dp
            var offsetX1 by remember { mutableStateOf(50f) }
            var offsetY1 by remember { mutableStateOf(75f) }
            var offsetX2 by remember { mutableStateOf(835f) }
            var offsetY2 by remember { mutableStateOf(900f) }
            var offsetX3 by remember { mutableStateOf(400f) }
            var offsetY3 by remember { mutableStateOf(75f) }
            var offsetX4 by remember { mutableStateOf(50f) }
            var offsetY4 by remember { mutableStateOf(900f) }
            var offsetX5 by remember { mutableStateOf(835f) }
            var offsetY5 by remember { mutableStateOf(75f) }
            var offsetX6 by remember { mutableStateOf(430f) }
            var offsetY6 by remember { mutableStateOf(900f) }
            var offsetX7 by remember { mutableStateOf(1250f) }
            var offsetY7 by remember { mutableStateOf(75f) }
            var offsetX8 by remember { mutableStateOf(1250f) }
            var offsetY8 by remember { mutableStateOf(900f) }
            var offsetX9 by remember { mutableStateOf(1500f) }
            var offsetY9 by remember { mutableStateOf(25f) }
            var offsetX10 by remember { mutableStateOf(1950f) }
            var offsetY10 by remember { mutableStateOf(800f) }
            var offsetX11 by remember { mutableStateOf(1950f) }
            var offsetY11 by remember { mutableStateOf(75f) }
            var offsetX12 by remember { mutableStateOf(1550f) }
            var offsetY12 by remember { mutableStateOf(850f) }
            val image1: Painter = painterResource(id = R.drawable.cuadro_relleno)
            val image2: Painter = painterResource(id = R.drawable.cuadro_contorno)
            val image3: Painter = painterResource(id = R.drawable.circulo_relleno)
            val image4: Painter = painterResource(id = R.drawable.circulo_contorno)
            val image5: Painter = painterResource(id = R.drawable.pentagono_relleno)
            val image6: Painter = painterResource(id = R.drawable.pentagono_contorno)
            val image7: Painter = painterResource(id = R.drawable.tirangulo_relleno)
            val image8: Painter = painterResource(id = R.drawable.triangulo_contorno)
            val image9: Painter = painterResource(id = R.drawable.star_relleno)
            val image10: Painter = painterResource(id = R.drawable.estrella_contorno)
            val image11: Painter = painterResource(id = R.drawable.corazon_relleno)
            val image12: Painter = painterResource(id = R.drawable.corazon_contorno)
            var snapped1to2 by remember { mutableStateOf(false) }
            var snapped3to4 by remember { mutableStateOf(false) }
            var snapped5to6 by remember { mutableStateOf(false) }
            var snapped7to8 by remember { mutableStateOf(false) }
            var snapped9to10 by remember { mutableStateOf(false) }
            var snapped11to12 by remember { mutableStateOf(false) }
            var showWinMessage by remember { mutableStateOf(false) }
            val snapDistance = 50f

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
            )
            Image(
                painter = image9,
                contentDescription = null,
                modifier = Modifier
                    .offset((offsetX9 / d.density).dp, (offsetY9 / d.density).dp)
                    .size(290.dp)
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consumeAllChanges()
                            offsetX9 += dragAmount.x
                            offsetY9 += dragAmount.y
                            if (abs(offsetX9 - offsetX10) < snapDistance && abs(offsetY9 - offsetY10) < snapDistance) {
                                offsetX9 = offsetX10
                                offsetY9 = offsetY10
                                snapped9to10 = true
                            }
                        }
                    }
            )
            Image(
                painter = image10,
                contentDescription = null,
                modifier = Modifier
                    .offset((offsetX10 / d.density).dp, (offsetY10 / d.density).dp)
                    .size(290.dp)
            )
            Image(
                painter = image11,
                contentDescription = null,
                modifier = Modifier
                    .offset((offsetX11 / d.density).dp, (offsetY11 / d.density).dp)
                    .size(250.dp)
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consumeAllChanges()
                            offsetX11 += dragAmount.x
                            offsetY11 += dragAmount.y
                            if (abs(offsetX11 - offsetX12) < snapDistance && abs(offsetY11 - offsetY12) < snapDistance) {
                                offsetX11 = offsetX12
                                offsetY11 = offsetY12
                                snapped11to12 = true
                            }
                        }
                    }
            )
            Image(
                painter = image12,
                contentDescription = null,
                modifier = Modifier
                    .offset((offsetX12 / d.density).dp, (offsetY12 / d.density).dp)
                    .size(250.dp)
            )
            if (snapped1to2 && snapped3to4 && snapped5to6 && snapped7to8 && snapped9to10 && snapped11to12) {
                showWinMessage = true
                LaunchedEffect(Unit) {
                    delay(2000L) // Show message for 2 seconds
                    showWinMessage = false
                }
            }

            if (showWinMessage) {
                WinMessage()
            }
        }
    }


    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                var level by remember { mutableStateOf(0) }
                if (level == 0) {
                    LevelSelectionScreen { selectedLevel ->
                        level = selectedLevel
                    }
                } else {
                    GameScreen(level)
                }
            }
        }
    }

