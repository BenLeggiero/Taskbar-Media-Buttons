package org.bh.app.taskbarMediaButtons.io

import org.bh.app.taskbarMediaButtons.state.TMBRawState
import org.bh.app.taskbarMediaButtons.ui.tray.SystemTrayButton
import org.bh.app.taskbarMediaButtons.ui.tray.buttons.PauseTrayButton
import org.bh.tools.base.math.geometry.FractionSize
import org.bh.tools.base.struct.DataAccessor

/**
 * @author Ben Leggiero
 * @since 2017-02-16
 */
class TMBDataAccessor : DataAccessor<TMBRawState, TMBDataAccessor.Details, TMBDataAccessor.Status> {


    override fun accessData(details: Details, didAccessData: (accessedData: TMBRawState?, status: Status) -> Unit) {
        didAccessData(TMBRawState.default, Status.successful) // FIXME: Actually access data
    }


    companion object {
        val shared = TMBDataAccessor()
    }


    enum class Details {
        /**
         * Instruct accessor to fetch the entirety of the app's state
         */
        fetchAllData
    }



    enum class Status {
        /** All data was fetched */
        successful,

        /** No data was fetched */
        failure
    }
}



val TMBRawState.Companion.default by lazy { TMBRawState(DEFAULT_TRAY_BUTTONS, defaultIsDebugMode) }

private val DEFAULT_TRAY_BUTTONS: List<SystemTrayButton> = listOf(PauseTrayButton(FractionSize(16)))
private val defaultIsDebugMode = false
