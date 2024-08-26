package com.nom.viewcraft.activities

import android.content.Intent
import android.os.Bundle
import com.app.corekit.base.BaseActivity
import com.nom.viewcraft.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initComponents()

    }

    private fun initComponents() {

        initClicks()
    }

    private fun initClicks() {

        binding.btnLayoutSlider.setOnClickListener {
            startActivity(Intent(this@MainActivity, LayoutSliderActivity::class.java))
        }
    }
}