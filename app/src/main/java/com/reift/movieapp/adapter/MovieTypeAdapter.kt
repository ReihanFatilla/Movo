package com.reift.movieapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reift.movieapp.databinding.ItemListMovieRvBinding
import com.reift.movieapp.presentation.home.component.MovieTypeData

class MovieTypeAdapter: RecyclerView.Adapter<MovieTypeAdapter.MyViewHolder>() {
    var listMovieType = ArrayList<MovieTypeData>()

    fun setData(data: List<MovieTypeData>?) {
        if (data == null) return
        listMovieType.clear()
        listMovieType.addAll(data)
    }

    class MyViewHolder(val binding: ItemListMovieRvBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= MyViewHolder(
        ItemListMovieRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            tvType.text = listMovieType[position].type
            tvTypeDesc.text = listMovieType[position].desc
            rvMovieType.apply {
                val mAdapter = HorizontalListAdapter()
                adapter = mAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                mAdapter.setData(listMovieType[position].movieType)
            }
        }
    }

    override fun getItemCount() = listMovieType.size
}