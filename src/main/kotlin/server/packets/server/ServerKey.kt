package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.packets._ServerOpcode

class ServerKey(key: Int) : _ServerPacket() {

    init {
        writeOpcode(_ServerOpcode.S_KEY.value)
        writeInt(key)
    }

}
