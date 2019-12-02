package com.example.kotlinapplication4a.base

import android.arch.lifecycle.ViewModel
import com.example.kotlinapplication4a.injection.component.DaggerViewModelInjector
import com.example.kotlinapplication4a.injection.component.ViewModelInjector
import com.example.kotlinapplication4a.injection.module.NetworkModule
import com.example.kotlinapplication4a.ui.data.DataListViewModel
import com.example.kotlinapplication4a.ui.data.DataViewModel

abstract class BaseViewModel:ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is DataListViewModel -> injector.inject(this)
            is DataViewModel -> injector.inject(this)
        }
    }
}