package com.example.nuevoamanecer.Pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nuevoamanecer.R

@Preview
@Composable
fun userPage(){

    Box(
        modifier = Modifier.background(Color(0xFFa1beff))

        ){

    }

    Column {

        FloatingActionButton(
            onClick = {
                // Aqui iria el navController
            },
            modifier = Modifier
                .align(Alignment.End)
        ) {
            Icon(Icons.Filled.Close, "Cerrar Sesion")
        }

        Row(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            FloatingActionButton(
                onClick = {
                    // Aqui iria el navController
                },
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tableroimage),
                    contentDescription = "Tablero",
                    modifier = Modifier.size(220.dp)
                )
            }
            FloatingActionButton(
                onClick = {
                    // Aqui iria el navController
                },
                modifier = Modifier.padding(vertical = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.juegosimage),
                    contentDescription = "Juegos",
                    modifier = Modifier.size(220.dp)
                )
            }
        }


    }
}