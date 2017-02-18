package org.bh.app.taskbarMediaButtons.ui.images

import org.bh.tools.base.math.geometry.*
import org.bh.tools.ui.swing.*
import java.awt.Color.white
import java.awt.Graphics
import java.awt.Image

/**
 * @author Ben Leggiero
 * @since 2017-02-17
 */
class PauseImage(override val size: FractionSize) : MediaButtonImage {
    override val awtValue: Image by lazy {
        val image = BufferedImage(size, BufferedImageType.argb)
        drawInGraphics(image.graphics)
        /*return*/image
    }


    private val leftRectMultiplier by lazy { FractionRect(x = 2.0/16.0, y = 2.0/16.0, width = 4.0/16.0, height = 12.0/16.0) }
    private val rightRectMultiplier by lazy { FractionRect(x = 10.0/16.0, y = 2.0/16.0, width = 4.0/16.0, height = 12.0/16.0) }


    override fun drawInGraphics(graphics: Graphics) {
        graphics.antiAlias = true
        graphics.color = white

        graphics.drawRect(leftRectMultiplier * size)
        graphics.drawRect(rightRectMultiplier * size)
    }
}
