package com.ripalay.youtubeapi.ui.detail

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.ripalay.youtubeapi.`object`.Constant
import com.ripalay.youtubeapi.core.ui.BaseActivity
import com.ripalay.youtubeapi.data.remote.model.Playlist
import com.ripalay.youtubeapi.databinding.ActivityDetailBinding
import com.ripalay.youtubeapi.extensions.showToast

class DetailActivity : BaseActivity<DetailViewModel, ActivityDetailBinding>() {

    private lateinit var item: Playlist
    private lateinit var adapter: DetailAdapter
    override fun inflateVB(inflater: LayoutInflater): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.getPlay(intent.getStringExtra(Constant.ID)).observe(this) {
            item = it
            binding.titleTv.text = intent.getStringExtra(Constant.TITLE)
            binding.seriesTv.text = (item.pageInfo.totalResults + " video series")
            adapter = DetailAdapter(item.items)
            binding.seriesRv.adapter = adapter
        }

    }

    override fun initListener() {
        super.initListener()
        binding.backBtn.setOnClickListener {
            finish()
        }
    }


}