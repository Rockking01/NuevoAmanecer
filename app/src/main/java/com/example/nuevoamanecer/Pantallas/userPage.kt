package com.example.nuevoamanecer.Pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.navigation.NavHostController
import com.example.nuevoamanecer.R

@Composable
fun userPage(navController: NavHostController){

    Box(
        modifier = Modifier.background(Color(0xFFa1beff))

    ){

    }

    Column( verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    )  {

        FloatingActionButton(
            shape = CircleShape,
            onClick = {
                navController.navigate("Login")
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
            FloatingActionButton (
                onClick = {
                    navController.navigate("Tablero")
                },
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp).height(400.dp)
                    .width(600.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tableroimage),
                    contentDescription = "Tablero",
                    modifier = Modifier.size(220.dp)
                )
            }
            FloatingActionButton(
                onClick = {
                    navController.navigate("Juegos")
                },
                modifier = Modifier.padding(vertical = 10.dp).height(400.dp)
                    .width(600.dp)
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