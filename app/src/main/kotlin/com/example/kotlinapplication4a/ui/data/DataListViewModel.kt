package com.example.kotlinapplication4a.ui.data

import androidx.lifecycle.MutableLiveData
import android.view.View
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import com.example.kotlinapplication4a.base.BaseViewModel
import com.example.kotlinapplication4a.model.Data
import com.example.kotlinapplication4a.model.DataDao
import com.example.kotlinapplication4a.network.DataApi
import com.example.kotlinapplication4a.R
import javax.inject.Inject

class DataListViewModel(private val dataDao: DataDao): BaseViewModel(){
    @Inject
    lateinit var dataApi: DataApi
    val dataListAdapter: DataListAdapter = DataListAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadDatas() }

    private lateinit var subscription: Disposable

    init{
        loadDatas()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadDatas(){
        subscription = dataApi.getDatas()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> onRetrieveDataListSuccess(result) },
                        { onRetrieveDataListError() }
                )

        return
        subscription = Observable.fromCallable { dataDao.all }
                .concatMap {
                    dbDataList ->
                        if(dbDataList.isEmpty())
                            dataApi.getDatas().concatMap {
                                            apiDataList -> dataDao.insertAll(*apiDataList.toTypedArray())
                                 Observable.just(apiDataList)
                                       }
                        else
                            Observable.just(dbDataList)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveDataListStart() }
                .doOnTerminate { onRetrieveDataListFinish() }
                .subscribe(
                        { result -> onRetrieveDataListSuccess(result) },
                        { onRetrieveDataListError() }
                )
    }

    private fun onRetrieveDataListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveDataListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveDataListSuccess(dataList:List<Data>){
        dataListAdapter.updateDataList(dataList)
    }

    private fun onRetrieveDataListError(){
        errorMessage.value = R.string.data_error
    }
}