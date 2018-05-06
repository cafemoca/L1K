package cm.moca.l1k

import cm.moca.l1k.server.GameServer
import kotlin.system.exitProcess

fun main(args: Array<String>) {

    try {
        GameServer
    } catch (e: Exception) {
        exitProcess(0)
    }

}
