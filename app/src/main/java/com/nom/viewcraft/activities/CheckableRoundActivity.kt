package com.nom.viewcraft.activities

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.app.corekit.base.BaseActivity
import com.nom.viewcraft.databinding.ActivityCheckableLayoutBinding
import com.nom.viewcraft.databinding.ActivityCheckableRoundBinding
import com.nom.viewcraft.views.CheckableFrameLayout
import com.nom.viewcraft.views.CheckableRoundLayout

class CheckableRoundActivity : BaseActivity<ActivityCheckableRoundBinding>(ActivityCheckableRoundBinding::inflate) {

    private lateinit var checkableFrameLayout: CheckableRoundLayout
    private lateinit var tvCheckState: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initComponents()

    }

    private fun initComponents() {

        checkableFrameLayout = binding.checkableFrameLayout
        tvCheckState = binding.tvCheckState


        // Set an OnCheckedChangeListener to update the TextView when the state changes
        checkableFrameLayout.setOnCheckedChangeListener(object : CheckableRoundLayout.OnCheckedChangeListener {
            override fun onCheckedChanged(view: View, isChecked: Boolean) {
                updateCheckStateText(isChecked)
            }
        })


        binding.checkableFrameLayout.setOnClickListener {
            checkableFrameLayout.toggle()
        }


        // Initialize The Check State Display
        updateCheckStateText(checkableFrameLayout.isChecked)

    }

    private fun updateCheckStateText(isChecked: Boolean) {

        if (isChecked){
            checkableFrameLayout.setStrokeColor(Color.RED)
            checkableFrameLayout.setStrokeWidth(10F)
        }else{
            checkableFrameLayout.setStrokeColor(Color.RED)
            checkableFrameLayout.setStrokeWidth(0F)
        }

        val stateText = if (isChecked) "Checked" else "Unchecked"
        tvCheckState.text = "Current State: $stateText"
    }

}