package cm.moca.l1k.server

import io.ktor.network.sockets.aSocket
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import java.net.InetSocketAddress

object GameServer {

    init {
        run()
    }

    fun run() {
        runBlocking {
            val server = aSocket().tcp().bind(InetSocketAddress("127.0.0.1", 2000))
            while (true) {
                val socket = server.accept()
                launch {
                    val client = GameClient(socket)
                }
            }
        }
    }

}
