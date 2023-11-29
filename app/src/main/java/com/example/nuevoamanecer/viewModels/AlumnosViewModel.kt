package com.example.nuevoamanecer.viewModels

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nuevoamanecer.AlumnoApp
import com.example.nuevoamanecer.ImagesApp
import com.example.nuevoamanecer.model.Alumno
import kotlinx.coroutines.launch

class AlumnosViewModel(application: Application): ViewModel(){

    val alumnos = mutableStateOf<List<Alumno>>(emptyList())

    private val database = (application as ImagesApp).database
    private val dao = database.Alumdao

    init {
        viewModelScope.launch {

            dao.getAllAlumno().collect(){
                alumnos.value = it
            }

        }
    }
    fun createAlumno(name: String, edad: Int, nivel: String ){
        val alumno = Alumno(0,name , edad, nivel,0,0,0,0,0,false,false)
        viewModelScope.launch{
            dao.insertAlumno(alumno)
        }
    }
    fun updateAlumno(alumno: Alumno){
        viewModelScope.launch {
            dao.updateAlumno(alumno)
        }
    }
    fun deleteAlumno(alumno: Alumno){
        viewModelScope.launch {
            dao.deleteAlumno(alumno)
        }
    }


}