package com.ripalay.youtubeapi.ui.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ripalay.youtubeapi.databinding.ItemPlaylistBinding
import com.ripalay.youtubeapi.extensions.load
import com.ripalay.youtubeapi.data.remote.model.Items

class PlaylistAdapter(
    private val playlist: List<Items>,
    private val clickListener: (item: Items) -> Unit
) :
    RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(playlist[position])
    }

    override fun getItemCount(): Int {
        return playlist.size
    }


    inner class ViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(playlist: Items) {
            binding.numberTv.text =
                (playlist.contentDetails?.itemCount.toString() + " видео в плейлисте")
            binding.avaIv.load(playlist.snippet.thumbnails?.default?.url.toString())
            binding.titleTv.text = playlist.snippet.title
            binding.root.setOnClickListener {
                clickListener(playlist)
            }

        }
    }


}