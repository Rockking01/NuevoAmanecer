package com.example.nuevoamanecer.Pantallas

import com.example.nuevoamanecer.R


import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.RelativeLayout.ALIGN_PARENT_START
import android.widget.RelativeLayout.ALIGN_PARENT_TOP
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.nuevoamanecer.MainActivity
import java.util.*


@Composable
fun BalloonGameScreen(navController: NavController) {
    val context = LocalContext.current



    AndroidView(factory = { ctx ->
        ComposeView(ctx).apply {
            setContent {
                // Aquí puedes tener cualquier Composable adicional que necesites
                // para la pantalla del juego


                Box {
                    // Aquí se incrusta tu SurfaceView
                    AndroidView(factory = { innerContext ->
                        BalloonView(innerContext)



                    })
                }
            }
        }
    })
}

class BalloonView(context: Context) : SurfaceView(context), Runnable {

        private val thread: Thread = Thread(this)
        private val popSoundEffect: MediaPlayer = MediaPlayer.create(context, R.raw.popsoundeffect)
        private val matrix = Matrix()
        private val surfaceHolder: SurfaceHolder = holder
        private var balloons: MutableList<Balloon> = mutableListOf()
        private var gameRunning = true
        private val backgroundBitmap = BitmapFactory.decodeResource(
            resources,
            R.drawable.gamebackground
        )


    init {
            surfaceHolder.addCallback(object : SurfaceHolder.Callback {
                override fun surfaceCreated(holder: SurfaceHolder) {
                    resetGame()
                    thread.start()
                }

                override fun surfaceChanged(
                    holder: SurfaceHolder,
                    format: Int,
                    width: Int,
                    height: Int
                ) {
                }

                override fun surfaceDestroyed(holder: SurfaceHolder) {
                    gameRunning = false
                    thread.join()
                }

            })
        }

    private fun resetGame() {
            balloons.clear()
            val random = Random()
            val numBalloons = random.nextInt(7) + 6

            // Random number between 6 and 12
            for (i in 0 until numBalloons) {
                balloons.add(Balloon(context, width, height))
            }
        }

        fun resume() {
            gameRunning = true
        }

        fun pause() {
            gameRunning = false
        }

        override fun run() {
            while (gameRunning) {
                if (surfaceHolder.surface.isValid) {
                    val canvas = surfaceHolder.lockCanvas()

                    // Scale the background image to cover the entire canvas
                    val scaleWidth = canvas.width.toFloat() / backgroundBitmap.width
                    val scaleHeight = canvas.height.toFloat() / backgroundBitmap.height
                    matrix.reset()
                    matrix.postScale(scaleWidth, scaleHeight)

                    // Draw the scaled background
                    canvas.drawBitmap(backgroundBitmap, matrix, null)

                    // Draw the balloons
                    for (balloon in balloons) {
                        balloon.draw(canvas)
                        if (balloon.isPopped) {
                            balloons.remove(balloon)
                            break
                        }
                    }

                    surfaceHolder.unlockCanvasAndPost(canvas)

                    if (balloons.isEmpty()) {
                        resetGame()
                    }
                }
            }
        }

        override fun onTouchEvent(event: MotionEvent): Boolean {
            if (event.action == MotionEvent.ACTION_DOWN) {
                val x = event.x
                val y = event.y

                for (balloon in balloons) {
                    if (balloon.isTouched(x, y)) {
                        balloon.pop()

                        // Play the pop sound effect
                        playPopSoundEffect()

                        break
                    }
                }
            }
            return true
        }

        private fun playPopSoundEffect() {
            popSoundEffect.start()
        }
    }

     class Balloon(
        private val context: Context,
        private val screenWidth: Int,
        private val screenHeight: Int
    ) {
        private val paint: Paint = Paint()
        private var x: Float
        private var y: Float
        private val balloonBitmap: Bitmap
        var isPopped: Boolean = false
            private set

        init {
            paint.color = Color.BLUE

            // Load the balloon image from resources
            balloonBitmap = BitmapFactory.decodeResource(
                context.resources,
                R.drawable.globopixel
            )

            // Adjust the balloon's initial position
            x = Random().nextInt(screenWidth - balloonBitmap.width).toFloat()
            y = Random().nextInt(screenHeight - balloonBitmap.height).toFloat()
        }

        fun draw(canvas: Canvas) {
            if (!isPopped) {
                canvas.drawBitmap(balloonBitmap, x, y, paint)
            }
        }

        fun isTouched(touchX: Float, touchY: Float): Boolean {
            return !isPopped && touchX >= x && touchX <= x + balloonBitmap.width &&
                    touchY >= y && touchY <= y + balloonBitmap.height
        }

        fun pop() {
            isPopped = true
        }
    }

