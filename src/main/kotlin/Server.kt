package cm.moca.l1k

import cm.moca.l1k.server.GameServer
import io.ktor.application.Application
import kotlin.system.exitProcess

fun Application.main() {

    try {
        GameServer
    } catch (e: Exception) {
        exitProcess(0)
    }

}
