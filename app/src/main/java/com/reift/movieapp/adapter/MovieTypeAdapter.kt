package com.reift.movieapp.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reift.movieapp.`interface`.OnItemClickCallback
import com.reift.movieapp.constant.Constant
import com.reift.movieapp.data.ResultsItem
import com.reift.movieapp.databinding.ItemListMovieRvBinding
import com.reift.movieapp.presentation.detail.DetailActivity
import com.reift.movieapp.presentation.home.component.MovieTypeData
import com.reift.movieapp.utils.MyDiffUtils

class MovieTypeAdapter: RecyclerView.Adapter<MovieTypeAdapter.MyViewHolder>() {
    var listMovieType = ArrayList<MovieTypeData>()

    fun setData(data: MovieTypeData) {
        listMovieType.add(data)
        notifyDataSetChanged()
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

                mAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                    override fun onItemClicked(data: ResultsItem) {
                        val intent = Intent(context, DetailActivity::class.java)
                        if(data.title == null){
                            intent.putExtra(Constant.INTENT_TO_DETAIL, data.id)
                            intent.putExtra(Constant.INTENT_TYPE, Constant.INTENT_TV)
                        } else {
                            intent.putExtra(Constant.INTENT_TO_DETAIL, data.id)
                            intent.putExtra(Constant.INTENT_TYPE, Constant.INTENT_MOVIE)
                        }
                        holder.itemView.context.startActivity(intent)
                    }
                })
            }
        }
    }

    override fun getItemCount() = listMovieType.size
}