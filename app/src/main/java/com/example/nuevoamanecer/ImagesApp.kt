package com.example.nuevoamanecer

import android.app.Application
import androidx.room.Room
import com.example.nuevoamanecer.db.ImagesDatabase

class ImagesApp : Application() {

    val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            ImagesDatabase::class.java,
            "images_db"
        ).build()
    }

}