package com.nom.viewcraft.activities

import android.os.Bundle
import android.widget.Toast
import com.app.corekit.base.BaseActivity
import com.nom.viewcraft.databinding.ActivityLayoutSliderBinding
import com.nom.viewcraft.databinding.LayoutSliderOneBinding
import com.nom.viewcraft.databinding.LayoutSliderThreeBinding
import com.nom.viewcraft.databinding.LayoutSliderTwoBinding


class LayoutSliderActivity : BaseActivity<ActivityLayoutSliderBinding>(ActivityLayoutSliderBinding::inflate) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initComponents()

    }

    private fun initComponents() {

        initClicks()
    }

    private fun initClicks() {

        // Initialize the LayoutSlider with TabLayout
        val layoutSlider = binding.layoutSlider
        layoutSlider.setTabLayout(binding.tabLayout)

        // Add layouts to the LayoutSlider
        layoutSlider.addLayout(0, LayoutSliderOneBinding.inflate(layoutInflater), "Tab 1")
        layoutSlider.addLayout(1, LayoutSliderTwoBinding.inflate(layoutInflater), "Tab 2")
        layoutSlider.addLayout(2, LayoutSliderThreeBinding.inflate(layoutInflater), "Tab 3")

        // Optionally set the initial layout to be shown
        layoutSlider.setInitialLayout(0)

        val layoutSliderOneBinding = layoutSlider.getBinding(0) as LayoutSliderOneBinding

        layoutSliderOneBinding.btnShowToast.setOnClickListener {
            Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
        }

    }
}