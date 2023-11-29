package com.example.nuevoamanecer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Alumno (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val MaxTablero: Int,

)
