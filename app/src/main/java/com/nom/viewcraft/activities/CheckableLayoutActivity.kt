package com.nom.viewcraft.activities

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.app.corekit.base.BaseActivity
import com.nom.viewcraft.databinding.ActivityCheckableLayoutBinding
import com.nom.viewcraft.views.CheckableFrameLayout

class CheckableLayoutActivity : BaseActivity<ActivityCheckableLayoutBinding>(ActivityCheckableLayoutBinding::inflate) {

    private lateinit var checkableFrameLayout: CheckableFrameLayout
    private lateinit var tvCheckState: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initComponents()

    }

    private fun initComponents() {

        checkableFrameLayout = binding.checkableFrameLayout
        tvCheckState = binding.tvCheckState


        // Set an OnCheckedChangeListener to update the TextView when the state changes
        checkableFrameLayout.setOnCheckedChangeListener(object : CheckableFrameLayout.OnCheckedChangeListener {
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
        val stateText = if (isChecked) "Checked" else "Unchecked"
        tvCheckState.text = "Current State: $stateText"
    }

}