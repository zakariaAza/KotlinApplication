package com.example.kotlinapplication4a.network

import io.reactivex.Observable
import com.example.kotlinapplication4a.model.Data
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface DataApi {
    /**
     * Get the list of universities from the API
     */
    @GET("/search?country=france")
    fun getDatas(): Observable<List<Data>>
}