package com.reift.movieapp.presentation.home.component

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reift.movieapp.data.ResultsItem
import com.reift.movieapp.databinding.ItemGenreListBinding

class GenreListAdapter:RecyclerView.Adapter<GenreListAdapter.GenreViewHolder>() {

    val genreList = ArrayList<ResultsItem>()

    fun setData(data: List<ResultsItem>?) {
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
            val genre = when(genreList[position].genreIds.toString()){
                "28" -> "Action"
                "12" -> "Adventure"
                "16" -> "Animation"
                "35" -> "Comedy"
                "80" -> "Crime"
                "99" -> "Documentary"
                "18" -> "Drama"
                "10751" -> "Family"
                "14" -> "Fantasy"
                "36" -> "History"
                "27" -> "Horror"
                "10402" -> "Music"
                "9648" -> "Mystery"
                "10749" -> "Romance"
                "878" -> "Science Fiction"
                "10770" -> "TV Movie"
                "53" -> "Thriller"
                "10752" -> "War"
                "37" -> "Western"
                else -> "animeh"
            }
            tvGenre.text = genre
        }
    }

    override fun getItemCount() = genreList.size
}