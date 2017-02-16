package org.bh.app.taskbarMediaButtons.state

import org.bh.app.taskbarMediaButtons.ui.SystemTrayIcon
import org.bh.tools.base.struct.Data

/**
 * @author Kyli Rouge
 * @since 2017-02-16
 */
data class TMBState(val selectedIcons: List<SystemTrayIcon>): Data {
}