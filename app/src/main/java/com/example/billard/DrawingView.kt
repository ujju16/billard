package com.example.billard

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceView
import java.util.*

class DrawingView @JvmOverloads constructor(context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0): SurfaceView(context, attributes, defStyleAttr), Runnable {

    val backgroundPaint = Paint()
    val random = Random()
    lateinit var thread: Thread
    var drawing = true
    lateinit var canvas: Canvas
    val b1 = Balle(random.nextFloat() * 500, random.nextFloat() * 1000, random.nextFloat() * 500)
    val b2 = Balle(random.nextFloat() * 500, random.nextFloat() * 1000, random.nextFloat() * 500)
    val b3 = Balle(random.nextFloat() * 500, random.nextFloat() * 1000, random.nextFloat() * 500)

    fun changeCouleur () {
        b1.changeCouleur()
        b2.changeCouleur()
        b3.changeCouleur()
    }

    fun pause() {
        drawing = false
        thread.join()
    }

    fun resume() {
        drawing = true
        thread = Thread(this)
        thread.start()
        thread.stop()
    }

    fun draw() {
        if (holder.surface.isValid) {
            canvas = holder.lockCanvas()
            backgroundPaint.color = Color.WHITE
            canvas.drawRect(0F, 0F, canvas.width * 1F, canvas.height * 1F, backgroundPaint)
            b1.bouge(canvas)
            holder.unlockCanvasAndPost(canvas)
        }
    }

    override fun run() {
        while (drawing) {
            draw()
        }
    }
}