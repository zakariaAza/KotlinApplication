package com.example.kotlinapplication4a.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Class which provides a model for data
 */
@Entity
data class Data(
        val id: String,
        @field:PrimaryKey
        val name: String,
        val symbol: String
)