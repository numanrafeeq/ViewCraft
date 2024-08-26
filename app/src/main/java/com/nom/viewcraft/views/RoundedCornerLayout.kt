package com.nom.viewcraft.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.nom.viewcraft.R

open class RoundedCornerLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val rect = RectF()
    private var cornerRadius = 0f
    private var strokeWidth = 0f
    private var strokeColor = ContextCompat.getColor(context, android.R.color.transparent)
    private var topLeftRadius = 0f
    private var topRightRadius = 0f
    private var bottomLeftRadius = 0f
    private var bottomRightRadius = 0f
    private var isCircular = false


    init {
        setWillNotDraw(false)
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.RoundedCornerLayout,
            0, 0
        ).apply {
            try {
                cornerRadius = getDimension(R.styleable.RoundedCornerLayout_cornerRadius, 0f)
                strokeWidth = getDimension(R.styleable.RoundedCornerLayout_strokeWidth, 0f)
                strokeColor = getColor(R.styleable.RoundedCornerLayout_strokeColor, strokeColor)
                topLeftRadius = getDimension(R.styleable.RoundedCornerLayout_topLeftRadius, cornerRadius)
                topRightRadius = getDimension(R.styleable.RoundedCornerLayout_topRightRadius, cornerRadius)
                bottomLeftRadius = getDimension(R.styleable.RoundedCornerLayout_bottomLeftRadius, cornerRadius)
                bottomRightRadius = getDimension(R.styleable.RoundedCornerLayout_bottomRightRadius, cornerRadius)
                isCircular = getBoolean(R.styleable.RoundedCornerLayout_isCircular, false)
            } finally {
                recycle()
            }
        }
    }

    override fun dispatchDraw(canvas: Canvas) {
        rect.set(0f, 0f, width.toFloat(), height.toFloat())

        val path = Path()

        if (isCircular) {

            val radius = width.coerceAtMost(height) / 2f
            path.addCircle(width / 2f, height / 2f, radius, Path.Direction.CW)

        } else {

            val radii = floatArrayOf(
                topLeftRadius, topLeftRadius,  // Top left
                topRightRadius, topRightRadius,  // Top right
                bottomRightRadius, bottomRightRadius,  // Bottom right
                bottomLeftRadius, bottomLeftRadius   // Bottom left
            )

            path.addRoundRect(rect, radii, Path.Direction.CW)

        }

        canvas.clipPath(path)

        // Draw child views
        super.dispatchDraw(canvas)

        if (isCircular) {
            // Draw stroke
            val radius = width.coerceAtMost(height) / 2f
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = strokeWidth
            paint.color = strokeColor
            canvas.drawCircle(width / 2f, height / 2f, radius, paint)
        } else {
            // Draw stroke
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = strokeWidth
            paint.color = strokeColor
            canvas.drawRoundRect(rect, cornerRadius, cornerRadius, paint)
        }

    }

    fun setCornerRadius(radius: Float) {
        this.cornerRadius = radius
        this.topLeftRadius = cornerRadius
        this.topRightRadius = cornerRadius
        this.bottomRightRadius = cornerRadius
        this.bottomLeftRadius = cornerRadius
        invalidate()
    }


    fun setIndividualCornerRadii(topLeft: Float, topRight: Float, bottomRight: Float, bottomLeft: Float) {
        cornerRadius = 0f
        this.topLeftRadius = topLeft
        this.topRightRadius = topRight
        this.bottomRightRadius = bottomRight
        this.bottomLeftRadius = bottomLeft
        invalidate()
    }


    fun setStrokeWidth(width: Float) {
        this.strokeWidth = width
        invalidate()
    }

    fun setStrokeColor(color: Int) {
        this.strokeColor = color
        invalidate()
    }

    fun setCircular(isCircular: Boolean) {
        this.isCircular = isCircular
        invalidate()
    }

    fun reset() {
        cornerRadius = 0f
        strokeWidth = 0f
        strokeColor = ContextCompat.getColor(context, android.R.color.transparent)
        topLeftRadius = 0f
        topRightRadius = 0f
        bottomLeftRadius = 0f
        bottomRightRadius = 0f
        isCircular = false
        invalidate()
    }


}