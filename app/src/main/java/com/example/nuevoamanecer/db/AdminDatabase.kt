package com.example.nuevoamanecer.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nuevoamanecer.dao.AdminDao
import com.example.nuevoamanecer.dao.AlumnoDao
import com.example.nuevoamanecer.model.Admin
import com.example.nuevoamanecer.model.Alumno

@Database(entities = [Admin::class],version=1)
abstract class AdminDatabase : RoomDatabase() {
    abstract  val dao: AdminDao
}