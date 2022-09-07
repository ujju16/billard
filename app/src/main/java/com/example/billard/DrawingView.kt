package com.example.billard

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceView
import java.util.*

class DrawingView @JvmOverloads constructor(context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0): SurfaceView(context, attributes, defStyleAttr){
    val backgroundPaint = Paint()
    val random = Random()
    val b1 = Balle(random.nextFloat() * 500, random.nextFloat() * 1000, random.nextFloat() * 500)
    val b2 = Balle(random.nextFloat() * 500, random.nextFloat() * 1000, random.nextFloat() * 500)
    val b3 = Balle(random.nextFloat() * 500, random.nextFloat() * 1000, random.nextFloat() * 500)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        backgroundPaint.color = Color.WHITE
        canvas?.drawRect(0F, 0F, width.toFloat(), height.toFloat(), backgroundPaint)

        b1.draw(canvas)
        b2.draw(canvas)
        b3.draw(canvas)
    }

    fun changeCouleur () {
        b1.changeCouleur()
        b2.changeCouleur()
        b3.changeCouleur()
    }
}