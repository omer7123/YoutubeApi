package com.ripalay.youtubeapi.ui.detail

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.ripalay.youtubeapi.core.ui.BaseActivity
import com.ripalay.youtubeapi.databinding.ActivityDetailBinding
import com.ripalay.youtubeapi.extensions.showToast

class DetailActivity : BaseActivity<DetailViewModel, ActivityDetailBinding>() {
    override fun inflateVB(inflater: LayoutInflater): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

    }
    override fun initViewModel() {
        super.initViewModel()
        viewModel.getIntent(intent).observe(this){
            showToast(it)
        }
    }

    override fun initListener() {
        super.initListener()
        binding.backBtn.setOnClickListener {
            finish()
        }
    }


}