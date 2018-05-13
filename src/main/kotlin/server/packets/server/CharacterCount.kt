package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.packets.ServerOpcode

class CharacterCount(count: Int, maxSlot: Int) : ServerPacket() {

    init {
        writeOpcode(ServerOpcode.S_NUM_CHARACTER.value)
        writeByte(count)
        writeByte(maxSlot)
    }

}
