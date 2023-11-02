package com.example.nuevoamanecer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.nuevoamanecer.Pantallas.Login
import com.example.nuevoamanecer.Pantallas.adminPage
import com.example.nuevoamanecer.Pantallas.juegosPage
import com.example.nuevoamanecer.Pantallas.tableroPage
import com.example.nuevoamanecer.Pantallas.userPage
import com.example.nuevoamanecer.ui.theme.NuevoAmanecerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NuevoAmanecerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Push desde mi branch, otra vez",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NuevoAmanecerTheme {
        Greeting("Android")
    }
}