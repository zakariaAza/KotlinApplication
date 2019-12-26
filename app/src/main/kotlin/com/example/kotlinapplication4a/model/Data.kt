package com.example.kotlinapplication4a.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Class which provides a model for data
 */
@Entity
data class Data(
        val id: String,
        val author: String,
        val width: String,
        val height: String,
        @field:PrimaryKey
        val download_url: String


)