package com.example.nuevoamanecer.dao

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update
import com.example.nuevoamanecer.model.Admin
import com.example.nuevoamanecer.model.Alumno
import kotlinx.coroutines.flow.Flow

@Dao
interface AlumnoDao {
    @Insert
    suspend fun insertAlumno(alumno: Alumno)



    @Query("Select * from alumno")
    fun getAllAlumno(): Flow<List<Alumno>>

    @Query("SELECT * FROM alumno WHERE name = :nombre AND code = :code")
    suspend fun getUser(nombre: String, code: Int): Alumno?

    @Delete
    suspend fun deleteAlumno(alumno: Alumno)

    @Update
    suspend fun updateAlumno(alumno: Alumno)
}