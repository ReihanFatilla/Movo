package com.reift.movieapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.reift.movieapp.`interface`.GetCurrentPosition
import com.reift.movieapp.constant.Constant
import com.reift.movieapp.data.ResultsItem
import com.reift.movieapp.databinding.ItemCarouselHomeBinding
import com.reift.movieapp.presentation.detail.DetailActivity

class CarouselAdapter(
): RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    private val listMovie = ArrayList<ResultsItem>()

    fun setData(data: List<ResultsItem>?) {
        if (data == null) return
        listMovie.clear()
        listMovie.addAll(data)
    }

    private var getCurrentPosition: GetCurrentPosition? = null

    fun getCurrentItemPosition(getCurrentPosition: GetCurrentPosition) {
        this.getCurrentPosition = getCurrentPosition
    }

    class CarouselViewHolder(val binding: ItemCarouselHomeBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CarouselViewHolder(
        ItemCarouselHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        holder.binding.apply {
            Glide.with(imgMovie.context)
                .load(Constant.IMAGE_BASE_URL+listMovie[position].posterPath)
                .apply(RequestOptions())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .into(imgMovie)
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
                if(listMovie[position].title == null){
                    intent.putExtra(Constant.INTENT_TO_DETAIL, listMovie[position].id)
                    intent.putExtra(Constant.INTENT_TYPE, Constant.INTENT_TV)
                } else {
                    intent.putExtra(Constant.INTENT_TO_DETAIL, listMovie[position].id)
                    intent.putExtra(Constant.INTENT_TYPE, Constant.INTENT_MOVIE)
                }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listMovie.size

}