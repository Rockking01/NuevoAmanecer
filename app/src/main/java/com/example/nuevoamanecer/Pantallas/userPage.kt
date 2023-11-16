package com.example.nuevoamanecer.Pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun userPage(navController: NavHostController){
    Column {
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 10.dp),
            text = "Pagina del Usuario"
        )
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Button(
                onClick = {
                    navController.navigate("Tablero")
                },
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)
            ) {
                Text(text = "Tablero")
            }
            Button(
                onClick = {
                    navController.navigate("Juegos")
                },
                modifier = Modifier.padding(vertical = 10.dp)
            ) {
                Text(text = "Juegos")
            }
        }
        Button(
            onClick = {
                navController.navigate("Login")
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 30.dp)
        ) {
            Text(text = "Ir a Login")
        }
    }
}