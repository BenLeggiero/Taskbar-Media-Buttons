package org.bh.app.taskbarMediaButtons.ui.tray.buttons

import javafx.embed.swing.JFXPanel
import javafx.scene.control.ContextMenu
import javafx.scene.control.MenuItem
import org.bh.app.taskbarMediaButtons.ui.images.PauseImage
import org.bh.app.taskbarMediaButtons.ui.tray.SystemTrayButton
import org.bh.tools.base.math.geometry.*
import java.awt.Robot
import java.awt.TrayIcon
import java.awt.event.*
import java.awt.event.MouseEvent.BUTTON1
import java.awt.event.MouseEvent.BUTTON2

/**
 * @author Ben Leggiero
 * @since 2017-02-17
 */
class PauseTrayButton(size: FractionSize): SystemTrayButton {
    override val awtValue: TrayIcon by lazy { generateAwtTrayIcon() }

    override val image = PauseImage(size)

    private val robot: Robot = {
        val robot = Robot()
        robot.autoDelay = 50 // milliseconds
        /*return*/ robot
    }()


    private fun generateAwtTrayIcon(): TrayIcon {
        val icon = TrayIcon(image.awtValue)
        icon.addMouseListener(object: MouseAdapter() {
            override fun mouseClicked(e: MouseEvent?) {
                when (e?.button) {
                    BUTTON1 -> performAction()
                    BUTTON2 -> showMenu(e.locationOnScreen.fractionValue)
                }
            }
        })
        icon.toolTip = "Pause media"
        return icon
    }

    val menu by lazy {
        JFXPanel().toolkit.beep()
        val menu = ContextMenu()
        menu.items.add(MenuItem("Test"))
        menu
    }

    fun showMenu(location: FractionPoint) {
        menu.show(JFXPanel().scene?.window, location.x, location.y)
    }


    fun performAction() {
        robot.keyPress(KeyEvent.VK_WINDOWS)
        robot.keyRelease(KeyEvent.VK_WINDOWS)
    }
}