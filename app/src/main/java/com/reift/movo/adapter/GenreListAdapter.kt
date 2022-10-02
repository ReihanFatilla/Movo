package com.reift.movo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reift.movo.databinding.ItemGenreListBinding

class GenreListAdapter:RecyclerView.Adapter<GenreListAdapter.GenreViewHolder>() {

    val listGenre = ArrayList<String>()

    fun setData(data: List<String>?) {
        if (data == null) return
        listGenre.clear()
        listGenre.addAll(data)
    }

    class GenreViewHolder(val binding: ItemGenreListBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GenreViewHolder(
        ItemGenreListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.binding.apply {
            tvGenre.text = listGenre[position]
        }
    }

    override fun getItemCount() = if(listGenre.size <= 3) listGenre.size else 3
}