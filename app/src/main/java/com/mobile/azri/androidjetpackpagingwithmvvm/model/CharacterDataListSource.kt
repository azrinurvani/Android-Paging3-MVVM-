package com.mobile.azri.androidjetpackpagingwithmvvm.model

import androidx.paging.PageKeyedDataSource
import com.mobile.azri.androidjetpackpagingwithmvvm.network.RetroInstance.Companion.initRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterDataListSource : PageKeyedDataSource<Int,CharacterData>(){



    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CharacterData>) {

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CharacterData>) {
        val call = initRetrofit.getDataFromApi(params.key)
        call.enqueue(object : Callback<RickAndMortyList> {
            override fun onResponse(
                call: Call<RickAndMortyList>,
                response: Response<RickAndMortyList>
            ) {
                if (response.isSuccessful){
                    callback.onResult(response.body()?.results as ArrayList<CharacterData>,params.key+1)
                }

            }

            override fun onFailure(call: Call<RickAndMortyList>, t: Throwable) {

            }

        })
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, CharacterData>
    ) {
        val call = initRetrofit.getDataFromApi(1)
        call.enqueue(object : Callback<RickAndMortyList> {
            override fun onResponse(
                call: Call<RickAndMortyList>,
                response: Response<RickAndMortyList>
            ) {
                if (response.isSuccessful){
                    callback.onResult(response.body()?.results as ArrayList<CharacterData>,null,2)
                }

            }

            override fun onFailure(call: Call<RickAndMortyList>, t: Throwable) {

            }

        })
    }
}