package com.ripalay.youtubeapi.ui.ethernet

import android.content.Intent
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.ripalay.youtubeapi.core.ui.BaseActivity
import com.ripalay.youtubeapi.databinding.ActivityMainBinding
import com.ripalay.youtubeapi.ui.playlist.PlaylistActivity

class MainActivity : BaseActivity<EthernetViewModel, ActivityMainBinding>() {

    override fun inflateVB(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
        viewModel = ViewModelProvider(this).get(EthernetViewModel::class.java)
    }

    override fun initViewModel() {
        super.initViewModel()
            ethernetSuccsesfull()
    }


    override fun initListener() {
        super.initListener()
        binding.tryBtn.setOnClickListener {
            ethernetSuccsesfull()
        }
    }
    private fun ethernetSuccsesfull() {
        viewModel.isOnline(this).observe(this) {
            if (it) {
                val intent = Intent(this, PlaylistActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

}