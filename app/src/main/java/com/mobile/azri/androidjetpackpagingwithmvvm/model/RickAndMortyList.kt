package com.mobile.azri.androidjetpackpagingwithmvvm.model

//    TODO 3
data class RickAndMortyList(
    val results:ArrayList<CharacterData?>?
)
data class CharacterData(
    val name:String?,
    val species:String?,
    val image:String?
)
