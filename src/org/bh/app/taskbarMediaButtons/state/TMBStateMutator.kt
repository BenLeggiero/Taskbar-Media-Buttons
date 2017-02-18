package org.bh.app.taskbarMediaButtons.state

import org.bh.app.taskbarMediaButtons.ui.tray.SystemTrayButton
import org.bh.tools.base.state.StateMutator
import org.bh.tools.io.logging.log

/**
 * @author Ben Leggiero
 * @since 2017-02-17
 */
class TMBStateMutator: StateMutator<TMBState, TMBStateMutation, TMBStateChange> {
    override fun mutating(state: TMBState, action: TMBStateMutation): TMBStateChange {
        return when (action) {
            is TMBStateMutation.addNewTrayIcon -> TMBStateChange(systemTrayButtons = state.systemTrayIcons + action.newButton)
            is TMBStateMutation.removeTrayIcon -> TMBStateChange(systemTrayButtons = state.systemTrayIcons - action.dirtyButton)

            is TMBStateMutation.setDebugMode -> {
                log.info("Debug mode set to ${action.newDebugMode}")
                TMBStateChange(isDebugMode = action.newDebugMode)
            }
        }
    }
}



sealed class TMBStateMutation {
    class addNewTrayIcon(val newButton: SystemTrayButton): TMBStateMutation()
    class removeTrayIcon(val dirtyButton: SystemTrayButton): TMBStateMutation()
    class setDebugMode(val newDebugMode: Boolean): TMBStateMutation()

    companion object {
        val enableDebugMode = setDebugMode(true)
        val disableDebugMode = setDebugMode(false)
    }
}
