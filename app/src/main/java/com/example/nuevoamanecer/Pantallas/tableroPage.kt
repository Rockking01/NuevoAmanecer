package com.example.nuevoamanecer.Pantallas

import android.content.Context
import android.speech.tts.TextToSpeech
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.nuevoamanecer.R
import java.util.Locale

@Composable
fun tableroPage(navController: NavHostController) {
    val context = LocalContext.current
    val photos = getPhoto()
    Column (modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center){
    LazyHorizontalGrid(
        rows = GridCells.Adaptive(minSize = 128.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(photos) { photo ->

            val nameTTS = context.resources.getResourceEntryName(photo)

            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                FloatingActionButton(
                    onClick = {
                        processTTS(context, nameTTS)
                    }
                ) {
                    Image(
                        painter = painterResource(photo),
                        contentDescription = null,
                        modifier = Modifier.size(220.dp)
                    )
                }
            }
        }
    }
  }
}

fun processTTS(context: Context, word: String){

    var  textToSpeech: TextToSpeech? = null

    textToSpeech = TextToSpeech(context){

        if (it == TextToSpeech.SUCCESS){

            textToSpeech?.let {txtToSpeech ->
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

        } else  {
            //  NO TTS ENGINE INSTALLED ON DEVICE

        }

    }



}