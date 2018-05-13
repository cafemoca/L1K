package cm.moca.l1k.server.packets.client

import cm.moca.l1k.server.packets.PacketHandler
import kotlinx.coroutines.experimental.io.ByteBuffer

class UnknownPacket(buffer: ByteBuffer) : ClientPacket(buffer) {

    fun action(handler: PacketHandler) {
        println("unknown packet: $opcode:$protocol")
    }

}
