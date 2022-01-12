package com.ripalay.youtubeapi.ui.third

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ExoPlayerLibraryInfo
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.ripalay.youtubeapi.R
import com.ripalay.youtubeapi.`object`.Constant
import com.ripalay.youtubeapi.core.network.result.Status
import com.ripalay.youtubeapi.core.ui.BaseActivity
import com.ripalay.youtubeapi.data.remote.model.Playlist
import com.ripalay.youtubeapi.databinding.ActivityThirdBinding
import com.ripalay.youtubeapi.extensions.showToast
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class ThirdActivity : BaseActivity<ThirdViewModel, ActivityThirdBinding>() {
    private lateinit var video: Playlist
    private lateinit var videoURL: String
    private var mPlayer: ExoPlayer? = null
    override fun inflateVB(inflater: LayoutInflater): ActivityThirdBinding {
        return ActivityThirdBinding.inflate(layoutInflater)
    }

    override val viewModel: ThirdViewModel by viewModel()
    override fun onStart() {
        super.onStart()
        initPlayer()
    }

    override fun onPause() {
        super.onPause()
        mPlayer?.stop()
    }
    override fun initViewModel() {
        super.initViewModel()
        showToast(intent.getStringExtra(Constant.ID).toString())
        Log.e("ololo", intent.getStringExtra(Constant.ID).toString())
        videoURL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    }

    override fun initView() {
        super.initView()
        viewModel.getVideo(intent.getStringExtra(Constant.ID).toString()).observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    video = it.data!!
                    binding.titleTv.text = video.items[0].snippet.title
                    binding.descriveTv.text = video.items[0].snippet.description
                }
            }
        }
    }
    private fun buildMediaSource(): MediaSource {
        val dataSourceFactory: DataSource.Factory = DefaultHttpDataSource.Factory()
        val mediaSource: MediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(videoURL))
        return mediaSource
    }
    fun initPlayer(){
        mPlayer = ExoPlayer.Builder(this).build()
        binding.avaIv.player = mPlayer
        mPlayer!!.playWhenReady = true
        mPlayer!!.setMediaSource(buildMediaSource())
        mPlayer!!.prepare()
    }
}