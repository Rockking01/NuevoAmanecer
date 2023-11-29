package com.example.nuevoamanecer.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.nuevoamanecer.model.Admin
import com.example.nuevoamanecer.model.Alumno
import kotlinx.coroutines.flow.Flow

@Dao
interface AdminDao {
    @Insert
    suspend fun insertAdmin(admin: Admin)



    @Query("Select * from admin")
    fun getAllAdmin(): Flow<List<Admin>>

    @Query("SELECT * FROM admin WHERE email = :username AND password = :password")
    suspend fun getUser(username: String, password: String): Admin?

    @Delete
    suspend fun deleteAdmin(admin: Admin)

    @Update
    suspend fun updateAdmin(admin: Admin)


}