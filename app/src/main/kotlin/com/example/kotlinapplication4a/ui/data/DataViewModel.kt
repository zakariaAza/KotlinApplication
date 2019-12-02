package com.example.kotlinapplication4a.ui.data

import android.arch.lifecycle.MutableLiveData
import com.example.kotlinapplication4a.base.BaseViewModel
import com.example.kotlinapplication4a.model.Data

class DataViewModel: BaseViewModel() {
    private val dataName = MutableLiveData<String>()
    private val dataWebPages = MutableLiveData<String>()

    fun bind(data: Data){
        dataName.value = data.name
        dataWebPages.value = data.web_pages
    }

    fun getDataTitle():MutableLiveData<String>{
        return dataName
    }

    fun getDataBody():MutableLiveData<String>{
        return dataWebPages
    }
}