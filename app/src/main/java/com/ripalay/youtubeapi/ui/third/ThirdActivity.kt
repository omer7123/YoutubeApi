package com.ripalay.youtubeapi.ui.third

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.ripalay.youtubeapi.R
import com.ripalay.youtubeapi.`object`.Constant
import com.ripalay.youtubeapi.core.ui.BaseActivity
import com.ripalay.youtubeapi.databinding.ActivityThirdBinding
import com.ripalay.youtubeapi.extensions.showToast

class ThirdActivity : BaseActivity<ThirdViewModel, ActivityThirdBinding>() {
    override fun inflateVB(inflater: LayoutInflater): ActivityThirdBinding {
        return ActivityThirdBinding.inflate(layoutInflater)
    }

    override fun initViewModel() {
        super.initViewModel()
        showToast(intent.getStringExtra(Constant.ID).toString())
    }
}