package org.bh.app.taskbarMediaButtons.state

import org.bh.app.taskbarMediaButtons.ui.SystemTrayIcon
import org.bh.tools.base.state.StateMutator

/**
 * @author Ben Leggiero
 * @since 2017-02-17
 */
class TMBStateMutator: StateMutator<TMBState, TMBStateMutation, TMBStateChange> {
    override fun mutating(state: TMBState, action: TMBStateMutation): TMBStateChange {
        return when (action) {
            is TMBStateMutation.addNewTrayIcon -> TMBStateChange(systemTrayIcons = state.systemTrayIcons + action.newIcon)
            is TMBStateMutation.removeTrayIcon -> TMBStateChange(systemTrayIcons = state.systemTrayIcons - action.dirtyIcon)

            is TMBStateMutation.setDebugMode -> TMBStateChange(isDebugMode = action.newDebugMode)
        }
    }
}



sealed class TMBStateMutation {
    class addNewTrayIcon(val newIcon: SystemTrayIcon): TMBStateMutation()
    class removeTrayIcon(val dirtyIcon: SystemTrayIcon): TMBStateMutation()
    class setDebugMode(val newDebugMode: Boolean): TMBStateMutation()

    companion object {
        val enableDebugMode = setDebugMode(true)
        val disableDebugMode = setDebugMode(false)
    }
}
