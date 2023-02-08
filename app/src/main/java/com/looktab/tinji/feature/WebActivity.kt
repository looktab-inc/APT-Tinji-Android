package com.looktab.tinji.feature

import android.webkit.WebSettings
import com.looktab.tinji.R
import com.looktab.tinji.base.BaseActivity
import com.looktab.tinji.databinding.ActivityWebBinding


class WebActivity : BaseActivity<ActivityWebBinding>(R.layout.activity_web) {

    val url = "file:///android_asset/detail.html"

    override fun initViews() {
        val settings: WebSettings = binding.architectView.settings
        settings.allowFileAccess = true
        binding.architectView.settings.javaScriptEnabled = true
        binding.architectView.loadUrl(url)

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}