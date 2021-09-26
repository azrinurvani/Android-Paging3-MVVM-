package com.mobile.azri.androidjetpackpagingwithmvvm.network

import com.mobile.azri.androidjetpackpagingwithmvvm.model.RickAndMortyList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    //    TODO 4
    @GET("character") //character/?page=1
    fun getDataFromApi(
        @Query("page") page:Int
    ): Call<RickAndMortyList>


}