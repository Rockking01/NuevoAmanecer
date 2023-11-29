package com.example.nuevoamanecer.viewModels

import com.example.nuevoamanecer.AdminApp
import com.example.nuevoamanecer.db.AdminDatabase
import com.example.nuevoamanecer.model.Admin

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nuevoamanecer.AlumnoApp
import com.example.nuevoamanecer.ImagesApp
import com.example.nuevoamanecer.model.Alumno
import kotlinx.coroutines.launch

class AdminViewModel(application: Application): AndroidViewModel(application){

    val admins = mutableStateOf<List<Admin>>(emptyList())
    val loggedInAdmin = mutableStateOf<Admin?>(null)

    private val database = (application as ImagesApp).database
    private val dao = database.Admdao

    init {
        viewModelScope.launch {

            dao.getAllAdmin().collect(){
                admins.value = it
            }

        }
    }
    fun createAdmin(name: String, email: String, Password: String, ){
        val admin = Admin(0,name,email, Password)
        viewModelScope.launch{
            dao.insertAdmin(admin)
        }
    }
    fun updateAdmin(admin: Admin){
        viewModelScope.launch {
            dao.updateAdmin(admin)
        }
    }
    fun deleteAdmin(admin: Admin){
        viewModelScope.launch {
            dao.updateAdmin(admin)
        }
    }

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val loggedInUser = dao.getUser(username, password)
            loggedInAdmin.value = loggedInUser
        }
    }

}