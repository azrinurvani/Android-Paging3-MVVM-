package com.mobile.azri.androidjetpackpagingwithmvvm.model

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource


class CharacterListDataSourceFactory() : DataSource.Factory<Int, CharacterData>() {

    private var mutableLiveData : MutableLiveData<CharacterDataListSource>? = null

    init {
        mutableLiveData = MutableLiveData()
    }

    override fun create(): DataSource<Int, CharacterData> {
        val listDataSource = CharacterDataListSource()

        mutableLiveData?.postValue(listDataSource)

        return listDataSource
    }
}