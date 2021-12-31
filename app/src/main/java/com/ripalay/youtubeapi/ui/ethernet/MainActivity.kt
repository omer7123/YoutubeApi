package com.ripalay.youtubeapi.ui.ethernet

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.ripalay.youtubeapi.R
import com.ripalay.youtubeapi.base.BaseActivity
import com.ripalay.youtubeapi.databinding.ActivityMainBinding
import com.ripalay.youtubeapi.ui.playlist.PlaylistActivity
import java.net.InetAddress

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