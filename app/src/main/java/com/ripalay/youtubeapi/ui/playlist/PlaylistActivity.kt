package com.ripalay.youtubeapi.ui.playlist

import android.content.Intent
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.ripalay.youtubeapi.`object`.Constant
import com.ripalay.youtubeapi.core.ui.BaseActivity
import com.ripalay.youtubeapi.data.local.AppPrefs
import com.ripalay.youtubeapi.databinding.ActivityPlaylistBinding
import com.ripalay.youtubeapi.data.remote.model.Playlist
import com.ripalay.youtubeapi.repository.Repository
import com.ripalay.youtubeapi.ui.detail.DetailActivity

class PlaylistActivity : BaseActivity<PlaylistViewModel, ActivityPlaylistBinding>() {
    private lateinit var playlist: Playlist
    private lateinit var adapter: PlaylistAdapter

    override fun inflateVB(inflater: LayoutInflater): ActivityPlaylistBinding {

        return ActivityPlaylistBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
        viewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)

        AppPrefs(this).isOnBoard = true

        AppPrefs(this).isOnBoard.toString()
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
                        Constant.ID, playlist.items[position].id,
                    )
                    intent.putExtra(Constant.TITLE, playlist.items[position].snippet.title)
                    startActivity(intent)
                }
            })
        }
    }


}