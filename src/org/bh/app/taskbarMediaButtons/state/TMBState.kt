package org.bh.app.taskbarMediaButtons.state

import org.bh.app.taskbarMediaButtons.ui.tray.SystemTrayButton
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
    inline val systemTrayIcons get() = data.systemTrayButtons
    inline val isDebugMode get() = data.isDebugMode


    constructor(systemTrayButtons: List<SystemTrayButton>, isDebugMode: Boolean) : this(TMBRawState(
            systemTrayButtons = systemTrayButtons,
            isDebugMode = isDebugMode)
    )


    override val changeValue: TMBStateChange by lazy { TMBStateChange(
                systemTrayButtons = systemTrayIcons,
                isDebugMode = isDebugMode)
    }


    override fun applyingChange(change: TMBStateChange): TMBState = TMBState(
            systemTrayButtons = change.systemTrayButtons ?: this.systemTrayIcons,
            isDebugMode = change.isDebugMode ?: this.isDebugMode
    )


    fun applyingChange(systemTrayButtons: List<SystemTrayButton>? = null, isDebugMode: Boolean? = null): TMBState
            = applyingChange(TMBStateChange(
            systemTrayButtons = systemTrayButtons,
            isDebugMode = isDebugMode
    ))
}

data class TMBStateChange(
        val systemTrayButtons: List<SystemTrayButton>? = null,
        val isDebugMode: Boolean? = null
) : StateChange<TMBStateChange, TMBState> {

    override fun applyingChange(change: TMBStateChange): TMBStateChange = TMBStateChange(
            systemTrayButtons = change.systemTrayButtons ?: systemTrayButtons,
            isDebugMode = change.isDebugMode ?: isDebugMode
    )


    fun applyingChange(systemTrayButtons: List<SystemTrayButton>? = null, isDebugMode: Boolean? = null): TMBStateChange
            = applyingChange(TMBStateChange(
            systemTrayButtons = systemTrayButtons,
            isDebugMode = isDebugMode
    ))
}
