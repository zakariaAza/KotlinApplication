package com.example.kotlinapplication4a.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.kotlinapplication4a.model.Data
import com.example.kotlinapplication4a.model.DataDao

@Database(entities = [Data::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataDao(): DataDao
}