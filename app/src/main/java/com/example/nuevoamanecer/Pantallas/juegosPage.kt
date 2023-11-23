package com.example.nuevoamanecer.Pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.annotations.concurrent.Background

@Composable
fun juegosPage(navController: NavHostController){
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
        Row {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Black),
                shape = RoundedCornerShape(20.dp),
                onClick = { navController.navigate("userPage")},
                modifier = Modifier
                .height(300.dp)
                .width(600.dp)
                .padding(
                    vertical = 20.dp,
                    horizontal = 20.dp
                )



            ) {
                Text(text = "Nivel 1", fontSize = 60.sp)
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Black),
                shape = RoundedCornerShape(20.dp),
                onClick = {  navController.navigate("userPage")},
                modifier = Modifier
                .height(300.dp)
                .width(600.dp)
                .padding(
                    vertical = 20.dp,
                    horizontal = 20.dp
                )) {
                Text(text = "Nivel 2", fontSize = 60.sp)
            }
        }

        Row {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Black),
                shape = RoundedCornerShape(20.dp),
                onClick = {  navController.navigate("userPage")},
                modifier = Modifier
                .height(300.dp)
                .width(600.dp)
                .padding(
                    vertical = 20.dp,
                    horizontal = 20.dp
                )) {
                Text(text = "Nivel 3", fontSize = 60.sp)
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Black),
                shape = RoundedCornerShape(20.dp),
                onClick = {  navController.navigate("userPage")},
                modifier = Modifier
                .height(300.dp)
                .width(600.dp)
                .padding(
                    vertical = 20.dp,
                    horizontal = 20.dp
                )) {
                Text(text = "Nivel 4", fontSize = 60.sp)
            }
        }
    }
}