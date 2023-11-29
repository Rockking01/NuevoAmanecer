package com.example.nuevoamanecer.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nuevoamanecer.dao.AlumnoDao
import com.example.nuevoamanecer.model.Alumno


@Database(entities = [Alumno::class],version=1)
abstract class AlumnosDatabase : RoomDatabase() {
    abstract  val dao: AlumnoDao
}