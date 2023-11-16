package com.example.nuevoamanecer.Pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.nuevoamanecer.R

@Composable
fun juegosPage(navController: NavHostController){
    Box(
        modifier = Modifier.background(Color(0xFFa1beff))

    ){

    }

    Column {

        FloatingActionButton(
            onClick = {
                navController.navigate("userPage")
            },
            modifier = Modifier
                .align(Alignment.End)
        ) {
            Icon(Icons.Filled.Close, "Pagina de Usuario")
        }

        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Button(onClick = {

                // navController Juego 1

            }, modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 10.dp)
                .height(120.dp)
                .width(300.dp)) {
                Text(text = "Nivel 1", fontSize = 30.sp)
            }
            Button(onClick = {

                // navController Juego 2

            }, modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 10.dp)
                .height(120.dp)
                .width(300.dp)) {
                Text(text = "Nivel 2", fontSize = 30.sp)
            }
        }

        Row(
            modifier = Modifier
                .padding(vertical = 5.dp,horizontal = 5.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Button(onClick = {

                // navController Juego 3

            }, modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 10.dp)
                .height(120.dp)
                .width(300.dp)) {
                Text(text = "Nivel 3", fontSize = 30.sp)
            }
            Button(onClick = {

                // navController Juego 4

            }, modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 10.dp)
                .height(120.dp)
                .width(300.dp)) {
                Text(text = "Nivel 4", fontSize = 30.sp)
            }
        }


    }
}