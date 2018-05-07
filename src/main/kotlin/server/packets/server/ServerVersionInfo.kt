package cm.moca.l1k.server.packets.server

import cm.moca.l1k.server.packets.ProtocolId
import cm.moca.l1k.server.packets.Opcode

class ServerVersionInfo : _ServerPacket() {

    init {
        writeOpcode(Opcode.S_EXTENDED_PROTOBUF.value)
        writeShort(ProtocolId.SC_SERVER_VERSION_INFO.value)
    }

}
