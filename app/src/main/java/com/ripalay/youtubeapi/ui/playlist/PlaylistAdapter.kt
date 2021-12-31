package com.ripalay.youtubeapi.ui.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ripalay.youtubeapi.databinding.ItemPlaylistBinding
import com.ripalay.youtubeapi.extensions.load
import com.ripalay.youtubeapi.model.Items
import com.ripalay.youtubeapi.model.Playlist

class PlaylistAdapter(private val playlist: List<Items>) :
    RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {
private lateinit var mListener: onClick

    fun setOnItem(listener: onClick){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(playlist[position])
    }

    override fun getItemCount(): Int {
        return playlist.size
    }


    class ViewHolder(private val binding: ItemPlaylistBinding, listener: onClick) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(playlist: Items) {
            binding.numberTv.text =
                (playlist.contentDetails?.itemCount.toString() + " видео в плейлисте")
            binding.avaIv.load(playlist.snippet.thumbnails?.default?.url.toString())
            binding.titleTv.text = playlist.snippet.title

        }
        init {
            itemView.setOnClickListener {
                listener.onItem(adapterPosition)
            }
        }

    }

    interface onClick {
        fun onItem(position: Int)
    }
}