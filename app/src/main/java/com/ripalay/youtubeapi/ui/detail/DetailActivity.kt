package com.ripalay.youtubeapi.ui.detail

import android.content.Intent
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.ripalay.youtubeapi.`object`.Constant
import com.ripalay.youtubeapi.core.network.result.Status
import com.ripalay.youtubeapi.core.ui.BaseActivity
import com.ripalay.youtubeapi.data.remote.model.Items
import com.ripalay.youtubeapi.data.remote.model.Playlist
import com.ripalay.youtubeapi.databinding.ActivityDetailBinding
import com.ripalay.youtubeapi.extensions.showToast
import com.ripalay.youtubeapi.ui.third.ThirdActivity

class DetailActivity : BaseActivity<DetailViewModel, ActivityDetailBinding>() {
    private lateinit var item: Playlist
    private lateinit var adapter: DetailAdapter
    override fun inflateVB(inflater: LayoutInflater): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.loading.observe(this) {
            binding.progress.isVisible = it
        }

    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.getPlay(intent.getStringExtra(Constant.ID)).observe(this) {
            when (it.status) {
                Status.LOADING -> viewModel.loading.postValue(true)
                Status.SUCCESS -> {
                    item = it.data!!
                    setInfo(item)
                    initAdapter(item)
                }

            }

        }

    }

    private fun initAdapter(item: Playlist) {
        adapter = DetailAdapter(item.items, this::clickListener)
        binding.seriesRv.adapter = adapter
    }

    private fun setInfo(item: Playlist) {
        viewModel.loading.postValue(false)
        binding.titleTv.text = intent.getStringExtra(Constant.TITLE)
        binding.seriesTv.text = (item.pageInfo.totalResults + " video series")
    }

    private fun clickListener(item: Items) {
        val intent = Intent(this, ThirdActivity::class.java)
        intent.putExtra(Constant.ID, item.id)
        startActivity(intent)
    }

    override fun initListener() {
        super.initListener()
        binding.backBtn.setOnClickListener {
            finish()
        }
        binding.fabBtn.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra(Constant.ID, item.items[0].id)
            startActivity(intent)
        }
    }


}