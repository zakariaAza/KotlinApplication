package com.example.kotlinapplication4a.injection.component

import dagger.Component
import com.example.kotlinapplication4a.injection.module.NetworkModule
import com.example.kotlinapplication4a.ui.data.DataListViewModel
import com.example.kotlinapplication4a.ui.data.DataViewModel
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified DataListViewModel.
     * @param postListViewModel DataListViewModel in which to inject the dependencies
     */
    fun inject(dataListViewModel: DataListViewModel)
    /**
     * Injects required dependencies into the specified DataViewModel.
     * @param postViewModel DataViewModel in which to inject the dependencies
     */
    fun inject(dataViewModel: DataViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}