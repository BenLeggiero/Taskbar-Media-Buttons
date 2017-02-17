package org.bh.app.taskbarMediaButtons

import org.bh.app.taskbarMediaButtons.launch.AppDelegate
import org.bh.app.taskbarMediaButtons.launch.commandLineArgumentProcessor

/**
 * @author Ben Leggiero
 * @since 2017-02-16
 */

fun main(args: Array<String>) {
    commandLineArgumentProcessor.process(args)
    AppDelegate().start()
}
