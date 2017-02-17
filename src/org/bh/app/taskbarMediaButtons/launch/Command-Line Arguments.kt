package org.bh.app.taskbarMediaButtons.launch

import org.bh.app.taskbarMediaButtons.Constants
import org.bh.app.taskbarMediaButtons.state.TMBStateController
import org.bh.app.taskbarMediaButtons.state.TMBStateMutation.Companion.enableDebugMode
import org.bh.tools.io.setup.*

/**
 * @author Ben Leggiero
 * @since 2017-02-16
 */

object CommandLineArguments : CommandlineArgCollection() {
    val debugArg = CompleteCommandLineArg('d', "debug", "Enables Debug mode", { _ ->
        TMBStateController.shared { mutate(enableDebugMode) }
    })

    override val args: Array<CommandLineArg<*>> by lazy {
        val allButHelp: List<CommandLineArg<*>> = listOf(debugArg)
        val help = CommandLineArg.Defaults.HelpArg(Constants.executableName, allButHelp, 80, System.out)

        /*return*/ (allButHelp + help).toTypedArray()
    }
}


object CommandLineArgumentProcessor : CommandLineArgProcessor(CommandLineArguments)