package com.example.dragtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            fun adjustPosition(offsetX: Float, offsetY: Float, targetX: Float, targetY: Float, snapDistance: Float): Pair<Float, Float> {
                var newX = offsetX
                var newY = offsetY
                if (abs(offsetX - targetX) < snapDistance && abs(offsetY - targetY) < snapDistance) {
                    newX = targetX
                    newY = targetY
                }
                return Pair(newX, newY)
            }
            DragTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val backgroundPainter = painterResource(id = R.drawable.hoja_background)

                    Image(
                        painter = backgroundPainter,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White),
                        contentScale = ContentScale.Crop
                    )
                    Box() {
                        val d = LocalDensity.current
                        val maxX = LocalConfiguration.current.screenWidthDp.dp
                        val maxY = LocalConfiguration.current.screenHeightDp.dp
                        var offsetX0 by remember { mutableStateOf(1200f) }
                        var offsetY0 by remember { mutableStateOf(265f) }
                        var offsetX1 by remember { mutableStateOf(1300f) }
                        var offsetY1 by remember { mutableStateOf(200f) }
                        var offsetX2 by remember { mutableStateOf(1325f) }
                        var offsetY2 by remember { mutableStateOf(226f) }
                        var offsetX3 by remember { mutableStateOf(100f) }
                        var offsetY3 by remember { mutableStateOf(200f) }
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
                        val frost: Painter = painterResource(id = R.drawable.frost)
                        val basecup: Painter = painterResource(id = R.drawable.basecup)
                        val botonBlanco: Painter = painterResource(id = R.drawable.blanco)
                        val botonAzul: Painter = painterResource(id = R.drawable.azul)
                        val botonRosa: Painter = painterResource(id = R.drawable.rosa)
                        val botonMorado: Painter = painterResource(id = R.drawable.morado)
                        val blanco: Painter = painterResource(id = R.drawable.blanco)
                        val azul: Painter = painterResource(id = R.drawable.azul)
                        val rosa: Painter = painterResource(id = R.drawable.rosa)
                        val mora: Painter = painterResource(id = R.drawable.morado)
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

                        var visBlan by remember { mutableStateOf(false) }
                        var visAzul by remember { mutableStateOf(false) }
                        var visRosa by remember { mutableStateOf(false) }
                        var visMora by remember { mutableStateOf(false) }

                        Image(
                            painter = frost,
                            contentDescription = null,
                            modifier = Modifier
                                .offset((offsetX1 / d.density).dp, (offsetY1 / d.density).dp)
                                .size(455.dp)

                        )

                        Image(
                            painter = basecup,
                            contentDescription = null,
                            modifier = Modifier
                                .offset((offsetX0 / d.density).dp, (offsetY0 / d.density).dp)
                                .size(555.dp)
                        )

                        Image(
                            painter = botonBlanco,
                            contentDescription = null,
                            modifier = Modifier
                                .offset((offsetX3 / d.density).dp, (offsetY3 / d.density).dp)
                                .size(100.dp)
                                .clickable {
                                    visBlan = true
                                    visAzul = false
                                    visRosa = false
                                    visMora = false
                                }

                        )

                        Image(
                            painter = blanco,
                            contentDescription = null,
                            modifier = Modifier
                                .offset(if (visBlan) (offsetX2/d.density).dp else (-1000).dp, (offsetY2/d.density).dp)
                                .size(430.dp)
                        )

                        Image(
                            painter = botonAzul,
                            contentDescription = null,
                            modifier = Modifier
                                .offset(((offsetX3 / d.density)+130).dp, (offsetY3 / d.density).dp)
                                .size(100.dp)
                                .clickable {
                                    visBlan = false
                                    visAzul = true
                                    visRosa = false
                                    visMora = false
                                }

                        )

                        Image(
                            painter = azul,
                            contentDescription = null,
                            modifier = Modifier
                                .offset(if (visAzul) (offsetX2/d.density).dp else (-1000).dp, (offsetY2/d.density).dp)
                                .size(430.dp)
                        )

                        Image(
                            painter = botonRosa,
                            contentDescription = null,
                            modifier = Modifier
                                .offset(((offsetX3 / d.density)+260).dp, (offsetY3 / d.density).dp)
                                .size(100.dp)
                                .clickable {
                                    visBlan = false
                                    visAzul = false
                                    visRosa = true
                                    visMora = false
                                }

                        )

                        Image(
                            painter = rosa,
                            contentDescription = null,
                            modifier = Modifier
                                .offset(if (visRosa) (offsetX2/d.density).dp else (-1000).dp, (offsetY2/d.density).dp)
                                .size(430.dp)
                        )

                        Image(
                            painter = botonMorado,
                            contentDescription = null,
                            modifier = Modifier
                                .offset(((offsetX3 / d.density)+390).dp, (offsetY3 / d.density).dp)
                                .size(100.dp)
                                .clickable {
                                    visBlan = false
                                    visAzul = false
                                    visRosa = false
                                    visMora = true
                                }

                        )

                        Image(
                            painter = mora,
                            contentDescription = null,
                            modifier = Modifier
                                .offset(if (visMora) (offsetX2/d.density).dp else (-1000).dp, (offsetY2/d.density).dp)
                                .size(430.dp)
                        )

                        Image(
                            painter = image4,
                            contentDescription = null,
                            modifier = Modifier
                                .offset((offsetX4 / d.density).dp, (offsetY4 / d.density).dp)
                                .size(100.dp)
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
                                .size(100.dp)
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
                                .size(100.dp)
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
                                .size(100.dp)
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
                                .size(100.dp)
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
                            WinMessage()
                        }
                    }
                }
            }
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

