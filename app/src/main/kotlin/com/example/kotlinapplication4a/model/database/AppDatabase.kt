package com.example.kotlinapplication4a.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlinapplication4a.model.Data
import com.example.kotlinapplication4a.model.DataDao

@Database(entities = [Data::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataDao(): DataDao
}