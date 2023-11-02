package com.example.nuevoamanecer.Pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun tableroPage(){
    Column {
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(
                    vertical = 10.dp
                ), text = "Tablero"
        )
    }
}