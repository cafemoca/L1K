package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.packets.ServerOpcode

class MapInfo(mapId: Int) : ServerPacket() {

    init {
        writeOpcode(ServerOpcode.S_EXTENDED_PROTOBUF.value)
        writeByte(118)
        writeByte(0)
        writeByte(0x08)
        writeNumber(mapId)
        writeByte(0x10)
        writeByte(0x0)
        writeByte(0x18)
        writeBoolean(false) //if (isUnderwater) 1 else 0)
        writeByte(0x20)
        writeByte(0)
        writeByte(0x28)
        writeByte(0x00)
        writeByte(0x30)
        writeByte(0x00)
        writeShort(0)
    }

}
