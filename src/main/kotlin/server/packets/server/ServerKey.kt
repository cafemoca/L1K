package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.packets.Opcode

class ServerKey(key: Int) : _ServerPacket() {

    init {
        writeOpcode(Opcode.S_KEY.value)
        writeInt(key)
    }

}
