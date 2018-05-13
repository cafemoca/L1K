package cm.moca.l1k.server.packets.client

import cm.moca.l1k.server.GameClient
import cm.moca.l1k.server.packets.PacketHandler
import cm.moca.l1k.server.packets.server.ServerVersionInfo
import kotlinx.coroutines.experimental.io.ByteBuffer

class VersionCheck(buffer: ByteBuffer) : ClientPacket(buffer) {

    init {
    }

    fun action(handler: PacketHandler) {
        handler.send(ServerVersionInfo())
    }

}
