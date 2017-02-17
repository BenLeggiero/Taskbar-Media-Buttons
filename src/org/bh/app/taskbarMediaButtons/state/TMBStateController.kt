package org.bh.app.taskbarMediaButtons.state

import org.bh.app.taskbarMediaButtons.io.TMBDataAccessor
import org.bh.tools.base.state.StateController
import org.bh.tools.io.logging.log

/**
 * @author Ben Leggiero
 * @since 2017-02-17
 */
class TMBStateController(baseState: TMBState): StateController<TMBState, TMBStateMutation> {

    private val store = TMBStateStore(baseState)
    private val mutator = TMBStateMutator()

    override fun currentState(): TMBState = store.currentState()

    override fun mutate(action: TMBStateMutation) = store.pushState(mutator.mutating(currentState(), action))



    companion object {
        private var _shared: TMBStateController? = null


        /**
         * Calls [didGetOrCreate] with a new or premade [TMBStateController].
         * **If that's not possible, a warning is logged and the callback isn't called.**
         * Once a value is given, then that value will always be given in further calls.
         */
        fun shared(accessor: TMBDataAccessor = TMBDataAccessor.shared, didGetOrCreate: DidGetOrCreateStateController) {
            _shared?.let {
                didGetOrCreate(it)
                return
            }
            accessor.accessData(TMBDataAccessor.Details.fetchAllData) { data, status ->
                if (data != null) {
                    val newShared = TMBStateController(TMBState(data))
                    _shared = newShared
                    didGetOrCreate(newShared)
                } else {
                    log.warning("Could not fetch Taskbar Media Buttons raw state: $status")
                }
            }
        }

        infix fun shared(rhs: DidGetOrCreateStateController) = shared(didGetOrCreate = rhs)
    }
}



typealias DidGetOrCreateStateController = TMBStateController.() -> Unit
