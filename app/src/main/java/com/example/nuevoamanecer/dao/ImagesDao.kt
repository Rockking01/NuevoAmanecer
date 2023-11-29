package com.example.nuevoamanecer.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.nuevoamanecer.model.Images
import kotlinx.coroutines.flow.Flow

@Dao
interface ImagesDao {

    @Insert
    suspend fun saveImageReference(image: Images)

    @Query("Select * from images")
    fun getAllImages(): Flow<List<Images>>
}