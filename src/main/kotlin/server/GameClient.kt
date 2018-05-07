package cm.moca.l1k.server

import cm.moca.l1k.server.packets.Blowfish
import cm.moca.l1k.server.packets.PacketHandler
import cm.moca.l1k.server.packets.server.ServerKey
import cm.moca.l1k.server.packets.server._ServerPacket
import io.ktor.network.sockets.Socket
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.io.writeByte
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

class GameClient(private val socket: Socket) {

    private val input = socket.openReadChannel()
    private val output = socket.openWriteChannel()

    private val handler = PacketHandler(this)

    private var blowfish: Blowfish? = null

    init {
        launch {
            val key = (Math.random() * 2147483647).toInt()
            blowfish = Blowfish(key.toLong())
            sendRawPacket(ServerKey(key))
            run()
        }
    }

    suspend fun run() {
        try {
            while (true) {
                val data = readPacket()
                handler.handlePacket(data)
            }
        } catch (e: Exception) {
        } finally {
            close()
        }
    }

    private suspend fun readPacket(): ByteArray {
        return async {
            val low = input.readByte()
            val high = input.readByte()
            val size = ((high * 256 + low) and 0xFF) - 2
            var data = ByteArray(size)
            input.readFully(data, 0, size)
            blowfish!!.decrypt(data)
        }.await()
    }

    fun sendRawPacket(packet: _ServerPacket) {
        runBlocking {
            val content = packet.content
            output.run {
                val size = packet.size + 2
                writeByte(size and 0xFF)
                writeByte((size shl 8) and 0xFF)
                writeAvailable(content)
                flush()
            }
        }
    }

    fun sendPacket(packet: _ServerPacket) {
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

    fun close() {
        socket.close()
        socket.dispose()
    }

}
