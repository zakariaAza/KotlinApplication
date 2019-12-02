package com.example.kotlinapplication4a.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Class which provides a model for data
 * @constructor Sets all properties of the post
 * @property userId the unique identifier of the author of the post
 * @property id the unique identifier of the post
 * @property title the title of the post
 * @property body the content of the post
 */
@Entity
data class Data(
        val country: String,
        val web_pages: String,
        @field:PrimaryKey
        val name: String,
        val alpha_two_code: String,
        val domains: String,
        val state_province: String
)