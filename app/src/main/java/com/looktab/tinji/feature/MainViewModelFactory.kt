package com.looktab.tinji.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.looktab.tinji.data.source.AptosDataSource
import com.looktab.tinji.data.source.CustomDataSource


class MainViewModelFactory(
    private val aptosDataSource:AptosDataSource,
    private val  customDataSource:CustomDataSource
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return MainViewModel(aptosDataSource, customDataSource) as T
    }
}