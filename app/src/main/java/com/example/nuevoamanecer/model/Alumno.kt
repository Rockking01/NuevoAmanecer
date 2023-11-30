package com.example.nuevoamanecer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Alumno (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val edad: Int,
    val code: Int,
    val nivel: String,
    val MaxTablero: Int,
    val nivel1Jugado:Int,
    val nivel2Jugado:Int,
    val nivel3jugado: Int,
    val nivel4Jugado: Int,
    val nivel3N1C: Boolean,
    val nivel3N2C: Boolean,


) {
}
