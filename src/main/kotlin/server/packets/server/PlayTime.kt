package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.packets.ServerOpcode

class PlayTime : ServerPacket() {

    init {
        writeOpcode(ServerOpcode.S_EVENT.value)
        writeByte(0x3D)
        writeByte(0)
    }

}
