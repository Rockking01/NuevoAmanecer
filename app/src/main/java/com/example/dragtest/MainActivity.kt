package com.example.dragtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dragtest.ui.theme.DragTestTheme
import kotlin.random.Random
import kotlin.math.abs



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DragTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                    ){
                        val d = LocalDensity.current
                        val maxX = LocalConfiguration.current.screenWidthDp.dp
                        val maxY = LocalConfiguration.current.screenHeightDp.dp
                        var offsetX1 by remember { mutableStateOf(Random.nextFloat() * maxX.value) }
                        var offsetY1 by remember { mutableStateOf(Random.nextFloat() * maxY.value) }
                        var offsetX2 by remember { mutableStateOf(Random.nextFloat() * maxX.value) }
                        var offsetY2 by remember { mutableStateOf(Random.nextFloat() * maxY.value) }
                        val image1: Painter = painterResource(id = R.drawable.relleno_cuadro)
                        val image2: Painter = painterResource(id = R.drawable.vacio_cuadro)
                        val snapDistance = 50f // The distance in pixels at which the images will snap into each other
                        Image(
                            painter = image1,
                            contentDescription = null,
                            modifier = Modifier
                                .offset((offsetX1 / d.density).dp, (offsetY1 / d.density).dp)
                                .size(100.dp)
                                .pointerInput(Unit) {
                                    detectDragGestures { change, dragAmount ->
                                        print(dragAmount)
                                        change.consumeAllChanges()
                                        offsetX1 += dragAmount.x
                                        offsetY1 += dragAmount.y
                                        if (abs(offsetX1 - offsetX2) < snapDistance && abs(offsetY1 - offsetY2) < snapDistance) {
                                            offsetX1 = offsetX2
                                            offsetY1 = offsetY2
                                        }
                                    }
                                }
                        )
                        Image(
                            painter = image2,
                            contentDescription = null,
                            modifier = Modifier
                                .offset((offsetX2 / d.density).dp, (offsetY2 / d.density).dp)
                                .size(100.dp)
                                .pointerInput(Unit) {
                                    detectDragGestures { change, dragAmount ->
                                        print(dragAmount)
                                        change.consumeAllChanges()
                                        offsetX2 += dragAmount.x
                                        offsetY2 += dragAmount.y
                                        if (abs(offsetX2 - offsetX1) < snapDistance && abs(offsetY2 - offsetY1) < snapDistance) {
                                            offsetX2 = offsetX1
                                            offsetY2 = offsetY1
                                        }
                                    }
                                }
                        )
                    }
                }
            }
        }
    }
}