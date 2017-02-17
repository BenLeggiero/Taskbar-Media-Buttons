package org.bh.app.taskbarMediaButtons.state

import org.bh.app.taskbarMediaButtons.ui.SystemTrayIcon
import org.bh.tools.base.state.ChangeableState
import org.bh.tools.base.state.StateChange
import org.bh.tools.base.struct.DataView

/**
 * @author Ben Leggiero
 * @since 2017-02-17 017.
 */
data class TMBState(
        override val data: TMBRawState
) : DataView<TMBRawState>,
ChangeableState<TMBState, TMBStateChange> {
    inline val systemTrayIcons get() = data.systemTrayIcons
    inline val isDebugMode get() = data.isDebugMode


    constructor(systemTrayIcons: List<SystemTrayIcon>, isDebugMode: Boolean) : this(TMBRawState(
            systemTrayIcons = systemTrayIcons,
            isDebugMode = isDebugMode)
    )


    override val changeValue: TMBStateChange by lazy { TMBStateChange(
                systemTrayIcons = systemTrayIcons,
                isDebugMode = isDebugMode)
    }


    override fun applyingChange(change: TMBStateChange): TMBState = TMBState(
            systemTrayIcons = change.systemTrayIcons ?: this.systemTrayIcons,
            isDebugMode = change.isDebugMode ?: this.isDebugMode
    )


    fun applyingChange(systemTrayIcons: List<SystemTrayIcon>? = null, isDebugMode: Boolean? = null): TMBState
            = applyingChange(TMBStateChange(
            systemTrayIcons = systemTrayIcons,
            isDebugMode = isDebugMode
    ))
}

data class TMBStateChange(
        val systemTrayIcons: List<SystemTrayIcon>? = null,
        val isDebugMode: Boolean? = null
) : StateChange<TMBStateChange, TMBState> {

    override fun applyingChange(change: TMBStateChange): TMBStateChange = TMBStateChange(
            systemTrayIcons = change.systemTrayIcons ?: systemTrayIcons,
            isDebugMode = change.isDebugMode ?: isDebugMode
    )


    fun applyingChange(systemTrayIcons: List<SystemTrayIcon>? = null, isDebugMode: Boolean? = null): TMBStateChange
            = applyingChange(TMBStateChange(
            systemTrayIcons = systemTrayIcons,
            isDebugMode = isDebugMode
    ))
}
