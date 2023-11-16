package com.example.nuevoamanecer.Pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun dummyInfo(usuario: Usuario = getData()[1]) {

    Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){

        Row(
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.CenterHorizontally)
        ) {

            Row(
                modifier = Modifier
                    .padding(4.dp)
            ){

                Text(text = "ID: ${usuario.id} ", style = MaterialTheme.typography.bodyMedium, fontSize = 45.sp)

            }

            Row(
                modifier = Modifier
                    .padding(4.dp)
            ){

                Text(text = "${usuario.firstName} ", style = MaterialTheme.typography.bodyMedium, fontSize = 45.sp)
                Text(text = "${usuario.lastName} ", style = MaterialTheme.typography.bodyMedium, fontSize = 45.sp)

            }

            Row(
                modifier = Modifier
                    .padding(4.dp)
            ){

                Text(text = "NIVEL: ${usuario.level}", style = MaterialTheme.typography.bodyMedium, fontSize = 45.sp)

            }
        }

    }
}