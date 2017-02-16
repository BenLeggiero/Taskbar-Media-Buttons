package org.bh.app.taskbarMediaButtons.launch

import org.bh.tools.io.setup.CommandLineArg
import org.bh.tools.io.setup.CommandLineArgProcessor
import org.bh.tools.io.setup.CommandlineArgCollection

/**
 * @author Kyli Rouge
 * @since 2017-02-16
 */

object commandLineArguments : CommandlineArgCollection() {
    override val args: Array<CommandLineArg<*>> = arrayOf()
}


object commandLineArgumentProcessor: CommandLineArgProcessor(commandLineArguments)