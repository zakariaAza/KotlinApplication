package com.example.kotlinapplication4a

import com.example.kotlinapplication4a.network.DataApi
import javax.inject.Inject

class DataListViewModel:BaseViewModel(){
    @Inject
    lateinit var dataApi: DataApi
}