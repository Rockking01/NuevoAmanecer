package com.example.nuevoamanecer.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nuevoamanecer.dao.AdminDao
import com.example.nuevoamanecer.dao.AlumnoDao
import com.example.nuevoamanecer.dao.ImagesDao
import com.example.nuevoamanecer.model.Admin
import com.example.nuevoamanecer.model.Alumno
import com.example.nuevoamanecer.model.Images

    @Database(entities = [Alumno::class, Images::class, Admin::class],version=1)
    abstract class Database : RoomDatabase() {
        abstract  val Alumdao: AlumnoDao
        abstract  val Admdao: AdminDao
        abstract  val Imgdao: ImagesDao
    }
