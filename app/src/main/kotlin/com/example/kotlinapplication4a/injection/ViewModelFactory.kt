package com.example.kotlinapplication4a.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
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