package com.example.nuevoamanecer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Images (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)