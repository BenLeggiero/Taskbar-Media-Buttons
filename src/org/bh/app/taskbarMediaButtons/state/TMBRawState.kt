package org.bh.app.taskbarMediaButtons.state

import org.bh.app.taskbarMediaButtons.ui.tray.SystemTrayButton
import org.bh.tools.base.struct.Data

/**
 * @author Ben Leggiero
 * @since 2017-02-16
 */
data class TMBRawState(
        val systemTrayButtons: List<SystemTrayButton>,
        val isDebugMode: Boolean
): Data {
    companion object
}