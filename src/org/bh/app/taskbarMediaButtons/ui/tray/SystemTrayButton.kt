package org.bh.app.taskbarMediaButtons.ui.tray

import org.bh.app.taskbarMediaButtons.ui.images.MediaButtonImage
import java.awt.TrayIcon

/**
 * @author Ben Leggiero
 * @since 2017-02-16
 */
interface SystemTrayButton {
    val awtValue: TrayIcon

    val image: MediaButtonImage
}



class BasicSystemTrayButton // TODO
