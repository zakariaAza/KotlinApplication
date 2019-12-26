package com.example.kotlinapplication4a.ui.data

import androidx.lifecycle.MutableLiveData
import com.example.kotlinapplication4a.base.BaseViewModel
import com.example.kotlinapplication4a.model.Data
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import java.io.IOException
import java.net.HttpURLConnection
import android.R.attr.bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable




class DataViewModel: BaseViewModel() {
    private val dataAuthor = MutableLiveData<String>()
    private val dataUrlImage= MutableLiveData<String>()



    fun bind(data: Data){
        dataAuthor.value = data.author
        dataUrlImage.value = data.download_url
    }

    fun getDataAuthor():MutableLiveData<String>{
        return dataAuthor
    }

    fun getDataImage():MutableLiveData<String> {

        return dataUrlImage
    }

}