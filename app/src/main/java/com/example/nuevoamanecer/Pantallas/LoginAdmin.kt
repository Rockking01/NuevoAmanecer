package com.example.nuevoamanecer.Pantallas

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.nuevoamanecer.AdminViewModelFactory
import com.example.nuevoamanecer.R
import com.example.nuevoamanecer.viewModels.AdminViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginAdmin(navController: NavHostController) {


    val viewModel: AdminViewModel = viewModel()
    viewModel.createAdmin("Mariana Gabarrot","MarianaG@nuevoamanecer.mx", "Password123");

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
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
            .padding(top = 150.dp)

    ) {
        FloatingActionButton(
            shape = RectangleShape,
            onClick = {
                navController.navigate("Login")
            },
            modifier = Modifier
                .align(Alignment.Start)
        ) {
            Icon(Icons.Filled.ArrowBack, "Regresar")
        }

        Text(text = "Bienvenido", fontSize = 58.sp)

        Text(text = "Email Institucional:", fontSize = 30.sp)
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("pedro@nuevoamanecer.mx") }
        )
        Text(text = "Contraseña:", fontSize = 30.sp)
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            onClick = {

                viewModel.login(username, password);
               val loggedInAdmin = viewModel.loggedInAdmin.value;

                if (loggedInAdmin != null) {
                  navController.navigate("adminPage")
               } else {
                    Log.d("malusuario","error")
               }


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