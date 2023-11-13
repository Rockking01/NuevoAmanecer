package com.example.nuevoamanecer.Pantallas

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.nuevoamanecer.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginAdmin(navController: NavHostController) {


    var name by remember { mutableStateOf("") }
    var code by remember { mutableStateOf("") }
    Box(
        modifier = with (Modifier){
            fillMaxSize()
                .background(Color(0xFF4BADE9))
            // Replace with your image id


        }){


    }

    Box(
        modifier = with (Modifier){
            fillMaxWidth(0.6f)
                .paint(
                    // Replace with your image id
                    painterResource(id = R.drawable.fondo),
                    contentScale = ContentScale.Crop)

        })





    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth(.6f)
            .padding(top = 200.dp)

    ) {

        Text(text = "Bienvenido", fontSize = 58.sp)

        Text(text = "Email Institucional:", fontSize = 30.sp)
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre Alumno") }
        )
        Text(text = "Contraseña:", fontSize = 30.sp)
        TextField(
            value = code,
            onValueChange = { code = it },
            label = { Text("Enter password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            onClick = {

                navController.navigate("adminPage")

            }, modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(100.dp)
                .width(200.dp)
                .padding(
                    vertical = 20.dp
                )
        ) {
            Text(text = "Ingresar", fontSize = 30.sp)


        }
    }
    Column {
        Image(
            painter = painterResource(id = R.drawable.logo_nuevo_amanecer),
            contentDescription = "Logo",
            modifier = Modifier.padding(top = 150.dp, start = 800.dp).size(400.dp)


        )
    }

}