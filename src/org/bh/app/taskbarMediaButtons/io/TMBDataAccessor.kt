package org.bh.app.taskbarMediaButtons.io

import org.bh.app.taskbarMediaButtons.state.TMBRawState
import org.bh.app.taskbarMediaButtons.ui.SystemTrayIcon
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



val TMBRawState.Companion.default by lazy { TMBRawState(defaultTrayIcons, defaultIsDebugMode) }

private val defaultTrayIcons: List<SystemTrayIcon> = listOf()
private val defaultIsDebugMode = false
