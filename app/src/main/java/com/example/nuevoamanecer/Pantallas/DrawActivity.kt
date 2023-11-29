
import android.os.Bundle
import androidx.activity.ComponentActivity
import android.graphics.Color
import android.widget.Button
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.nuevoamanecer.Pantallas.BalloonView
import com.example.nuevoamanecer.R


@Composable
fun DrawScreen(navController: NavController) {
    val context = LocalContext.current



    AndroidView(factory = { ctx ->
        ComposeView(ctx).apply {
            setContent {
                // Aquí puedes tener cualquier Composable adicional que necesites
                // para la pantalla del juego


                Box {
                    // Aquí se incrusta tu SurfaceView
                    AndroidView(factory = { innerContext ->
                        DrawingView(innerContext)

                    })
                }
            }
        }
    })
}
class DrawActivity : ComponentActivity() {
    private lateinit var drawingView: DrawingView
    private lateinit var btnColorRed: Button
    private lateinit var btnColorBlue: Button
    private lateinit var btnColorYellow: Button
    private lateinit var btnColorOrange: Button
    private lateinit var btnColorPurple: Button
    private lateinit var btnColorGreen: Button
    private lateinit var btnClearCanvas: Button
    private lateinit var btnColorBlack: Button
    private lateinit var btnColorBrown: Button
    private lateinit var btnColorPink: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawing)

        drawingView = findViewById(R.id.drawingView)
        btnColorRed = findViewById(R.id.btnColorRed)
        btnColorBlue = findViewById(R.id.btnColorBlue)
        btnColorYellow = findViewById(R.id.btnColorYellow)
        btnColorOrange = findViewById(R.id.btnColorOrange)
        btnColorPurple = findViewById(R.id.btnColorPurple)
        btnColorGreen = findViewById(R.id.btnColorGreen)
        btnClearCanvas = findViewById(R.id.btnClearCanvas)
        btnColorBlack = findViewById(R.id.btnColorBlack)
        btnColorBrown = findViewById(R.id.btnColorBrown)
        btnColorPink = findViewById(R.id.btnColorPink)


        btnColorRed.setOnClickListener { drawingView.setColor(Color.RED) }
        btnColorBlue.setOnClickListener { drawingView.setColor(Color.BLUE) }
        btnColorYellow.setOnClickListener { drawingView.setColor(Color.YELLOW) }
        btnColorOrange.setOnClickListener { drawingView.setColor(Color.parseColor("#FFA500")) } // Naranja
        btnColorPurple.setOnClickListener { drawingView.setColor(Color.parseColor("#800080")) } // Morado
        btnColorGreen.setOnClickListener { drawingView.setColor(Color.GREEN) }
        btnColorBlack.setOnClickListener { drawingView.setColor(Color.BLACK) }
        btnColorBrown.setOnClickListener { drawingView.setColor(Color.parseColor("#A52A2A")) } // Marrón
        btnColorPink.setOnClickListener { drawingView.setColor(Color.parseColor("#FFC0CB")) } // Rosa




        btnClearCanvas.setOnClickListener {
            drawingView.clearCanvas() // Llama al método para limpiar el canvas
        }


    }
}

class DrawingView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    data class PathWithColor(val path: Path, val color: Int)

    private val paths: MutableList<PathWithColor> = mutableListOf()
    private var currentPath: PathWithColor? = null
    private val paint: Paint = Paint()
    private var currentColor: Int = Color.BLACK


    init {
        setupDrawing()
    }

    private fun setupDrawing() {
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeWidth = 10f
    }

    fun clearCanvas() {
        paths.clear()
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (path in paths) {
            paint.color = path.color
            canvas.drawPath(path.path, paint)
        }
        currentPath?.let {
            paint.color = currentColor
            canvas.drawPath(it.path, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val touchX = event.x
        val touchY = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                currentPath = PathWithColor(Path(), currentColor)
                currentPath?.path?.moveTo(touchX, touchY)
            }
            MotionEvent.ACTION_MOVE -> {
                currentPath?.path?.lineTo(touchX, touchY)
            }
            MotionEvent.ACTION_UP -> {
                currentPath?.let { paths.add(it) }
                currentPath = null
            }
        }
        invalidate()
        return true
    }

    fun setColor(newColor: Int) {
        currentColor = newColor
    }
}