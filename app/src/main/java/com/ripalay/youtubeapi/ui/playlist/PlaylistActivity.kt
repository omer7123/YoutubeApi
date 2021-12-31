package com.ripalay.youtubeapi.ui.playlist

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.ripalay.youtubeapi.base.BaseActivity
import com.ripalay.youtubeapi.databinding.ActivityPlaylistBinding
import com.ripalay.youtubeapi.model.Playlist
import com.ripalay.youtubeapi.ui.detail.DetailActivity
import com.ripalay.youtubeapi.ui.ethernet.MainActivity

class PlaylistActivity : BaseActivity<PlaylistViewModel, ActivityPlaylistBinding>() {
    private lateinit var playlist: Playlist
    private lateinit var adapter: PlaylistAdapter

    override fun inflateVB(inflater: LayoutInflater): ActivityPlaylistBinding {

        return ActivityPlaylistBinding.inflate(layoutInflater)
    }
    override fun initView() {
        super.initView()
        viewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)

    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.getPlayList().observe(this) {
            playlist = it
            adapter = PlaylistAdapter(playlist.items)
            binding.rv.adapter = adapter
            val intent = Intent(this, DetailActivity::class.java)
            adapter.setOnItem(object : PlaylistAdapter.onClick {
                override fun onItem(position: Int) {
                    intent.putExtra(
                        "ID", playlist.items[position].id
                    )
                    startActivity(intent)
                }

            })

        }
    }


}