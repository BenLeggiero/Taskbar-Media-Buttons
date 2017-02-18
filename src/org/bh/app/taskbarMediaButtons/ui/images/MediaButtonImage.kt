package org.bh.app.taskbarMediaButtons.ui.images

import org.bh.tools.base.math.geometry.FractionSize
import java.awt.Graphics

/**
 * @author Ben Leggiero
 * @since 2017-02-17
 */
interface MediaButtonImage {
    val size: FractionSize
    val awtValue: java.awt.Image
//    val swingValue: javax.swing.ImageIcon

    fun drawInGraphics(graphics: Graphics)
}