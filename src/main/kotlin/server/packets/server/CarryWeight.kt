package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.packets.ServerOpcode

class CarryWeight(current: Int, max: Int) : ServerPacket() {

    init {

        writeByte(ServerOpcode.S_EXTENDED_PROTOBUF.value)
        writeByte(0xE5)
        writeByte(0x01)
        writeByte(0x08)
        writeByte(current / max)
        writeByte(0x10)
        writeBigNumber(current)
        writeByte(0x18)
        writeBigNumber(max)
        writeShort(0x0000)
    }

}
