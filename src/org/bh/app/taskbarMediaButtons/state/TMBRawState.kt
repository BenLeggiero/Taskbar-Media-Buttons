package org.bh.app.taskbarMediaButtons.state

import org.bh.app.taskbarMediaButtons.ui.SystemTrayIcon
import org.bh.tools.base.struct.Data

/**
 * @author Ben Leggiero
 * @since 2017-02-16
 */
data class TMBRawState(
        val systemTrayIcons: List<SystemTrayIcon>,
        val isDebugMode: Boolean
): Data {
    companion object
}