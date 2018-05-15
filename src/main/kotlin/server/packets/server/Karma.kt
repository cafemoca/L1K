package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.packets.ServerOpcode

class Karma(value: Int) : ServerPacket() {

    init {
        writeByte(ServerOpcode.S_EVENT.value)
        writeByte(0x57) // karma?
        writeInt(value)
    }

}
