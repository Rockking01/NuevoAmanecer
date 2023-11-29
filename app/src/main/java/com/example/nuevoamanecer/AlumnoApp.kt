package com.example.nuevoamanecer

import android.app.Application
import androidx.room.Room
import com.example.nuevoamanecer.db.AlumnosDatabase
import com.example.nuevoamanecer.db.ImagesDatabase

class AlumnoApp : Application() {

    val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            AlumnosDatabase::class.java,
            "alumnos_db"
        ).build()
    }

}