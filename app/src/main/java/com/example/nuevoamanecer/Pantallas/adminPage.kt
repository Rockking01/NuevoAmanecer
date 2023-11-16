package com.example.nuevoamanecer.Pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun adminPage(navController: NavHostController, usuario: Usuario = getData()[1]) {

    Column {
        Text(
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(
                    vertical = 10.dp),
            text = "Pagina del Admin"
        )
        FloatingActionButton(
            onClick = {
                navController.navigate("Login")
            },
            modifier = Modifier
                .align(Alignment.End)
        ) {
            Icon(Icons.Filled.Close, "Cerrar Sesion")
        }

        LazyColumn{
            items(items = getData()) {usuario ->
                dummyInfo(usuario)
            }
        }

    }



}