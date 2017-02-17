package org.bh.app.taskbarMediaButtons.ui

/**
 * @author Ben Leggiero
 * @since 2017-02-17
 */
class SystemTray {
    companion object {
        val shared = SystemTray()
    }


    val awtValue: java.awt.SystemTray by lazy { java.awt.SystemTray.getSystemTray() }


    fun addIcons(systemTrayIcons: Iterable<SystemTrayIcon>) {
        systemTrayIcons.forEach { addIcon(it) }
    }


    fun addIcon(systemTrayIcon: SystemTrayIcon) {
        awtValue.add(systemTrayIcon.awtValue)
    }
}