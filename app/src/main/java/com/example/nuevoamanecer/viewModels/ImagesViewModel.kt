package com.example.nuevoamanecer.viewModels

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.nuevoamanecer.ImagesApp
import com.example.nuevoamanecer.model.Images
import kotlinx.coroutines.launch

class ImagesViewModel(application: Application)  : AndroidViewModel(application) {

    val images = mutableStateOf<List<Images>>(emptyList())

    private val database = (application as ImagesApp).database
    private val dao = database.dao

    init {
        viewModelScope.launch {

            dao.getAllImages().collect() {
                images.value = it
            }

        }
    }

    fun saveImageReference(name: String) {
        val image = Images(0, name)

        viewModelScope.launch {
            dao.saveImageReference(image)
        }
    }
}
