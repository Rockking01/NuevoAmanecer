package com.example.nuevoamanecer.Pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.nuevoamanecer.db.compuGetPhoto


@Composable
fun computadoraPictoPage (navController: NavHostController) {
    val context = LocalContext.current
    val photos = compuGetPhoto()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            FloatingActionButton(
                shape = RectangleShape,
                onClick = {
                    navController.navigate("Tablero")
                },
                modifier = Modifier
                    .align(Alignment.Start)
            ) {
                Icon(Icons.Filled.ArrowBack, "Y")
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(5)
            ) {
                items(photos) { photo ->

                    val nameTTS = context.resources.getResourceEntryName(photo)

                    Column(
                        modifier = Modifier.padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        FloatingActionButton(
                            onClick = {
                                processTTS(context, nameTTS)
                            }
                        ) {
                            Image(
                                painter = painterResource(photo),
                                contentDescription = null,
                                modifier = Modifier.size(220.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}