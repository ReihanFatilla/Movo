package com.reift.movieapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.reift.movieapp.presentation.home.component.MovieTypeData

class MyDiffUtils(private val oldList: List<MovieTypeData>, private val newList: List<MovieTypeData>):DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val OldList = oldList[oldItemPosition]
        val NewList = newList[newItemPosition]
        return OldList.type == NewList.type
                && OldList.desc == NewList.desc
                && OldList.movieType == NewList.movieType
    }
}