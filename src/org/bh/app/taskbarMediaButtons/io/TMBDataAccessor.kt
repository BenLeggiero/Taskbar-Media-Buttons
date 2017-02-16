package org.bh.app.taskbarMediaButtons.io

import org.bh.app.taskbarMediaButtons.state.TMBState
import org.bh.tools.base.struct.DataAccessor

/**
 * @author Kyli Rouge
 * @since 2017-02-16 016.
 */
class TMBDataAccessor : DataAccessor<TMBState, TMBDataAccessor.Details, TMBDataAccessor.Status> {


    override fun accessData(details: Details, didAccessData: (accessedData: TMBState?, status: Status) -> Unit) {
        didAccessData(null, Status.successful) // FIXME: Actually access data
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


