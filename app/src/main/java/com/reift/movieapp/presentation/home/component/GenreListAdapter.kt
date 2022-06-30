package com.reift.movieapp.presentation.home.component

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reift.movieapp.data.ResultsItem
import com.reift.movieapp.databinding.ItemGenreListBinding

class GenreListAdapter:RecyclerView.Adapter<GenreListAdapter.GenreViewHolder>() {

    val genreList = ArrayList<GenreItems>()

    fun setData(data: List<GenreItems>?) {
        if (data == null) return
        genreList.clear()
        genreList.addAll(data)
    }

    class GenreViewHolder(val binding: ItemGenreListBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GenreViewHolder(
        ItemGenreListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.binding.apply {
            tvGenre.text = genreList[position].genre
        }
    }

    override fun getItemCount() = genreList.size
}