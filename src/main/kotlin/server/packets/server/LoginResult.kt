package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.packets.Opcode

class LoginResult : _ServerPacket() {

    init {
        writeOpcode(Opcode.S_LOGIN_CHECK.value)
        writeByte(0x00)
        writeInt(0)
        writeInt(0)
        writeInt(0)
    }

}
