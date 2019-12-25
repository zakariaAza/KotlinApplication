package com.example.kotlinapplication4a.ui.data

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.kotlinapplication4a.model.Data
import com.example.kotlinapplication4a.R
import com.example.kotlinapplication4a.databinding.ItemDataBinding

class DataListAdapter: RecyclerView.Adapter<DataListAdapter.ViewHolder>() {
    private lateinit var dataList:List<Data>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_data, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return if(::dataList.isInitialized) dataList.size else 0
    }

    fun updateDataList(dataList:List<Data>){
        this.dataList = dataList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemDataBinding): RecyclerView.ViewHolder(binding.root){
        private val viewModel = DataViewModel()

        fun bind(data: Data){
            viewModel.bind(data)
            binding.viewModel = viewModel
        }
    }
}