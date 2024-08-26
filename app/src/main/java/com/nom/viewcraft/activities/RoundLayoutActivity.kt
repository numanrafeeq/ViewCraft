package com.nom.viewcraft.activities

import android.graphics.Color
import android.os.Bundle
import com.app.corekit.base.BaseActivity
import com.nom.viewcraft.databinding.ActivityRoundLayoutBinding

class RoundLayoutActivity : BaseActivity<ActivityRoundLayoutBinding>(ActivityRoundLayoutBinding::inflate) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initComponents()

    }

    private fun initComponents() {

        initClicks()
    }

    private fun initClicks() {
        val checkableLayout = binding.checkableRoundCornerLayout



        binding.btnSetStrokeColor.setOnClickListener {
            checkableLayout.setStrokeColor(Color.RED)
        }

        binding.btnSetStrokeWidth.setOnClickListener {
            checkableLayout.setStrokeWidth(10F)
        }

        binding.btnSetCornerRadius.setOnClickListener {
            checkableLayout.setCornerRadius(50F)
        }

        binding.btnSetIndividualCornerRadii.setOnClickListener {
            checkableLayout.setIndividualCornerRadii(50F, 0F, 0F, 0F)
        }

        binding.btnSetRoundAsCircle.setOnClickListener {
            checkableLayout.setCircular(true)
        }
        binding.btnRest.setOnClickListener {
            checkableLayout.reset()
        }

    }
}