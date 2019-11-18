package com.example.kotlinapplication4a.network

import com.example.kotlinapplication4a.model.Data
import io.reactivex.Observable
import retrofit2.http.GET

interface DataApi {
    /**
     * Get the list from the API
     */
    @GET("/data")
    fun getPosts(): Observable<List<Data>>

}