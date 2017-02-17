package org.bh.app.taskbarMediaButtons.launch

import org.bh.app.taskbarMediaButtons.Constants
import org.bh.app.taskbarMediaButtons.state.TMBStateController
import org.bh.app.taskbarMediaButtons.ui.images.PauseImage
import org.bh.tools.base.collections.count
import org.bh.tools.base.math.geometry.FractionSize
import org.bh.tools.io.logging.log
import java.awt.*
import javax.swing.JOptionPane


/**
 * @author Ben Leggiero
 * @since 2017-02-16 016.
 */
class AppDelegate {
    fun start(args: Array<String>) {
        if (!SystemTray.isSupported()) {
            val message = "${Constants.appName} is not supported on your computer."
            log.severe(message)
            JOptionPane.showMessageDialog(null, message, Constants.appName, JOptionPane.ERROR_MESSAGE)
            System.exit(0)
            return
        }

        CommandLineArgumentProcessor.process(args)

        TMBStateController.shared {
            val icons = currentState().systemTrayIcons
            if (icons.count < 1) {
                showPreferencesPane()
            }
            org.bh.app.taskbarMediaButtons.ui.SystemTray.shared.addIcons(icons)
        }
    }


    fun showPreferencesPane() {
        JOptionPane.showMessageDialog(null, "Preferences will go here one day", Constants.appName, JOptionPane.ERROR_MESSAGE)
    }


    private fun showDebugDialog() {
        javax.swing.JOptionPane.showConfirmDialog(null, "Did it work?")
    }


    private fun addTestIcons() {

        //Check the SystemTray is supported
        if (!SystemTray.isSupported()) {
            println("SystemTray is not supported")
            return
        }
        val popup = PopupMenu()
        val trayIcon = TrayIcon(PauseImage(FractionSize(16)).awtValue)
        val tray = SystemTray.getSystemTray()

        // Create a pop-up menu components
        val aboutItem = MenuItem("About")
        val cb1 = CheckboxMenuItem("Set auto size")
        val cb2 = CheckboxMenuItem("Set tooltip")
        val displayMenu = Menu("Display")
        val errorItem = MenuItem("Error")
        val warningItem = MenuItem("Warning")
        val infoItem = MenuItem("Info")
        val noneItem = MenuItem("None")
        val exitItem = MenuItem("Exit")
        exitItem.addActionListener {
            System.exit(0)
        }

        //Add components to pop-up menu
        popup.add(aboutItem)
        popup.addSeparator()
        popup.add(cb1)
        popup.add(cb2)
        popup.addSeparator()
        popup.add(displayMenu)
        displayMenu.add(errorItem)
        displayMenu.add(warningItem)
        displayMenu.add(infoItem)
        displayMenu.add(noneItem)
        popup.add(exitItem)

        trayIcon.popupMenu = popup

        try {
            tray.add(trayIcon)
        } catch (e: AWTException) {
            println("TrayIcon could not be added.")
        }

    }
}