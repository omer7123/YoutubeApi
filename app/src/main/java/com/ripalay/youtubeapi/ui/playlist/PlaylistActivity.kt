package com.ripalay.youtubeapi.ui.playlist

import android.content.Intent
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.ripalay.youtubeapi.`object`.Constant
import com.ripalay.youtubeapi.core.network.result.Status
import com.ripalay.youtubeapi.core.ui.BaseActivity
import com.ripalay.youtubeapi.data.local.AppPrefs
import com.ripalay.youtubeapi.data.remote.model.Items
import com.ripalay.youtubeapi.databinding.ActivityPlaylistBinding
import com.ripalay.youtubeapi.data.remote.model.Playlist
import com.ripalay.youtubeapi.ui.detail.DetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaylistActivity : BaseActivity<PlaylistViewModel, ActivityPlaylistBinding>() {
    private lateinit var playlist: Playlist
    private lateinit var adapter: PlaylistAdapter

    override val viewModel: PlaylistViewModel by viewModel()

    override fun inflateVB(inflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
        AppPrefs(this).isOnBoard = true
        AppPrefs(this).isOnBoard.toString()
    }

    override fun initViewModel() {
        super.initViewModel()

        viewModel.loading.observe(this) {
            binding.progress.isVisible = it
        }

        viewModel.getPlayList().observe(this) {
            when (it.status) {
                Status.LOADING -> viewModel.loading.postValue(true)
                Status.SUCCESS -> {
                    viewModel.loading.postValue(false)
                    playlist = it.data!!
                    adapter = PlaylistAdapter(playlist.items, this::clickListener)
                    binding.rv.adapter = adapter


                }
                Status.ERROR -> viewModel.loading.postValue(false)
            }
        }
    }

    private fun clickListener(items: Items) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(
            Constant.ID, items.id,
        )
        intent.putExtra(Constant.TITLE, items.snippet.title)
        startActivity(intent)

    }


}