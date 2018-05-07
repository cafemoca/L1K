package cm.moca.l1k.server.packets.client

import cm.moca.l1k.server.GameClient
import cm.moca.l1k.server.packets.server.ServerVersionInfo

class VersionCheck(data: ByteArray, client: GameClient) : _ClientPacket(data) {

    init {
        client.sendPacket(ServerVersionInfo())
    }

}
