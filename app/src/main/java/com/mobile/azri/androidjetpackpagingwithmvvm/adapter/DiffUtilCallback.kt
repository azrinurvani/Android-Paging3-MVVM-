package com.mobile.azri.androidjetpackpagingwithmvvm.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mobile.azri.androidjetpackpagingwithmvvm.model.CharacterData

//    TODO 7
class DiffUtilCallback : DiffUtil.ItemCallback<CharacterData>() {
    override fun areItemsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
        return oldItem.name == newItem.name && oldItem.species == newItem.species
    }
}