package org.bh.app.taskbarMediaButtons.ui.tray

import org.bh.app.taskbarMediaButtons.ui.tray.SystemTrayButton

/**
 * @author Ben Leggiero
 * @since 2017-02-17
 */
class SystemTray {
    companion object {
        val shared = SystemTray()
    }


    val awtValue: java.awt.SystemTray by lazy { java.awt.SystemTray.getSystemTray() }


    fun addIcons(systemTrayIcons: Iterable<SystemTrayButton>) {
        systemTrayIcons.forEach { addIcon(it) }
    }


    fun addIcon(systemTrayButton: SystemTrayButton) {
        awtValue.add(systemTrayButton.awtValue)
    }
}