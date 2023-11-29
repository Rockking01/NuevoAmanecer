package com.example.nuevoamanecer.Pantallas


import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.nuevoamanecer.viewModels.ImagesViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun InsertImage(navController: NavHostController) {

    val context = LocalContext.current
    val imageUri = remember { mutableStateOf<Uri?>(null) }
    val imageName = remember { mutableStateOf("") } // Nuevo estado para el nombre de la imagen

    val imagesViewModel: ImagesViewModel = viewModel()

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
            imageUri.value = uri
        }

    val bitmap: ImageBitmap? = imageUri.value?.let { uri ->
        context.contentResolver.openInputStream(uri)?.use { inputStream ->
            BitmapFactory.decodeStream(inputStream)?.asImageBitmap()
        }
    }

    val images = imagesViewModel.images.value

    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            FloatingActionButton(
                shape = RectangleShape,
                onClick = {
                    navController.navigate("Tablero")
                },
                modifier = Modifier
                    .align(Alignment.Start)
            ) {
                Icon(Icons.Filled.ArrowBack,"X")
            }

            Button(onClick = {
                launcher.launch("image/*")
            }) {
                Text("Escoge tu Imagen")
            }

            if (imageUri.value != null) {
                // Campo de texto para ingresar el nombre de la imagen
                TextField(
                    value = imageName.value,
                    onValueChange = { newName ->
                        imageName.value = newName
                    },
                    label = { Text("Qué/Quién es?") }
                )

                Button(onClick = {
                    imageUri.value?.let {
                        val inputStream = context.contentResolver.openInputStream(it)
                        val finalImageName = if (imageName.value.isEmpty()) "Imagen sin nombre"
                        else imageName.value // Usar el nombre ingresado por el usuario
                        val outputStream =
                            context.openFileOutput(finalImageName, Context.MODE_PRIVATE)

                        inputStream?.use { input ->
                            outputStream.use { output ->
                                input.copyTo(output)
                                imagesViewModel.saveImageReference(finalImageName)
                            }
                        }
                    }
                }) {
                    Text("Guardar Imagen")
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(5)
            ) {
                items(images) { image ->
                    val imageBitmap = getBitmap(name = image.name, context = context)
                    if (imageBitmap != null) {
                        val imageName = image.name
                        Box(
                            modifier = Modifier
                                .padding(6.dp)
                        ) {
                            FloatingActionButton(
                                onClick = {
                                    procesaTTS(context, imageName)
                                },
                                content = {
                                    Image(
                                        bitmap = imageBitmap,
                                        contentDescription = "Selected Image",
                                        modifier = Modifier.size(220.dp)
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }

}


@Composable
fun getBitmap(name: String, context: Context): ImageBitmap? {

    val bitmap = remember {
        try {
            context.openFileInput(name).use { inputStream ->
                if (inputStream != null) {
                    BitmapFactory.decodeStream(inputStream)?.asImageBitmap()
                } else {
                    null // Handle the case where the file doesn't exist
                }
            }
        } catch (e: Exception) {
            // Handle any exceptions that may occur
            Log.d("ERROR", e.message.toString())
            null
        }
    }
    return bitmap

}

fun procesaTTS(context: Context, word: String) {

    var textToSpeech: TextToSpeech? = null

    textToSpeech = TextToSpeech(context) {

        if (it == TextToSpeech.SUCCESS) {

            textToSpeech?.let { txtToSpeech ->
                val locSpanish = Locale("spa", "MEX")


                txtToSpeech.language = locSpanish
                txtToSpeech.setSpeechRate(1.0f)
                txtToSpeech.speak(
                    word,
                    TextToSpeech.QUEUE_ADD,
                    null,
                    null
                )

            }

        } else {
            //  NO TTS ENGINE INSTALLED ON DEVICE

        }

    }
}
