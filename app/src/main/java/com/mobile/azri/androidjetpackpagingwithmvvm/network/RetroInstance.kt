package com.mobile.azri.androidjetpackpagingwithmvvm.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object{
        val BASE_URL = "https://rickandmortyapi.com/api/" //character/?page=1

        fun getRetroInstance() : Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val initRetrofit: RetroService = getRetroInstance().create(RetroService::class.java)
    }

}