package com.nom.viewcraft.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Checkable
import android.widget.FrameLayout

class CheckableRoundLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RoundedCornerLayout(context, attrs, defStyleAttr), Checkable {

    private var isChecked = false
    private var onCheckedChangeListener: OnCheckedChangeListener? = null

    override fun isChecked(): Boolean {
        return isChecked
    }

    override fun toggle() {
        isChecked = !isChecked
        updateCheckedState()
    }

    override fun setChecked(checked: Boolean) {
        if (isChecked != checked) {
            isChecked = checked
            updateCheckedState()
        }
    }

    private fun updateCheckedState() {
        // Update the view state here (e.g., change background color, etc.)
        refreshDrawableState()
        onCheckedChangeListener?.onCheckedChanged(this, isChecked)

    }

    fun setOnCheckedChangeListener(listener: OnCheckedChangeListener?) {
        onCheckedChangeListener = listener
    }


    interface OnCheckedChangeListener {
        fun onCheckedChanged(view: View, isChecked: Boolean)

    }

}
