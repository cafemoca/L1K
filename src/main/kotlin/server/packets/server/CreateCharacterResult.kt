package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.packets._ServerOpcode

class CreateCharacterResult(reason: Reason) : _ServerPacket() {

    init {
        writeOpcode(_ServerOpcode.S_CREATE_CHARACTER_CHECK.value)
        writeByte(reason.value)
        writeInt(0)
        writeInt(0)
    }

    enum class Reason(val value: Int) {
        REASON_OK(0x02),
        REASON_ALREADY_EXSISTS(0x06),
        REASON_INVALID_NAME(0x09),
        REASON_WRONG_AMOUNT(0x15),
    }

}
