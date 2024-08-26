package com.nom.viewcraft.views

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.viewbinding.ViewBinding
import com.google.android.material.tabs.TabLayout

class LayoutSlider @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private lateinit var tabLayout: TabLayout
    private val bindingMap = mutableMapOf<Int, ViewBinding>()
    private var currentTabIndex = 0

    fun setTabLayout(tabLayout: TabLayout) {
        this.tabLayout = tabLayout

        // Set tab selected listener
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                showLayout(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    fun addLayout(tabIndex: Int, binding: ViewBinding, tabTitle: String) {
        bindingMap[tabIndex] = binding
        tabLayout.addTab(tabLayout.newTab().setText(tabTitle))

        // Show the initial layout if it's the first one
        if (tabIndex == currentTabIndex) {
            showLayout(tabIndex)
        }
    }

    fun setInitialLayout(tabIndex: Int) {
        currentTabIndex = tabIndex
        showLayout(tabIndex)
        tabLayout.selectTab(tabLayout.getTabAt(tabIndex))
    }

    fun getBinding(tabIndex: Int): ViewBinding? {
        return bindingMap[tabIndex]
    }

    private fun showLayout(tabIndex: Int) {
        val currentView = getChildAt(0)
        val newView = bindingMap[tabIndex]?.root

        newView?.let {
            removeAllViews()

            // Add the new view
            addView(newView)

            // Setting up the initial position for animation
            newView.translationX = width.toFloat()

            // Animate the current view out
            currentView?.animate()?.translationX(-width.toFloat())?.setDuration(300)?.start()

            // Animate the new view in
            newView.animate().translationX(0f).setDuration(300).start()
        }

        currentTabIndex = tabIndex
    }
}

