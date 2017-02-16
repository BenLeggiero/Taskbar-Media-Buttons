package org.bh.app.taskbarMediaButtons.launch

import com.sun.deploy.uitoolkit.impl.awt.Applet2ImageFactory.createImage
import java.awt.*


/**
 * @author Kyli Rouge
 * @since 2017-02-16 016.
 */
class AppDelegate {
    fun start() {
        addTestIcons()
        showDebugDialog()
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
        val trayIcon = TrayIcon(null)
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