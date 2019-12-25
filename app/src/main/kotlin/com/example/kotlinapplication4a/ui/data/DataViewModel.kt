package com.example.kotlinapplication4a.ui.data

import androidx.lifecycle.MutableLiveData
import com.example.kotlinapplication4a.base.BaseViewModel
import com.example.kotlinapplication4a.model.Data

class DataViewModel: BaseViewModel() {
    private val dataName = MutableLiveData<String>()
    private val dataId= MutableLiveData<String>()


    fun bind(data: Data){
        dataName.value = data.name
        dataId.value = data.id
    }

    fun getDataTitle():MutableLiveData<String>{
        return dataName
    }

    fun getDataId():MutableLiveData<String>{
        return dataId
    }
}