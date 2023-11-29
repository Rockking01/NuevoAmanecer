package com.example.nuevoamanecer

import android.app.Application
import androidx.room.Room
import com.example.nuevoamanecer.db.AdminDatabase
import com.example.nuevoamanecer.db.AlumnosDatabase

class AdminApp : Application() {

    val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            AdminDatabase::class.java,
            "admin_db"
        ).build()
    }

}