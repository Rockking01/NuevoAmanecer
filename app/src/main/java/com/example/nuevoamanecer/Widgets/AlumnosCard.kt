package com.example.nuevoamanecer.Widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nuevoamanecer.model.Alumno



@Composable
fun AlumnoCard(alumno: Alumno, onItemClick: (String) -> Unit={}){


    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable {

                onItemClick(alumno.name)

            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ){


        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp)){

               //image
            }
            Column (modifier = Modifier.padding(4.dp)){
                Text(text = "${alumno.name}" , style = MaterialTheme.typography.headlineMedium)
                Text(text = "${alumno.edad}" , style = MaterialTheme.typography.bodyMedium)
                Text(text = "${alumno.nivel}" , style = MaterialTheme.typography.bodyMedium)

            }
        }

    }
}