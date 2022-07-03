package com.reift.movieapp.presentation.home.component

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reift.movieapp.data.ResultsItem
import com.reift.movieapp.databinding.ItemHorizontalMovieBinding

class HorizontalListAdapter: RecyclerView.Adapter<HorizontalListAdapter.MyViewHolder>() {
    val listMovie = ArrayList<ResultsItem>()

    class MyViewHolder(val binding: ItemHorizontalMovieBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= MyViewHolder(
        ItemHorizontalMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val ratingCount = "(${listMovie[position].voteAverage})"

        holder.binding.apply {
            tvTitle.text = listMovie[position].title
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}