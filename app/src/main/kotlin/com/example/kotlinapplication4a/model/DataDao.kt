package com.example.kotlinapplication4a.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataDao {
    @get:Query("SELECT * FROM data")
    val all: List<Data>

    @Insert
    fun insertAll(vararg datas: Data)
}