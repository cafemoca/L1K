package cm.moca.l1k.server.packets

import cm.moca.l1k.server.GameClient
import cm.moca.l1k.server.packets.client.*

class PacketHandler(private val client: GameClient) {

    fun handlePacket(data: ByteArray) {
        val opcode = data[4].toInt() and 0xFF
        when (opcode) {
            Opcode.C_LOGIN.value -> AccountLogin(data, client)
            Opcode.C_EXTENDED_PROTOBUF.value -> {
                val hb = data[5]
                val lb = data[6]
                val excode = lb * 256 + hb
                when (excode) {
                    ProtocolId.CS_CLIENT_VERSION_INFO.value -> VersionCheck(data, client)
                }
            }
        }
    }

}
