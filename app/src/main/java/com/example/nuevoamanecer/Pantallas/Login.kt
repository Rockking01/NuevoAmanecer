package com.example.nuevoamanecer.Pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Login() {
    var text by remember {
        mutableStateOf(" ")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 50.dp
            )
    ) {
        Button(onClick = {

        // Aqui iria el navController

        }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "Admin Login")
        }
        Button(onClick = {

        // Aqui iria el navController

        }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "User Login")
        }
    }
}