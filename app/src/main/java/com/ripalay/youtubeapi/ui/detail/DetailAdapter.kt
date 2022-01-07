package com.ripalay.youtubeapi.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ripalay.youtubeapi.data.remote.model.Items
import com.ripalay.youtubeapi.databinding.ItemSeriesBinding
import com.ripalay.youtubeapi.extensions.load

class DetailAdapter(
    private val list: List<Items>,
    private val clickListener: (item: Items) -> Unit
) : RecyclerView.Adapter<DetailAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemSeriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private val binding: ItemSeriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(list: Items) {
            binding.titleTv.text = list.snippet.title
            binding.avaIv.load(list.snippet.thumbnails?.default?.url.toString())
            binding.root.setOnClickListener {
                clickListener(list)
            }
        }

    }
}