package com.nom.viewcraft.activities

import android.content.Intent
import android.os.Bundle
import com.app.corekit.base.BaseActivity
import com.nom.viewcraft.databinding.ActivityMainBinding
import com.nom.viewcraft.views.CheckableRoundLayout

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

        binding.btnRoundCornerLayout.setOnClickListener {
            startActivity(Intent(this@MainActivity, RoundLayoutActivity::class.java))
        }

        binding.btnCheckableLayout.setOnClickListener {
            startActivity(Intent(this@MainActivity, CheckableLayoutActivity::class.java))
        }
        binding.btnCheckableRound.setOnClickListener {
            startActivity(Intent(this@MainActivity, CheckableRoundActivity::class.java))
        }

    }
}