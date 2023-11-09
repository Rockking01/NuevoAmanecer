package com.example.nuevoamanecer.Pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun adminPage(navController: NavHostController) {
    Column {
        Text(modifier = Modifier
            .align(CenterHorizontally)
            .padding(
                vertical = 10.dp
            )
            , text = "Pagina del Admin")
        Button(onClick = {

            navController.navigate("Login")

        }, modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(
                vertical = 50.dp
            )
        ) {
            Text(text = "Ir a Login")
        }
    }
}