package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.packets.Opcode

class CharacterCount(count: Int, maxSlot: Int) : _ServerPacket() {

    init {
        writeByte(Opcode.S_NUM_CHARACTER.value)
        writeByte(count)
        writeByte(maxSlot)
    }

}
