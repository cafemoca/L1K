package cm.moca.l1k.server

import cm.moca.l1k.server.packets.PacketBlowfish
import cm.moca.l1k.server.packets.PacketHandler
import cm.moca.l1k.server.packets.server.ServerKey
import cm.moca.l1k.server.packets.server.ServerPacket
import io.ktor.network.sockets.Socket
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.io.writeByte
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

class GameClient(private val socket: Socket) {

    private var input = socket.openReadChannel()
    private val output = socket.openWriteChannel()

    private val handler = PacketHandler(this)
    private var blowfish: PacketBlowfish? = null

    init {
        val key = (Math.random() * 2147483647).toInt()
        blowfish = PacketBlowfish(key.toLong())
        val packet = ServerKey(key)
        val content = packet.content
        launch {
            output.run {
                val size = packet.size + 2
                writeByte(size and 0xFF)
                writeByte((size shl 8) and 0xFF)
                writeAvailable(content)
                flush()
            }
            run()
        }
    }

    private suspend fun run() {
        try {
            while (true) {
                val data = receive()
                handler.receive(data)
            }
        } catch (e: Exception) {
        } finally {
            close()
        }
    }

    private suspend fun receive(): ByteArray {
        return runBlocking {
            val low = input.readByte()
            val high = input.readByte()
            val size = ((high * 256 + low) and 0xFF) - 2
            var data = ByteArray(size)
            input.readFully(data, 0, size)
            blowfish!!.decrypt(data)
        }
    }

    fun send(packet: ServerPacket) {
        runBlocking {
            val content = packet.content
            blowfish!!.encrypt(content)
            output.run {
                val size = packet.size + 2
                writeByte(size and 0xFF)
                writeByte((size shl 8) and 0xFF)
                writeAvailable(content)
                flush()
            }
        }
    }

    private fun close() {
        socket.close()
        socket.dispose()
        //this.close()
    }

}
