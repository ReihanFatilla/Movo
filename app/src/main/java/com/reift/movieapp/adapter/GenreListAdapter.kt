package com.reift.movieapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reift.movieapp.HelperFunction
import com.reift.movieapp.databinding.ItemGenreListBinding

class GenreListAdapter:RecyclerView.Adapter<GenreListAdapter.GenreViewHolder>() {

    val genreList = ArrayList<Int>()

    fun setData(data: List<Int>?) {
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
            val genre = HelperFunction.getGenreById(genreList[position].toString())
            tvGenre.text = genre
        }
    }

    override fun getItemCount() = genreList.size
}