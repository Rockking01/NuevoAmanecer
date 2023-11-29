package com.example.nuevoamanecer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Admin (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val email: String,
    val Password: String,


    )