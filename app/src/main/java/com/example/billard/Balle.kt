package com.example.billard

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import java.util.*

class Balle(x1: Float, y1: Float, val diametre: Float) {
    fun draw(canvas: Canvas?) {
        paint.color = color
        canvas?.drawOval(r, paint)
    }

    val random = Random()
    val paint = Paint()
    val r = RectF(x1, y1, x1 + diametre, y1 + diametre)
    val color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
}