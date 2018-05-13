package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.packets.ServerOpcode

class ServerKey(key: Int) : ServerPacket() {

    init {
        writeOpcode(ServerOpcode.S_KEY.value)
        writeInt(key)
    }

}
