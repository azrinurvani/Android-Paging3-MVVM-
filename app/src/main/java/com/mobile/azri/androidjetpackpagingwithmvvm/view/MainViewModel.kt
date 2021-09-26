package com.mobile.azri.androidjetpackpagingwithmvvm.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.mobile.azri.androidjetpackpagingwithmvvm.model.CharacterData
import com.mobile.azri.androidjetpackpagingwithmvvm.model.CharacterListDataSourceFactory
import java.util.concurrent.Executors

//    TODO 9
class MainViewModel : ViewModel() {

    private var characterList : LiveData<PagedList<CharacterData>>? = null

    init {
        initPaging()
    }

    private fun initPaging() {
        val factory = CharacterListDataSourceFactory()
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(30)
            .build()

        val executor = Executors.newFixedThreadPool(5)
        characterList = LivePagedListBuilder<Int,CharacterData>(factory,config)
            .setFetchExecutor(executor)
            .build()


    }

    fun getRecyclerListObserver() : LiveData<PagedList<CharacterData>>? {
        return characterList
    }

}