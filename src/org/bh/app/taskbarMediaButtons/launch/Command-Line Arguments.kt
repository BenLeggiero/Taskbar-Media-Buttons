package org.bh.app.taskbarMediaButtons.launch

import org.bh.app.taskbarMediaButtons.state.TMBStateController
import org.bh.app.taskbarMediaButtons.state.TMBStateMutation.Companion.enableDebugMode
import org.bh.tools.io.setup.*

/**
 * @author Ben Leggiero
 * @since 2017-02-16
 */

object commandLineArguments : CommandlineArgCollection() {
    val debugArg = CompleteCommandLineArg('d', "debug", "Enables Debug mode", { _ ->
        TMBStateController.shared { mutate(enableDebugMode) }
    })

    override val args: Array<CommandLineArg<*>> = arrayOf(
            debugArg
    )
}


object commandLineArgumentProcessor : CommandLineArgProcessor(commandLineArguments)