package com.example.nuevoamanecer.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nuevoamanecer.dao.ImagesDao
import com.example.nuevoamanecer.model.Images


@Database(entities=[Images::class], version=1)
abstract class ImagesDatabase : RoomDatabase() {

    abstract  val dao: ImagesDao
}
