package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.packets._ServerOpcode

class CharacterCount(count: Int, maxSlot: Int) : _ServerPacket() {

    init {
        writeOpcode(_ServerOpcode.S_NUM_CHARACTER.value)
        writeByte(count)
        writeByte(maxSlot)
    }

}
