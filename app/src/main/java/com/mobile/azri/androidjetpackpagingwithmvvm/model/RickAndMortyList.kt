package com.mobile.azri.androidjetpackpagingwithmvvm.model

data class RickAndMortyList(
    val results:ArrayList<CharacterData?>?
)
data class CharacterData(
    val name:String?,
    val species:String?,
    val image:String?
)
