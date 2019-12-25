package com.example.kotlinapplication4a.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinapplication4a.model.database.AppDatabase
import com.example.kotlinapplication4a.ui.data.DataListViewModel

class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DataListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "datas").build()
            @Suppress("UNCHECKED_CAST")
            return DataListViewModel(db.dataDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}