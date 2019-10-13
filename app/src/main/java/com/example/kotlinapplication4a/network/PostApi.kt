package com.example.kotlinapplication4a.network

import com.example.kotlinapplication4a.model.Data
import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("/posts")
    fun getPosts(): Observable<List<Data>>

}