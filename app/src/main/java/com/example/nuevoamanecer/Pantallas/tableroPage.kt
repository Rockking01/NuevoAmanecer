package com.example.nuevoamanecer.Pantallas

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.nuevoamanecer.R

@Composable
fun tableroPage(navController: NavHostController){

    Box(
        modifier = with (Modifier){
            fillMaxSize()
                .background(Color(0xFF4BADE9))
            // Replace with your image id


        }){


    }
    Column ( verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        FloatingActionButton(
            shape = RectangleShape,
            onClick = {
                navController.navigate("userPage")
            },
            modifier = Modifier
                .align(Alignment.Start)
        ) {
            Icon(Icons.Filled.ArrowBack, "Regresar")
        }

        FloatingActionButton(
            shape = RoundedCornerShape(20.dp),
            onClick = {
                navController.navigate("InsertImage")
            },
            modifier = Modifier
                .height(225.dp)
                .width(450.dp)
                .padding(
                    vertical = 10.dp,
                    horizontal = 10.dp
                )
        ) {
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()


            ) {

            Text(text = "Personal", fontSize = 58.sp)
            Image(
                painter = painterResource(id = R.drawable.personal),
                contentDescription = "Usuario",
                modifier = Modifier.size(150.dp)
            )
            }
        }


        Row {
            FloatingActionButton(
                shape = RoundedCornerShape(20.dp),
                onClick = { navController.navigate("Transporte")},
                modifier = Modifier
                    .height(225.dp)
                    .width(450.dp)
                    .padding(
                        vertical = 10.dp,
                        horizontal = 10.dp
                    )



            ) {
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()


                ) {
                    Text(text = "Transporte", fontSize = 58.sp)
                    Image(
                        painter = painterResource(id = R.drawable.motor),
                        contentDescription = "transporte",
                        modifier = Modifier.size(110.dp)
                    )
                }
            }
            FloatingActionButton(
                shape = RoundedCornerShape(20.dp),
                onClick = {  navController.navigate("Computadora")},
                modifier = Modifier
                    .height(225.dp)
                    .width(450.dp)
                    .padding(
                        vertical = 10.dp,
                        horizontal = 10.dp
                    )) {
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()


                ) {
                    Text(text = "Computadora", fontSize = 58.sp)
                    Image(
                        painter = painterResource(id = R.drawable.disco_compacto),
                        contentDescription = "computadora",
                        modifier = Modifier.size(110.dp)
                    )
                }
            }
        }

        Row {
            FloatingActionButton(
                shape = RoundedCornerShape(20.dp),
                onClick = {  navController.navigate("Animales")},
                modifier = Modifier
                    .height(225.dp)
                    .width(450.dp)
                    .padding(
                        vertical = 10.dp,
                        horizontal = 10.dp
                    )) {
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()


                ) {
                    Text(text = "Animales", fontSize = 58.sp)
                    Image(
                        painter = painterResource(id = R.drawable.abeja),
                        contentDescription = "Animales",
                        modifier = Modifier.size(110.dp)
                    )
                }
            }
            FloatingActionButton(
                shape = RoundedCornerShape(20.dp),
                onClick = {  navController.navigate("Oficina")},
                modifier = Modifier
                    .height(225.dp)
                    .width(450.dp)
                    .padding(
                        vertical = 10.dp,
                        horizontal = 10.dp
                    )) {
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()


                ) {
                    Text(text = "Oficina", fontSize = 58.sp)
                    Image(
                        painter = painterResource(id = R.drawable.escritorio),
                        contentDescription = "oficina",
                        modifier = Modifier.size(110.dp)
                    )
                }
            }
        }
    }
}