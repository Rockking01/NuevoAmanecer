package com.example.nuevoamanecer

import android.app.Application
import androidx.room.Room
import com.example.nuevoamanecer.db.Database
import com.example.nuevoamanecer.db.ImagesDatabase

class ImagesApp : Application() {

    val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            Database::class.java,
            "database"
        ).build()
    }

}