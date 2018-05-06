package cm.moca.l1k.server

import io.ktor.network.sockets.Socket
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel
import kotlinx.coroutines.experimental.io.readUTF8Line
import kotlinx.coroutines.experimental.launch

class GameClient(private val socket: Socket) {

    private val input get() = socket.openReadChannel()
    private val output get() = socket.openWriteChannel()

    init {
        launch {
            run()
        }
    }

    suspend fun run() {
        try {
            while (true) {
                val text = input.readUTF8Line()
                println(text)
            }
        } catch (e: Exception) {
        } finally {
            close()
        }
    }

    fun close() {
        socket.close()
        socket.dispose()
    }

}
